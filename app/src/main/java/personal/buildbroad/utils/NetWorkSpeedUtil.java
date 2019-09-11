package personal.buildbroad.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liyn18 on 18-4-25.
 */

public class NetWorkSpeedUtil {
    private Context context;
    private Handler mHandler;
    private String mAddr = "http://dlsw.baidu.com/sw-search-sp/soft/0f/15120/winzip19_new_V30.0.11475.0.1438163375.exe";
    private String mAddr2 = "http://gdown.baidu.com/data/wisegame/baidusearch_Android_10189_1399k.apk";
    private float mSpeedContent;
    private static final int STOP = 0x112;
    private int number = 0;
    private int mProgressState;


    public NetWorkSpeedUtil(Context context, Handler mHandler){
        this.context = context;
        this.mHandler = mHandler;
    }

    public void startShowNetSpeed(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(!showNetSpeed(mAddr)){
                    number = 1;
                    showNetSpeed(mAddr2);
                }
            }
        }).start();
    }

    private boolean showNetSpeed(String httpUrl) {
        int fileLen = 0;
        long startTime = 0;
        long endTime = 0;
        final String fileName = "tmp.exe";
        HttpURLConnection conn = null;
        InputStream is = null;
        FileOutputStream fos = null;
        File tmpFile = new File("/sdcard/temp");
        if (!tmpFile.exists()) {
            tmpFile.mkdir();
        }
        final File file = new File("/sdcard/temp/" + fileName);
        try {
            URL url = new URL(httpUrl);
            try {
                conn = (HttpURLConnection) url.openConnection();
                Log.d("tag","loading");
                fileLen = conn.getContentLength();
                Log.d("tag","len=" + fileLen);
                if (fileLen <= 0) {
                    mSpeedContent = 0;
                    if(number==1){
                        ToastUtils.showShort("请求失败");
                        return true;
                    }
                    return false;
                }
                startTime = System.currentTimeMillis();
                is = conn.getInputStream();
                fos = new FileOutputStream(file);
                byte[] buf = new byte[256];
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                    if(number==1){
                        ToastUtils.showShort("请求超时");
                        return true;
                    }
                    return false;
                } else {
                    while (true) {
                        if (is != null) {
                            int numRead = is.read(buf);
                            if (numRead <= 0) {
                                break;
                            } else {
                                fos.write(buf, 0, numRead);
                            }
                            mProgressState += (int) (((numRead + 0.0) / (fileLen + 0.0)) * 1000000);
                        } else {
                            break;
                        }
                    }
                }
                endTime = System.currentTimeMillis();
            } catch (IOException e) {
                e.printStackTrace();
                ToastUtils.showShort("没有权限！");
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
                try {
                    if (fos != null) {
                        fos.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        mSpeedContent = fileLen / (endTime - startTime);
        Message msg = mHandler.obtainMessage();
        msg.what = STOP;
        msg.obj = String.valueOf(mSpeedContent);
        mHandler.sendMessage(msg);
        return true;
    }
}
