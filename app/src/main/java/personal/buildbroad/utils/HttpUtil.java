package personal.buildbroad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by liyn18 on 18-5-9.
 */

public class HttpUtil {
    /**
     * 检测网络是否可用
     * @param context
     * @return
     */
    public static boolean isConnect(Context context) {
        boolean _isConnect = false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            _isConnect = conManager.getActiveNetworkInfo().isAvailable();
        }
        return _isConnect;
    }
}
