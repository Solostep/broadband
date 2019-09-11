package personal.buildbroad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import personal.buildbroad.base.BaseActivity;

/**
 * Created by root on 18-8-6.
 */

public class SplashActivity extends BaseActivity {
    private Button jump;

    private ViewPager viewPage;

    //滑动页面的数量
    private List<View> tabViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tabViews = new ArrayList<>();
        //初始化数据
        initData();
        viewPage = (ViewPager) findViewById(R.id.splash_view);

        jump  = (Button) findViewById(R.id.splash_jump);
        //设置适配器
        viewPage.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //ToastUtils.showShort("size: "+tabViews.size());
                return tabViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ToastUtils.showShort("position: "+position);
                container.addView(tabViews.get(position));
                if(position == tabViews.size()) {

                    openActivity(MainActivity.class);
                }
                return tabViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tabViews.get(position));
            }
        });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_splash;
    }

    public void onClickJump(View view){
        openActivity(MainActivity.class);
    }
    private void initData() {
        //引入一个布局，三个共用，设置不同的背景图片
        LayoutInflater tabs = getLayoutInflater().from(SplashActivity.this);
        View tab1 = tabs.inflate(R.layout.activity_splash_table, null);
        tab1.setBackgroundResource(R.mipmap.guide_image1);

        View tab2 = tabs.inflate(R.layout.activity_splash_table, null);
        tab2.setBackgroundResource(R.mipmap.guide_image2);

        View tab3 = tabs.inflate(R.layout.activity_splash_table, null);
        tab3.setBackgroundResource(R.mipmap.guide_image3);

        //添加到列表里
        tabViews.add(tab1);
        tabViews.add(tab2);
        tabViews.add(tab3);
    }

}
