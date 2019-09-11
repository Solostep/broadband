package personal.buildbroad;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import personal.buildbroad.base.BaseActivity;

/**
 * Created by liyn18 on 18-4-18.
 */

public class SocketActivity extends BaseActivity {

    private TextView socketText;

    private static final String HOST = "192.168.11.1";
    private static final int PORT = 8888;
    private PrintWriter printWriter;
    private BufferedReader in;
    private ExecutorService mExecutorService = null;
    private String receiveMsg;
    private static final String TAG = "tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        socketText = (TextView) findViewById(R.id.socket_text);
        mExecutorService =  Executors.newCachedThreadPool();
    }

    public void onSocketConnect(View view){
        switch (view.getId()){
            case R.id.socket_connect:
                mExecutorService.execute(new ConnectService());
                break;
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_socket;
    }

    private class ConnectService implements Runnable {
        @Override
        public void run() {
            try {
                Socket socket = new Socket(HOST, PORT);
                socket.setSoTimeout(30000);
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream())), true);
                printWriter.println("network\0");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                receiveMsg();
            } catch (Exception e) {
                Log.e(TAG, ("connectService:" + e.getMessage()));
            }
        }
    }

    private void receiveMsg() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                if ((receiveMsg = in.readLine()) != null) {
                    Log.d(TAG, "receiveMsg:" + receiveMsg);
                    stringBuilder.append(receiveMsg);
                    if (receiveMsg.equals("}")) {
                        printWriter.println("quit\0");
                        break;
                    }
                }
            }
            Log.d(TAG, "stringBuilder:" + stringBuilder.toString());
        } catch (IOException e) {
            Log.e(TAG, "receiveMsg: ");
            e.printStackTrace();
        }
    }
}
