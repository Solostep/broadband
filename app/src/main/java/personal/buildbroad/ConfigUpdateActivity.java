package personal.buildbroad;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ToastUtils;
import java.util.Map;

import personal.buildbroad.base.BaseActivity;
import personal.buildbroad.common.AppConstant;
import personal.buildbroad.http.ConfigService;
import personal.buildbroad.http.ServiceCallBack;
import personal.buildbroad.utils.ApConfigUtil;
import personal.buildbroad.utils.CheckDataUtil;
import personal.buildbroad.utils.HttpUtil;
import personal.buildbroad.utils.NetWorkSpeedUtil;
import personal.buildbroad.utils.StringUtils;

/**
 * Created by liyn18 on 18-5-8.
 */

public class ConfigUpdateActivity extends BaseActivity {
    private String apid,apmac;
    private TextView new_device_text,update_name_text,update_phone_text,config_info;
    private EditText update_name,update_phone,old_device;
    private Button testSpeedBtn,commit_btn;
    private ImageView speedImg;
    private RelativeLayout layInfo;
    private RadioButton effect_now;

    private static final int STOP = 0x112;
    private float mSpeedContent;
    private ObjectAnimator mCircleAnimator;

    private String groupid,childrenid,configid,groupName,childrenName,configName,village,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("更新用户配置信息");
        initData();
    }

    private void initData() {
        new_device_text = (TextView) findViewById(R.id.new_device_text);
        update_name_text = (TextView) findViewById(R.id.update_name_text);
        update_phone_text = (TextView) findViewById(R.id.update_phone_text);
        config_info = (TextView) findViewById(R.id.config_info);

        update_name = (EditText) findViewById(R.id.update_name);
        update_phone = (EditText) findViewById(R.id.update_phone);
        old_device = (EditText) findViewById(R.id.old_device);
        testSpeedBtn = (Button) findViewById(R.id.test_speed_btn);
        speedImg = (ImageView) findViewById(R.id.speed_img);
        commit_btn = (Button) findViewById(R.id.commit_btn);
        layInfo = (RelativeLayout) findViewById(R.id.lay_info);
        effect_now = (RadioButton) findViewById(R.id.effect_now);

        String saveName = String.valueOf(getSp("name",""));
        if (StringUtils.isNotBlank(saveName)) {
            update_name.setText(saveName);
            update_name_text.setText(saveName);
            update_name_text.setVisibility(View.VISIBLE);
        }else{
            update_name.setVisibility(View.VISIBLE);
        }
        String savePhone = String.valueOf(getSp("phone",""));
        if (StringUtils.isNotBlank(savePhone)) {
            update_phone.setText(savePhone);
            update_phone_text.setText(savePhone);
            update_phone_text.setVisibility(View.VISIBLE);
        }else{
            update_phone.setVisibility(View.VISIBLE);
        }

        mCircleAnimator = ObjectAnimator.ofFloat(speedImg, "rotation", 0.0f, 360.0f);
        mCircleAnimator.setDuration(800);
        mCircleAnimator.setInterpolator(new LinearInterpolator());
        mCircleAnimator.setRepeatCount(-1);
        mCircleAnimator.setRepeatMode(ObjectAnimator.RESTART);

        apmac = ApConfigUtil.getWifiRouteMACAddress(this).replaceAll("-",":");
        //apmac="00:01:7A:35:0A:E7";
        //apmac="00:01:7A:32:2D:DA";
        if (StringUtils.isEmpty(apmac)){
            ToastUtils.showShort("网络错误,请连接wifi网络");
            return;
        }
        new_device_text.setText(apmac);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_config_update;
    }

    public void onLinearClick(final View view) {
        switch (view.getId()) {
            case R.id.get_info:
                getConfigData();
                break;
            case R.id.refresh_apmac_btn:
                apmac = ApConfigUtil.getWifiRouteMACAddress(this).replaceAll("-",":");
                if (StringUtils.isNotEmpty(apmac)){
                    new_device_text.setText(apmac);
                }else{
                    ToastUtils.showShort("网络错误,请连接wifi网络");
                }
                break;
            case R.id.test_speed_btn:
                if (!HttpUtil.isConnect(this)) {
                    ToastUtils.showShort("网络没有连接");
                }else{
                    speedImg.setVisibility(View.VISIBLE);
                    testSpeedBtn.setEnabled(false);
                    mCircleAnimator.start();
                    new NetWorkSpeedUtil(this,mProgressHandler).startShowNetSpeed();
                }
                break;
            case R.id.commit_btn:
                updateConfigData();
                break;
        }
    }

    private void updateConfigData() {
        if (StringUtils.isEmpty(apmac)){
            ToastUtils.showShort("请刷新设备！");
            return;
        }
        if (StringUtils.isBlank(update_name.getText().toString())) {
            ToastUtils.showShort("请输入姓名");
            return;
        }else{
            putSp("name", update_name.getText().toString() + "");
        }
        if (!CheckDataUtil.checkPhone(update_phone.getText().toString())) {
            return;
        }
        putSp("phone", update_phone.getText().toString() + "");
        String updateway = "1";
        if (!effect_now.isChecked()) {
            updateway = "2";
        }
        if (CheckDataUtil.checkMac(old_device.getText().toString())){
            String oldmac = getMacString(old_device.getText().toString());
            ConfigService.saveConfigureData(String.valueOf(getSp("apAddress","")),apid,apmac,configid,updateway,update_name.getText().toString(),update_phone.getText().toString(),groupid,childrenid,null,village,address,"2",oldmac, new ServiceCallBack<String>() {
                @Override
                public void onSuccess(String code, String result) {
                    super.onSuccess(code, result);
                    if (AppConstant.SUCCESS_STATUS_CODE.equals(code)) {
                        ToastUtils.showShort(result);
                        update_name_text.setText(update_name.getText().toString());
                        update_name.setVisibility(View.GONE);
                        update_name_text.setVisibility(View.VISIBLE);
                        update_phone_text.setText(update_phone.getText().toString());
                        update_phone.setVisibility(View.GONE);
                        update_phone_text.setVisibility(View.VISIBLE);
                    } else {
                        ToastUtils.showShort(result);
                    }
                }
                @Override
                public void onError() {
                    super.onError();
                    ToastUtils.showShort("网络错误，请稍后重试");
                }
            });
        }
    }

    private void getConfigData() {
        if (StringUtils.isBlank(apmac)){
            ToastUtils.showShort("请刷新设备！");
            return;
        }

        if (CheckDataUtil.checkMac(old_device.getText().toString())){
            String oldmac = getMacString(old_device.getText().toString());
            ConfigService.getConfigData(String.valueOf(getSp("apAddress","")),apmac,oldmac, new ServiceCallBack<Map<String, Object>>() {
                @Override
                public void onSuccess(String code, Map<String, Object> result) {
                    super.onSuccess(code, result);
                    if (AppConstant.SUCCESS_STATUS_CODE.equals(code)) {
                        ToastUtils.showShort(result.toString());

                        apid = (String) result.get("apid");
                        village = (String) result.get("village");
                        address = (String) result.get("address");
                        JSONObject group = (JSONObject) result.get("group");
                        JSONObject children = (JSONObject) result.get("children");
                        JSONObject config = (JSONObject) result.get("config");
                        groupid = group.getString("id");
                        groupName = group.getString("name");
                        childrenid = children.getString("id");
                        childrenName = group.getString("name");
                        configid = config.getString("ID");
                        configName = config.getString("name");

                        config_info.setText(getJoinData());
                        layInfo.setVisibility(View.VISIBLE);
                        commit_btn.setVisibility(View.VISIBLE);

                    } else {
                        Log.d("tag","getOldConfig: "+result.toString());
                        ToastUtils.showShort(String.valueOf(result.get("message")));
                    }
                }
                @Override
                public void onError() {
                    super.onError();
                    ToastUtils.showShort("网络错误，请稍后重试");
                }
            });

        }
    }

    private String  getMacString(String oldmac) {
        oldmac = old_device.getText().toString();
        if (!oldmac.contains("-")&&!oldmac.contains(":")){
            oldmac = oldmac.substring(0,2)+":"+oldmac.substring(2,4)+":"+oldmac.substring(4,6)+":"+oldmac.substring(6,8)+":"+oldmac.substring(8,10)+":"+oldmac.substring(10,12);
        }
        return oldmac;
    }

    private Handler mProgressHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            speedImg.setVisibility(View.GONE);
            testSpeedBtn.setEnabled(true);
            mCircleAnimator.end();
            switch (msg.what) {
                case STOP:
                    mSpeedContent = Float.parseFloat(msg.obj.toString());
                    setSpeed();
                    break;
                default:
                    break;
            }
        }

    };

    private void setSpeed() {
        if (mSpeedContent >= 1024) {
            mSpeedContent = (float) ((mSpeedContent) / (1024 + 0.0));
            mSpeedContent = (float) (((int) (mSpeedContent * 10) % 10 + 0.0) / 10 + (int) mSpeedContent);
            ToastUtils.showLong(mSpeedContent + "M/s");
        } else {
            ToastUtils.showLong(mSpeedContent + "kb/s");
        }
    }

    private String getJoinData(){
        StringBuilder sb = new StringBuilder();
        sb.append("区域名称： "+groupName);
        sb.append("\n项目名称： "+childrenName);
        sb.append("\n配置信息： "+configName);
        sb.append("\n小区地址： "+village);
        sb.append("\n详细地址： "+address);
        return sb.toString();
    }
}
