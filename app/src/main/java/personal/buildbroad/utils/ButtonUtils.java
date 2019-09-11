package personal.buildbroad.utils;


/**
 * 为了防止用户或者测试连续点击按钮
 */
public class ButtonUtils {
	private static long lastClickTime;
	
	/**
	 * 是否快速点击
	 */
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();   
        if ( time - lastClickTime < 2000) {
            return true;   
        }   
        lastClickTime = time;   
        return false;   
    }
    
}
