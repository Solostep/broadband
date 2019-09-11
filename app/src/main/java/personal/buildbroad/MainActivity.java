package personal.buildbroad;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.mylhyl.circledialog.CircleDialog;

import personal.buildbroad.base.BaseActivity;
import personal.buildbroad.utils.StringUtils;
import personal.buildbroad.utils.XActivityStack;

/**
 * Created by liyn18 on 18-5-8.
 */

public class MainActivity extends BaseActivity {
    private EditText ap_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("经纬宽带欢迎您");
        hideBack();
        ap_edit = (EditText) findViewById(R.id.ap_edit);
        if (StringUtils.isNotEmpty(String.valueOf(getSp("apAddress","")))){
            ap_edit.setText(String.valueOf(getSp("apAddress","")));
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    public void onClickMain(View view){
        if (StringUtils.isBlank(ap_edit.getText().toString())&&view.getId()!=R.id.update_Order){
            ToastUtils.showShort("请填写AP地址！");
            return;
        }else{
            String apAddress = ap_edit.getText().toString();
            if (!apAddress.contains("http://")){
                apAddress = "http://"+apAddress;
            }
            if (apAddress.lastIndexOf("/")==apAddress.length()-1){
                apAddress = apAddress.substring(0,apAddress.length()-1);
            }
            Log.d("tag",""+apAddress);
            putSp("apAddress",apAddress);
            ap_edit.setText(apAddress);
        }
        switch (view.getId()){
            case R.id.add_config:
                openActivity(ConfigAddActivity.class);
                break;
            case R.id.update_config:
                openActivity(ConfigUpdateActivity.class);
                break;
            case R.id.update_Order:
                openActivity(OrderUpdateActivity.class);
                break;
            case R.id.order_test:
                openActivity(TestActivity.class);
                break;
            case R.id.exit_login_btn:
                new CircleDialog.Builder(MainActivity.this)
                        .setCanceledOnTouchOutside(false)
                        .setCancelable(false)
                        .setText("确定退出登录？")
                        .setNegative("取消", null)
                        .setPositive("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                clearSp();
                                finish();
                                XActivityStack.getInstance().appExit();
                            }
                        })
                        .show();
                break;
        }
    }

    public void test(View view){
        openActivity(NumberTestActivity.class);
    }

    public void exit(View view){
        new CircleDialog.Builder(MainActivity.this)
                .setCanceledOnTouchOutside(false)
                .setCancelable(false)
                .setText("确定退出登录？")
                .setNegative("取消", null)
                .setPositive("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clearSp();
                        finish();
                        XActivityStack.getInstance().appExit();
                    }
                })
                .show();
    }
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                XActivityStack.getInstance().appExit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
