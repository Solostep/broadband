package personal.buildbroad.base;


import personal.buildbroad.R;

/**
 * 信息配置
 */

public class BaseConfig {
    /**
     * app主颜色
     */
    private int appColor = R.color.base;
    /**
     * 加载框的gif图
     */
    private int loadingView = 0;
    /**
     * 图片加载中和加载失败显示的图
     */
    private int failPicture = R.drawable.ic_empty;

    public int getLoadingView() {
        return loadingView;
    }

    public BaseConfig setLoadingView(int loadingView) {
        this.loadingView = loadingView;
        return this;
    }

    public int getAppColor() {
        return appColor;
    }

    public BaseConfig setAppColor(int appColor) {
        this.appColor = appColor;
        return this;
    }

    public int getFailPicture() {
        return failPicture;
    }

    public BaseConfig setFailPicture(int failPicture) {
        this.failPicture = failPicture;
        return this;
    }

}
