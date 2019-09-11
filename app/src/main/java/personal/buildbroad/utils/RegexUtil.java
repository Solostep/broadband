package personal.buildbroad.utils;

import java.util.regex.Pattern;

/**
 * Created by liyn18 on 18-5-9.
 */

public class RegexUtil {
    public static final String REGEX_MAC_ONE = "^[A-Fa-f0-9]{2}(:[A-Fa-f0-9]{2}){5}$";
    public static final String REGEX_MAC_TWO = "^[A-Fa-f0-9]{2}(-[A-Fa-f0-9]{2}){5}$";
    public static final String REGEX_MAC_THREE = "^[A-Fa-f0-9]{12}$";

    /**
     * 验证MAC地址
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMac(final CharSequence input) {
        return input != null && input.length() > 0 && (Pattern.matches(REGEX_MAC_ONE, input)||Pattern.matches(REGEX_MAC_TWO, input) ||Pattern.matches(REGEX_MAC_THREE, input));
    }

}
