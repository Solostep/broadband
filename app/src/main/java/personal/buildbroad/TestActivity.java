package personal.buildbroad;

/**
 * Created by root on 19-9-11.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.blankj.utilcode.util.ToastUtils;

import personal.buildbroad.adapter.ContentAdapter;
import personal.buildbroad.adapter.ContentAdapter.MyClickListener;
import personal.buildbroad.http.ConfigService;
import personal.buildbroad.http.ServiceCallBack;
import personal.buildbroad.utils.StringUtils;

public class TestActivity extends Activity implements OnItemClickListener {

        // 模拟listview中加载的数据
        //private static final String[] CONTENTS = { "北京", "上海", "广州", "深圳", "苏州",
        //        "南京", "武汉", "长沙", "杭州" };
        //private List<String> contentList;
        private List<Map<String, Object>> list = new ArrayList<>();
        private ListView mListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            init();
        }

        private void init() {
            mListView = (ListView) findViewById(R.id.listview);
            /*contentList = new ArrayList<String>();
            for (int i = 0; i < CONTENTS.length; i++) {
                contentList.add(CONTENTS[i]);
            }*/
            //实例化ContentAdapter类，并传入实现类
            initData();
            //getOrderList();
            mListView.setAdapter(new ContentAdapter(this, list, mListener));

            mListView.setOnItemClickListener(this);
        }
    private void initData() {

        list.clear();

        for (int i = 0; i < 10; i++) {

            Map<String,Object> map = new HashMap<String, Object>();

            map.put("name", "name" + (i + 1));

            list.add(map);

        }

    }
    private void getOrderList() {

        ConfigService.getOrderList(new ServiceCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);

                Log.d("tag","re:"+result);

                if (StringUtils.isNotBlank(result)){
                    JSONArray array = JSONArray.parseArray(result);
                    Log.d("tag","array:"+array.toString());
                    List<Object> olist = JSON.parseArray(result, Object.class);
                    for (int i=0;i<olist.size();i++){
                        Map<String,Object> map = (Map<String, Object>) olist.get(i);//取出list里面的值转为map
                        list.add(map);

                    }
                    Log.d("tag","list:"+list.size());
                }

                //getOrderList.setText(result);
                //addListView(result);
            }

            @Override
            public void onError() {
                super.onError();
                ToastUtils.showShort("网络错误，请稍后重试");

            }
        });
    }


        //响应item点击事件
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
            Toast.makeText(this, "listview的item被点击了！，点击的位置是-->" + position,
                    Toast.LENGTH_SHORT).show();
        }

        /**
         * 实现类，响应按钮点击事件
         */
        private MyClickListener mListener = new MyClickListener() {
            @Override
            public void myOnClick(int position, View v) {
                Toast.makeText(
                        TestActivity.this,
                        "listview的内部的按钮被点击了！，位置是-->" + position + ",内容是-->"
                                + list.get(position).get("name"), Toast.LENGTH_SHORT)
                        .show();
            }
        };
    }
