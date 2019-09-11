package personal.buildbroad;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ToastUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import personal.buildbroad.base.BaseActivity;
import personal.buildbroad.http.ConfigService;
import personal.buildbroad.http.ServiceCallBack;
import personal.buildbroad.utils.StringUtils;

/**
 * Created by root on 19-9-10.
 */

public class OrderUpdateActivity extends BaseActivity {
    private TextView getOrderList;

    private List<Map<String, Object>> list = new ArrayList<>();

    private  MyAdapter adapter = null;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_order_update;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("更新订单状态信息");

        getReload();
        //getOrderList();
        initDate();
        Log.d("tag","list on create:"+list.size());
        ListView listView = (ListView)findViewById(R.id.lv_order_list);
        adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        //updateApp();
    }
    private void initDate() {

        list.clear();

        for (int i = 0; i < 10; i++) {

            Map<String,Object> map = new HashMap<String, Object>();

            map.put("orderId", "" + (i + 1));

            map.put("name", "000");

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
                        Map <String,Object> map = (Map<String, Object>) olist.get(i);//取出list里面的值转为map
                        list.add(map);

                    }
                    Log.d("tag","list:"+list.size());
                    ListView listView = (ListView)findViewById(R.id.lv_order_list);
                    listView.setAdapter(adapter);
                }

                getOrderList.setText(result);
                //addListView(result);
            }

            @Override
            public void onError() {
                super.onError();
                ToastUtils.showShort("网络错误，请稍后重试");

            }
        });
    }
/*    private void addListView(String result) {

        //创建适配器
        // 第一个参数是上下文对象
        // 第二个是listitem
        // 第三个是指定每个列表项的布局文件
        // 第四个是指定Map对象中定义的两个键（这里通过字符串数组来指定）
        *//*username 用户名
        orderId 订单号
        type 产品类型
        name 产品名称
        totalnub 费用
        order_create_time 创建时间
        status 状态*//*
        // 第五个是用于指定在布局文件中定义的id（也是用数组来指定）
        SimpleAdapter adapter = new SimpleAdapter(this
                , list
                , R.layout.order_one_item
                , new String[]{"name", "status", "lineNumber", "building", "create_time", "config"}
                , new int[]{R.id.order_name, R.id.order_status, R.id.order_lineNumber, R.id.order_building, R.id.order_create,R.id.order_config});

        ListView listView = (ListView)findViewById(R.id.lv_order_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Map <String,Object> map = list.get(i);
            }
        });

    }*/

    public void getReload() {

        getOrderList = (TextView) findViewById(R.id.get_order_list);

    }

    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            Log.d("tag","list:"+list);
            if(null==list){
                return 0;
            }else{
                return list.size();
            }
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
        //****************************************final方法
        //注意原本getView方法中的int position变量是非final的，现在改为final
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
/*
            OrderUpdateActivity.ViewHolder holder = null;
            if (convertView == null) {

                holder=new OrderUpdateActivity.ViewHolder();
                //可以理解为从vlist获取view 之后把view返回给ListView

                convertView = mInflater.inflate(R.layout.activity_order_update, null);
                holder.orderId = (TextView)convertView.findViewById(R.id.order_id);
                holder.name = (TextView)convertView.findViewById(R.id.order_name);
                holder.orderBtn = (Button)convertView.findViewById(R.id.order_btn);
                convertView.setTag(holder);
            }else {
                holder = (OrderUpdateActivity.ViewHolder)convertView.getTag();
            }

            holder.orderId.setText((String)list.get(position).get("orderId"));
            holder.name.setText((String)list.get(position).get("name"));
            holder.orderBtn.setTag(position);
            //给Button添加单击事件 添加Button之后ListView将失去焦点 需要的直接把Button的焦点去掉
            holder.orderBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //showInfo(position);
                }
            });
*/
            Log.d("tag","i:"+position);
            Log.d("tag","getposition:"+list.get(position));
            View myView = mInflater.inflate(R.layout.activity_order_update, null);
            TextView name = (TextView) myView.findViewById(R.id.order_name);
            TextView orderId = (TextView) myView.findViewById(R.id.order_id);
            Log.d("tag","name:"+name);
            //Button orderbtn = (Button) myView.findViewById(R.id.order_btn);
            name.setText((String) list.get(position).get("name"));
            orderId.setText((String) list.get(position).get("orderId"));
            return myView;
        }
    }

//new String[]{"name", "status", "lineNumber", "building", "create_time", "config"}
    public static final class ViewHolder {
        public TextView name;
        public TextView status;
        public TextView lineNumber;
        public TextView building;
        public TextView createTime;
        public TextView config;
        public TextView orderId;
        public TextView username;
        public Button orderBtn;
    }
}
