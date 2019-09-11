package personal.buildbroad.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import personal.buildbroad.utils.SpUtils;
import personal.buildbroad.widget.LoadingDialog;


public abstract class BaseFragment extends Fragment {

    private View mContentView;
    private Context mContext;
    private Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(setLayoutResourceID(), container, false);
        unbinder = ButterKnife.bind(this, mContentView);
        mContext = getContext();
        init();
        return mContentView;
    }

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    protected abstract int setLayoutResourceID();

    //    @Override
    //    public void onViewCreated(View view, Bundle savedInstanceState) {
    //        super.onViewCreated(view, savedInstanceState);
    //        if (!injected) {
    //            x.view().inject(this, this.getView());
    //        }
    //    }

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 开启浮动加载进度条
     */
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    /**
     * 开启浮动加载进度条Gif
     */
    public void startGifProgressDialog() {
        LoadingDialog.showDialogForLoadingGif(getActivity());
    }

    /**
     * 开启浮动加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(getActivity(), msg, true);
    }

    /**
     * 停止浮动加载进度条
     */
    public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    /**
     * 弹出Toast
     */
    public void showToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取EditView的文字
     */
    public String getStr(EditText editText) {
        return editText.getText().toString().trim();
    }

    /**
     * 获取TextView的文字
     */
    public String getStr(TextView textView) {
        return textView.getText().toString();
    }

    /**
     * 获取string的文字
     */
    public String getStr(int id) {
        return getResources().getString(id);
    }

    /**
     * 检查字符串是否是空对象或空字符串
     */
    public boolean isNull(String str) {
        if (null == str || "".equals(str) || "null".equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检查EditView是否是空对象或空字符串
     */
    public boolean isNull(EditText str) {
        if (null == str.getText().toString() || "".equals(str.getText().toString())
                || "null".equalsIgnoreCase(str.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检查TextView是否是空对象或空字符串
     */
    public boolean isNull(TextView str) {
        if (null == str.getText().toString() || "".equals(str.getText().toString())
                || "null".equalsIgnoreCase(str.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 启动Activity
     */
    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    /**
     * 保存sp数据
     *
     * @param key
     * @param object
     */
    public void putSp(String key, Object object) {
        SpUtils.put(getActivity(), key, object);
    }

    /**
     * 清除Sp数据
     */
    public void clearSp() {
        SpUtils.clear(getActivity());
    }

    /**
     * 获取sp数据
     *
     * @param key
     * @param object
     * @return
     */
    public Object getSp(String key, Object object) {
        return SpUtils.get(getActivity(), key, object);
    }

}
