package personal.buildbroad;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import personal.buildbroad.base.BaseActivity;

import static com.blankj.utilcode.util.PhoneUtils.call;

/**
 * Created by root on 18-8-13.
 */

public class NumberTestActivity extends BaseActivity {

    private TextView one, info;
    private String number;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_number_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        one = (TextView) findViewById(R.id.number_one);
        info = (TextView) findViewById(R.id.number_info);
        one.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        number = info.getText().toString().trim();
    }

    public void testNumber(View view) {
        switch (view.getId()) {
            case R.id.number_two:
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+number));

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                break;
            case R.id.number_three:
                AlertDialog alertDialog2 = new AlertDialog.Builder(this)
                        .setTitle("是否拨打")
                        .setMessage(number)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(NumberTestActivity.this, "这是确定按钮", Toast.LENGTH_SHORT).show();
                                /*Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                                startActivity(intentPhone);*/
                                if(ContextCompat.checkSelfPermission(NumberTestActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                                    ActivityCompat.requestPermissions(NumberTestActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                                }else {
                                    Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                                    startActivity(intentPhone);

                                }
                            }
                        })

                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(NumberTestActivity.this, "这是取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog2.show();
                break;
        }
    }
}
