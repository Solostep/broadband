package personal.buildbroad.utils;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * Created by liyn18 on 18-5-9.  数据检测
 */

public class CheckDataUtil {

    /**
     * 检测手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            ToastUtils.showShort("请输入手机号");
            return false;
        } else if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort("请输入正确格式的手机号");
            return false;
        }
        return true;
    }

    /**
     * 检测mac地址
     * @param mac
     * @return
     */
    public static boolean checkMac(String mac) {
        if (StringUtils.isBlank(mac)) {
            ToastUtils.showShort("请输入旧设备mac地址！");
            return false;
        } else if (!RegexUtil.isMac(mac)) {
            ToastUtils.showShort("请输入正确格式的旧设备mac地址!");
            return false;
        }
        return true;
    }
}
