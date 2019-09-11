package personal.buildbroad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.mylhyl.circledialog.CircleDialog;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.vector.update_app.utils.AppUpdateUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import personal.buildbroad.base.BaseActivity;
import personal.buildbroad.common.AppConstant;
import personal.buildbroad.http.ConfigService;
import personal.buildbroad.http.OkGoUpdateHttpUtil;
import personal.buildbroad.http.ServiceCallBack;
import personal.buildbroad.utils.ApConfigUtil;
import personal.buildbroad.utils.CProgressDialogUtils;
import personal.buildbroad.utils.CheckDataUtil;
import personal.buildbroad.utils.NetWorkSpeedUtil;
import personal.buildbroad.utils.StringUtils;

/**
 * Created by liyn18 on 18-4-13.
 */

public class ConfigAddActivity extends BaseActivity {

    private String apid,apmac;

    private Spinner areas,items,configs,apGroup;

    private EditText name,phone,village,address;

    private TextView apmacText,nameText,phoneText,villageText;

    private RadioButton nowEffect;

    private String areaId,itemId,configId,apGroupId;//选定数据的id

    private String areaName,itemName;//选定数据的名称

    private ArrayAdapter<String> adapter_area,adapter_item,adapter_config,adapter_apGaoup;//适配器

    private JSONArray areaArray,itemArray,configArray,apGroupArray;//原始数据：areaArray 组信息一级 ，itemArray  组信息二级 ， configArray  配置信息

    private List<String> alist,clist,apGroupList;

    private List<String> aIdList,cIdList,apGroupIdList;

    private Map<String,List<String>> map;
    private ObjectAnimator mCircleAnimator;
    private ImageView speedImg;

    private final static String UPDATE_APP_KEY = "UPDATE_APP_KEY";

