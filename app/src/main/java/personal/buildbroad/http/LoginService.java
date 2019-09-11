package personal.buildbroad.http;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import personal.buildbroad.common.AppConstant;
import personal.buildbroad.model.Result;
import personal.buildbroad.utils.JsonUtils;
import personal.buildbroad.utils.StringUtils;

/**
 * Created by shan on 2018/3/15.
 */

public class LoginService {


    public static void sendCode(String phone, int templateId, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("phone", phone);
            params.put("templateId", templateId);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/sendCode", params, new BaseServiceCallBack<String>() {
                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
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

    public static void userRegister(String phone, String password, String code, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("phone", phone);
            params.put("password", password);
            params.put("code", code);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/userRegister", params, new BaseServiceCallBack<String>() {
                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
                }


                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }
            });
        } catch (Exception e) {

        }
    }

    public static void userLogin(String phone, String password, final ServiceCallBack<Map<String, Object>> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("phone", phone);
            params.put("password", password);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/userLogin", params, new BaseServiceCallBack<Map<String, Object>>() {

                @Override
                public void onSuccess(Result result) {
                    Map<String, Object> map = null;
                    if ("200".equals(result.getStatusCode())) {
                        map = JsonUtils.toMap(result.getResult());
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

        }
    }

    public static void updateUserPwdByPhoneNo(String phone, String password, String code, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("phone", phone);
            params.put("pwd", password);
            params.put("code", code);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/updateUserPwdByPhoneNo", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    serviceCallBack.onError();
                }
            });

        } catch (Exception e) {

        }
    }

    public static void updateUserPwd(String userId, String newPw, String srcPw, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            params.put("newPw", newPw);
            params.put("srcPw", srcPw);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/updateUserPwd", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
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

    public static void addFeeBack(String userId, String content, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            params.put("content", content);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/feedback/addFeeBack", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
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

    public static void updateUserInfo(String userId, String userName, String address, String email, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", userId);
            params.put("userName", userName);
            params.put("address", address);
            params.put("email", email);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/updateUserInfo", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
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

    public static void uploadPhoto(File file, final ServiceCallBack<Map<String, Object>> serviceCallBack) {
        try {
            OkHttpUtils.post().addFile("file", file.getName(), file)
                    .url(AppConstant.REMOTE_URL + "/api/file/uploadPhoto").build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    serviceCallBack.onError();
                }

                @Override
                public void onResponse(String response, int id) {
                    if (StringUtils.isNotBlank(response)) {
                        Map map = JsonUtils.toMap(response);
                        serviceCallBack.onSuccess(AppConstant.SUCCESS_STATUS_CODE, map);
                    } else {
                        serviceCallBack.onSuccess("-1", null);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addIdInfo(String userId, String userName, String idNo, String idNoPhoto1, final ServiceCallBack<String> serviceCallBack) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", userId);
            params.put("userName", userName);
            params.put("idNo", idNo);
            params.put("idNoPhoto1", idNoPhoto1);
            ServiceRequestUtil.postString(AppConstant.REMOTE_URL + "/api/user/addIdInfo", params, new BaseServiceCallBack<String>() {

                @Override
                public void onSuccess(Result result) {
                    serviceCallBack.onSuccess(result.getStatusCode(), result.getResult());
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
}
