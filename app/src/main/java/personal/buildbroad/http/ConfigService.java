package personal.buildbroad.http;

import android.util.Log;


import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

import personal.buildbroad.common.AppConstant;
import personal.buildbroad.model.Result;
import personal.buildbroad.utils.JsonUtils;

/**
 * Created by liyn18 on 18-4-13.
 */

public class ConfigService {

    public static void getApConfData(String apAddress,String apmac , final ServiceCallBack<Map<String, Object>> serviceCallBack){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("apmac", apmac);
            ServiceRequestUtil.postString(apAddress + "/api/Devices/apConfData/", params, new BaseServiceCallBack<String>() {
                @Override
                public void onSuccess(Result result) {
                    Log.d("tag",result.toString());
                    Map<String, Object> map = null;
                    if (null!=result.getStatusCode()&&!"".equals(result.getStatusCode())){
                        if (AppConstant.SUCCESS_STATUS_CODE.equals(result.getStatusCode())){
                            map = JsonUtils.toMap(result.getResult());
                        }else{
                            map = new HashMap<>();
                            map.put("statusCode",result.getStatusCode());
                            map.put("message",result.getMessage());
                        }
                    }else{
                        if (null!=result.getErrcode()&&!"".equals(result.getErrcode())){
                            map = new HashMap<>();
                            map.put("statusCode",result.getErrcode());
                            map.put("message",result.getErrmsg());
                        }
                    }
                    serviceCallBack.onSuccess(result.getStatusCode(), map);
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveConfigureData(String apAddress,String apid, String apmac, String confid, String updateway, String master,
                                        String tel, String usergroup_id, String usergroup_children,String apGroupId,String village,String address,String type,String remac ,final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("apid", apid);
            params.put("apmac", apmac);
            params.put("confid", confid);
            params.put("updateway", updateway);
            params.put("master", master);
            params.put("tel", tel);
            params.put("usergroup_id", usergroup_id);
            params.put("usergroup_children", usergroup_children);
            params.put("village", village);
            params.put("address", address);
            params.put("type",type);
            params.put("remac",remac);
            params.put("apgroup",apGroupId);
            ServiceRequestUtil.postString(apAddress + "/api/Devices/configureDev/", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    Log.d("tag","configureDev："+result);
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getMessage());
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getConfigData(String apAddress,String apmac ,String remac, final ServiceCallBack<Map<String, Object>> serviceCallBack){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("apmac", apmac);
            params.put("remac",remac);
            ServiceRequestUtil.postString(apAddress + "/api/Devices/getApConf/", params, new BaseServiceCallBack<String>() {
                @Override
                public void onSuccess(Result result) {
                    Log.d("tag",result.toString());
                    Map<String, Object> map = null;
                    if (null!=result.getStatusCode()&&!"".equals(result.getStatusCode())){
                        if (AppConstant.SUCCESS_STATUS_CODE.equals(result.getStatusCode())){
                            map = JsonUtils.toMap(result.getResult());
                        }else{
                            map = new HashMap<>();
                            map.put("statusCode",result.getStatusCode());
                            map.put("message",result.getMessage());
                        }
                    }else{
                        if (null!=result.getErrcode()&&!"".equals(result.getErrcode())){
                            map = new HashMap<>();
                            map.put("statusCode",result.getErrcode());
                            map.put("message",result.getErrmsg());
                        }
                    }
                    serviceCallBack.onSuccess(result.getStatusCode(), map);
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getOrderList(final ServiceCallBack<String> serviceCallBack){
        try {

            ServiceRequestUtil.getStringByOrder("http://36.110.85.93:5088/sdwanmoney/orders", new OrderServiceCallBack<String>() {

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }

                @Override
                public void onSuccess(String str) {
                    Log.d("tag service",str);
                    serviceCallBack.onSuccess(str);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
