package personal.buildbroad.base;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 *
 */

public class BaseAndroid {
    public static BaseConfig baseConfig;

    public static void init(final BaseConfig config) {
        baseConfig = config;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static BaseConfig getBaseConfig() {
        if (baseConfig == null) {
            throw new IllegalArgumentException("请先调用init方法");
        }
        return baseConfig;
    }

}
