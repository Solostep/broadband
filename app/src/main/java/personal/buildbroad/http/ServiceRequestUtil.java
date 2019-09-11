package personal.buildbroad.http;


import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import okhttp3.Call;
import personal.buildbroad.APP;
import personal.buildbroad.model.Result;
import personal.buildbroad.utils.JsonUtils;
import personal.buildbroad.utils.MD5Util;
import personal.buildbroad.utils.SpUtils;

public class ServiceRequestUtil {

    public static void postString(String url, Map<String, Object> params, final IBaseServiceCallBack<?> serviceCallBack) {

        try {
            PostFormBuilder postFormBuilder = OkHttpUtils.post().url(url);
/*            String userId = SpUtils.get(APP.getContext(), "userId", "") + "";
            if (StringUtils.isNotBlank(userId)) {
                if (!params.containsKey("userId")) {
                    params.put("useId", userId);
                }
            }*/
            params.put("iusername","weixin");
            params.put("ipassword","weixin");
            params.put("timestamp", new Date().getTime());
            params.put("sign", createSign(new TreeMap<String, Object>(params), SpUtils.get(APP.getContext(), "token", "") + ""));
           // String ss = params.toString();
            Logger.e(params.toString());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                postFormBuilder.addParams(entry.getKey(), entry.getValue() + "");
            }
            postFormBuilder.build().execute(new StringCallback() {

                @Override
                public void onError(Call call, Exception e, int id) {
                    serviceCallBack.onError(e);
                }

                @Override
                public void onResponse(String response, int id) {
                    Log.d("-----tag","response:"+response);
                    Result result = JsonUtils.toBean(response, Result.class);
                    serviceCallBack.onSuccess(result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static String createSign(SortedMap<String, Object> packageParams, String token) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = entry.getValue() + "";
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + token);
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;

    }


    public static void getStringByOrder(String url,  final IOrderServiceCallBack<?> serviceCallBack) {

        try {
            GetBuilder getBuilder = OkHttpUtils.get().url(url);
            getBuilder.addHeader("Accept","application/json");
            getBuilder.addHeader("Content-Type","application/json;charset=utf-8");
            getBuilder.addHeader("Content-Length","256");

            getBuilder.build().execute(new StringCallback() {

                @Override
                public void onError(Call call, Exception e, int id) {
                    serviceCallBack.onError(e);
                }

                @Override
                public void onResponse(String response, int id) {
                    Log.d("-----tag","response:"+response);
                    serviceCallBack.onSuccess(response);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