    private static final int STOP = 0x112;
    private float mSpeedContent;
    private Button testSpeedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("新增用户配置信息");
        getP();
        //updateApp();
    }

    public void getP(){

        areas = (Spinner) findViewById(R.id.areas);
        items = (Spinner) findViewById(R.id.items);
        configs = (Spinner) findViewById(R.id.configs);
        apGroup = (Spinner) findViewById(R.id.apgroup);

        name = (EditText) findViewById(R.id.h_name);
        phone = (EditText) findViewById(R.id.h_phone);
        address = (EditText) findViewById(R.id.h_address);
        village = (EditText) findViewById(R.id.h_village);
        apmacText = (TextView) findViewById(R.id.apmac_text);
        nameText = (TextView) findViewById(R.id.name_text);
        phoneText = (TextView) findViewById(R.id.phone_text);
        villageText = (TextView) findViewById(R.id.village_text);

        testSpeedBtn = (Button) findViewById(R.id.test_speed_btn);
        speedImg = (ImageView) findViewById(R.id.speed_img);
        mCircleAnimator = ObjectAnimator.ofFloat(speedImg, "rotation", 0.0f, 360.0f);
        mCircleAnimator.setDuration(800);
        mCircleAnimator.setInterpolator(new LinearInterpolator());
        mCircleAnimator.setRepeatCount(-1);
        mCircleAnimator.setRepeatMode(ObjectAnimator.RESTART);

        apmac = ApConfigUtil.getWifiRouteMACAddress(this);
        //apmac="00:01:7A:35:0A:E7";
        apmac="44:D1:FA:59:BD:1D";
        apmac=(apmac).replaceAll("-",":");
        if (StringUtils.isNotEmpty(apmac)){
            Log.d("tag","apmac:"+apmac);
            //ToastUtils.showShort("apmac："+apmac);
            apmacText.setText(apmac);
            //final Date starttime = new Date();
            //ToastUtils.showShort("req start："+new Date());
            ConfigService.getApConfData(String.valueOf(getSp("apAddress","")),apmac , new ServiceCallBack<Map<String, Object>>(){
                @Override
                public void onSuccess(String code, Map<String, Object> result) {
                    super.onSuccess(code, result);

                    Log.d("tag","re:"+result);
                    if (AppConstant.SUCCESS_STATUS_CODE.equals(code)) {
                        if (result != null) {
                            Date end = new Date();
                            //ToastUtils.showShort("req end："+new Date());
                           // ToastUtils.showShort("time："+String.valueOf(end.getTime()-starttime.getTime()));
                            if (result.containsKey("group")) {
                                areaArray = (JSONArray) result.get("group");
                            }
                            if (result.containsKey("children")) {
                                itemArray = (JSONArray) result.get("children");
                            }
                            if (result.containsKey("configs")){
                                configArray = (JSONArray) result.get("configs");
                            }
                            if (result.containsKey("apgroup")){
                                apGroupArray = (JSONArray) result.get("apgroup");
                            }
                            if (result.containsKey("apid")){
                                apid = (String) result.get("apid");
                            }
                        }
                        Log.d("tag","area: "+areaArray.toString()+"  item: "+itemArray.toString()+"  config: "+configArray+"    apGroupArray: "+apGroupArray+" apid"+apid);
                        initView();
                    } else {
                        Log.d("tag","re:"+result.toString());
                        ToastUtils.showShort((String)result.get("message"));
                    }
                }

                @Override
                public void onError() {
                    super.onError();
                    ToastUtils.showShort("网络错误，请稍后重试");
                }
            });
        }else{
            ToastUtils.showShort("网络错误,请连接wifi网络");
        }
    }

    private void initView() {
        //Date initstart = new Date();

        apmacText.setText(apmac);

        String saveName = String.valueOf(getSp("name",""));
        if (StringUtils.isNotBlank(saveName)) {
            name.setText(saveName);
            nameText.setText(saveName);
            nameText.setVisibility(View.VISIBLE);
        }else{
            name.setVisibility(View.VISIBLE);
        }
        String savePhone = String.valueOf(getSp("phone",""));
        if (StringUtils.isNotBlank(savePhone)) {
            phone.setText(savePhone);
            phoneText.setText(savePhone);
            phoneText.setVisibility(View.VISIBLE);
        }else{
            phone.setVisibility(View.VISIBLE);
        }
        String saveVillage = String.valueOf(getSp("village",""));
        if (StringUtils.isNotBlank(saveVillage)) {
            village.setText(saveVillage);
            villageText.setText(saveVillage);
            villageText.setVisibility(View.VISIBLE);
        }else{
            village.setVisibility(View.VISIBLE);//不显示,且不保留所占的空间
        }

        nowEffect = (RadioButton) findViewById(R.id.now_effect);

        if (areaArray!=null&&0!=areaArray.size()&&itemArray!=null&&0!=itemArray.size()&&configArray!=null&&0!=configArray.size()){

            parseArea();

            adapter_area = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alist);
            adapter_item = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, map.get(alist.get(0)));

            areas.setAdapter(adapter_area);
            items.setAdapter(adapter_item);

            areas.setSelection(0);
            items.setSelection(0);

            areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    areaName= alist.get(i);
                    areaId = aIdList.get(i);
                    adapter_item = new ArrayAdapter<String>(ConfigAddActivity.this, android.R.layout.simple_spinner_dropdown_item, map.get(areaName));
                    items.setAdapter(adapter_item);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    itemName = map.get(areaName).get(i);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        if (configArray!=null&&0!=configArray.size()) {
            parseConfig();
            adapter_config = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clist);
            configs.setAdapter(adapter_config);
            configs.setSelection(0);
            configs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    configId = cIdList.get(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        if (apGroupArray!=null&&0!=apGroupArray.size()) {
            parseApGroup();
            adapter_apGaoup = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,apGroupList);
            apGroup.setAdapter(adapter_apGaoup);
            apGroup.setSelection(0);
            apGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    apGroupId = apGroupIdList.get(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
            //Date initend = new Date();
        //ToastUtils.showShort("init:"+String.valueOf(initend.getTime()-initstart.getTime()));
    }

/*    private void parseData() {
        aIdList  = new ArrayList<>();
        alist = new ArrayList<>();
        cIdList = new ArrayList<>();
        clist = new ArrayList<>();

        map = new HashMap<>();
        for (int i=0;i<areaArray.size();i++){
            com.alibaba.fastjson.JSONObject json = areaArray.getJSONObject(i);
            String id = json.getString("id");
            String name = json.getString("name");
            aIdList.add(id);
            alist.add(name);
            List<String> list = new ArrayList<>();
            for (int k=0;k<itemArray.size();k++){
                com.alibaba.fastjson.JSONObject item = itemArray.getJSONObject(k);
                if (id.equals(item.getString("pid"))){
                    list.add(item.getString("name"));
                }
            }
            map.put(name,list);
            Log.d("tag","map: "+map.toString());
        }
        for (int i=0;i<configArray.size();i++){
            com.alibaba.fastjson.JSONObject json = configArray.getJSONObject(i);
            cIdList.add(json.getString("ID"));
            clist.add(json.getString("name"));
        }
        for (int i=0;i<apGroupArray.size();i++){
            com.alibaba.fastjson.JSONObject json = apGroupArray.getJSONObject(i);
            apGroupIdList.add(json.getString("id"));
            apGroupList.add(json.getString("name"));
        }
    }*/
    private void parseArea(){
        aIdList  = new ArrayList<>();
        alist = new ArrayList<>();
        map = new HashMap<>();
        for (int i=0;i<areaArray.size();i++){
            com.alibaba.fastjson.JSONObject json = areaArray.getJSONObject(i);
            String id = json.getString("id");
            String name = json.getString("name");
            aIdList.add(id);
            alist.add(name);
            List<String> list = new ArrayList<>();
            for (int k=0;k<itemArray.size();k++){
                com.alibaba.fastjson.JSONObject item = itemArray.getJSONObject(k);
                if (id.equals(item.getString("pid"))){
                    list.add(item.getString("name"));
                }
            }
            map.put(name,list);
            Log.d("tag","map: "+map.toString());
        }
    }

    private void parseConfig(){
        cIdList = new ArrayList<>();
        clist = new ArrayList<>();
        for (int i=0;i<configArray.size();i++){
            com.alibaba.fastjson.JSONObject json = configArray.getJSONObject(i);
            cIdList.add(json.getString("ID"));
            clist.add(json.getString("name"));
        }
    }

    private void parseApGroup(){
        apGroupIdList = new ArrayList<>();
        apGroupList = new ArrayList<>();
        for (int i=0;i<apGroupArray.size();i++){
            com.alibaba.fastjson.JSONObject json = apGroupArray.getJSONObject(i);
            apGroupIdList.add(json.getString("id"));
            apGroupList.add(json.getString("name"));
        }
    }

    private void updateApp() {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();

        Map<String, String> params = new HashMap<String, String>();
        params.put("appKey", AppUpdateUtils.getManifestString(this, UPDATE_APP_KEY));
        params.put("version", AppUpdateUtils.getVersionName(this));
        new UpdateAppManager
                .Builder()
                //必须设置，当前Activity
                .setActivity(this)
                //必须设置，实现httpManager接口的对象
                .setHttpManager(new OkGoUpdateHttpUtil())
                //必须设置，更新地址
                .setUpdateUrl(AppConstant.REMOTE_URL + "/api/updateVersion")
                //添加自定义参数，默认version=1.0.0（app的versionName）；apkKey=唯一表示（在AndroidManifest.xml配置）
                .setParams(params)
                //设置点击升级后，消失对话框，默认点击升级后，对话框显示下载进度
                .hideDialogOnDownloading(false)
                //设置头部，不设置显示默认的图片，设置图片后自动识别主色调，然后为按钮，进度条设置颜色
                .setTopPic(R.mipmap.top_5)
                //为按钮，进度条设置颜色，默认从顶部图片自动识别。
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                //设置apk下砸路径，默认是在下载到sd卡下/Download/1.0.0/test.apk
                .setTargetPath(path)
                .dismissNotificationProgress()
                //是否忽略版本
                //.showIgnoreVersion()
                .build()
                //检测是否有新版本
                .checkNewApp(new UpdateCallback() {
                    /**172.16.23.162:6070
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            updateAppBean
                                    //（必须）是否更新Yes,No
                                    .setUpdate(jsonObject.optString("update"))
                                    //（必须）新版本号，
                                    .setNewVersion(jsonObject.optString("new_version"))
                                    //（必须）下载地址
                                    .setApkFileUrl(jsonObject.optString("apk_file_url"))
                                    //（必须）更新内容
                                    .setUpdateLog(jsonObject.optString("update_log"))
                                    //大小，不设置不显示大小，可以不设置
                                    .setTargetSize(jsonObject.optString("target_size"))
                                    //是否强制更新，可以不设置
                                    .setConstraint(jsonObject.optBoolean("constraint"));
                            //设置md5，可以不设置
                            //.setNewMd5(jsonObject.optString("new_md51"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return updateAppBean;
                    }

                    /**
                     * 网络请求之前
                     */
                    @Override
                    public void onBefore() {
                        CProgressDialogUtils.showProgressDialog(ConfigAddActivity.this);
                    }

                    /**
                     * 网路请求之后
                     */
                    @Override
                    public void onAfter() {
                        CProgressDialogUtils.cancelProgressDialog(ConfigAddActivity.this);
                    }

                    /**
                     * 没有新版本
                     */
                    @Override
                    public void noNewApp() {
                        // Toast.makeText(ConfigAddActivity.this, "没有新版本", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_config_add;
    }

    public void onLinearClick(final View view) {
        switch (view.getId()) {
            case R.id.commit_btn:
                if (StringUtils.isBlank(areaId)) {
                    ToastUtils.showShort("请选择域名称");
                    return;
                }
                if (StringUtils.isBlank(itemName)) {
                    ToastUtils.showShort("请选择项目名称");
                    return;
                }else{
                    getItemIdByName();
                }
                if (StringUtils.isBlank(configId)) {
                    ToastUtils.showShort("请选择配置信息");
                    return;
                }
                if (StringUtils.isBlank(name.getText().toString())) {
                    ToastUtils.showShort("请输入姓名");
                    return;
                }else{
                    putSp("name", name.getText().toString() + "");
                }
                if (!CheckDataUtil.checkPhone(phone.getText().toString())) {
                    return;
                }
                putSp("phone", phone.getText().toString() + "");

                if (StringUtils.isBlank(village.getText().toString())) {
                    ToastUtils.showShort("请输入小区地址");
                    return;
                }else{
                    putSp("village", village.getText().toString() + "");
                }
                if (StringUtils.isBlank(address.getText().toString())) {
                    ToastUtils.showShort("请输入详细地址");
                    return;
                }
                String updateway = "1";
                if (!nowEffect.isChecked()) {
                    updateway = "2";
                }
                ConfigService.saveConfigureData(String.valueOf(getSp("apAddress","")),apid,apmac,configId,updateway,name.getText().toString(),phone.getText().toString(),areaId,itemId,apGroupId,village.getText().toString(),address.getText().toString(),"1","", new ServiceCallBack<String>() {
                    @Override
                    public void onSuccess(String code, String result) {
                        super.onSuccess(code, result);
                        if (AppConstant.SUCCESS_STATUS_CODE.equals(code)) {
                            ToastUtils.showShort(result);
                            nameText.setText(name.getText().toString());
                            name.setVisibility(View.GONE);
                            nameText.setVisibility(View.VISIBLE);
                            phoneText.setText(phone.getText().toString());
                            phone.setVisibility(View.GONE);
                            phoneText.setVisibility(View.VISIBLE);
                            villageText.setText(village.getText().toString());
                            village.setVisibility(View.GONE);
                            villageText.setVisibility(View.VISIBLE);
                            address.setText("");
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
                break;

            //case R.id.socket_btn:
            //    openActivity(SocketActivity.class);
            //    break;
            case R.id.refresh_apmac_btn:
                getP();
                //openActivity(SpeedActivity.class);
                break;
            case R.id.test_speed_btn:
                if (!isConnect(this)) {
                    ToastUtils.showShort("网络没有连接");
                }else{
                    speedImg.setVisibility(View.VISIBLE);
                    testSpeedBtn.setEnabled(false);
                    mCircleAnimator.start();
                    new NetWorkSpeedUtil(this,mProgressHandler).startShowNetSpeed();
                }
                break;
        }
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
    public static boolean isConnect(Context context) {
        boolean _isConnect = false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            _isConnect = conManager.getActiveNetworkInfo().isAvailable();
        }
        return _isConnect;
    }

    private void getItemIdByName() {
        for(int i=0;i<itemArray.size();i++){
            com.alibaba.fastjson.JSONObject json = itemArray.getJSONObject(i);
            if(json.getString("name").equals(itemName)&&json.getString("pid").equals(areaId)){
                itemId = json.getString("id");
                break;
            }
        }
    }

    private boolean checkPhone() {
        if (StringUtils.isBlank(phone.getText().toString())) {
            ToastUtils.showShort("请输入手机号");
            return false;
        } else if (!RegexUtils.isMobileExact(phone.getText().toString())) {
            ToastUtils.showShort("请输入正确格式的手机号");
            return false;
        }
        return true;
    }



}
