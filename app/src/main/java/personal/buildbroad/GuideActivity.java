package personal.buildbroad;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import personal.buildbroad.adapter.GuidePageAdapter;
import personal.buildbroad.base.BaseActivity;

/**
 * Created by root on 18-8-6.
 */

public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_guide;
    }

    private ViewPager vp;
    private int []imageIdArray;//图片资源的数组
    private List<View> viewList;//图片资源的集合
    private ViewGroup vg;//放置圆点

    //实例化原点View
    private ImageView iv_point;
    private ImageView []ivPointArray;

    //最后一页的按钮
    private Button ib_start;
    private Button jump;
    private LinearLayout.LayoutParams layoutParams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ib_start = (Button) findViewById(R.id.guide_ib_start);
        jump = (Button) findViewById(R.id.guide_ib_jump);
        jump.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //加载ViewPager
        initViewPager();

        //加载底部圆点
        initPoint();
    }

    public void onClickJump(View view){
        switch (view.getId()){
            case R.id.guide_ib_jump:
                openActivity(MainActivity.class);
                break;
            case R.id.guide_ib_start:
                openActivity(MainActivity.class);
                break;
        }

    }
    /**
     * 加载底部圆点
     */
    private void initPoint() {
        //这里实例化LinearLayout
        vg = (ViewGroup) findViewById(R.id.guide_ll_point);
        //根据ViewPager的item数量实例化数组
        ivPointArray = new ImageView[viewList.size()];
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        int size = viewList.size();
        for (int i = 0;i<size;i++){
            iv_point = new ImageView(this);
            layoutParams = new LinearLayout.LayoutParams(15,15);

            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0){
                iv_point.setBackgroundResource(R.drawable.shape_bg_point_enable);
            }else{
                layoutParams.leftMargin=20;
                iv_point.setBackgroundResource(R.drawable.shape_bg_point_disable);
            }
            iv_point.setLayoutParams(layoutParams);
            iv_point.setPadding(30,0,30,0);//left,top,right,bottom
            ivPointArray[i] = iv_point;

            //将数组中的ImageView加入到ViewGroup
            vg.addView(ivPointArray[i]);
        }
    }

    /**
     * 加载图片ViewPager
     */
    private void initViewPager() {
        vp = (ViewPager) findViewById(R.id.guide_vp);
        //实例化图片资源
        imageIdArray = new int[]{R.mipmap.guide_image1,R.mipmap.guide_image2,R.mipmap.guide_image3};
        viewList = new ArrayList<>();
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建View并加入到集合中
        int len = imageIdArray.length;
        for (int i = 0;i<len;i++){
            //new ImageView并设置全屏和图片资源
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imageIdArray[i]);

            //将ImageView加入到集合中
            viewList.add(imageView);
        }

        //View集合初始化好后，设置Adapter
        vp.setAdapter(new GuidePageAdapter(viewList));
        //设置滑动监听
        vp.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 滑动后的监听
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        //循环设置当前页的标记图
        int length = imageIdArray.length;
        for (int i = 0;i<length;i++){
            ivPointArray[position].setBackgroundResource(R.drawable.shape_bg_point_enable);
            if (position != i){
                ivPointArray[i].setBackgroundResource(R.drawable.shape_bg_point_disable);
            }
        }

        //判断是否是最后一页，若是则显示按钮
        if (position == imageIdArray.length - 1){
            ib_start.setVisibility(View.VISIBLE);
            jump.setVisibility(View.GONE);
            //ToastUtils.showShort("position: "+position);
            //openActivity(MainActivity.class);
        }else {
            jump.setVisibility(View.VISIBLE);
            ib_start.setVisibility(View.GONE);
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
