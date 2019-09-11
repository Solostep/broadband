package personal.buildbroad.utils;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ParamUtils {

	private String method;

	private Map<String, Object> param = new HashMap<String, Object>();

	public static ParamUtils init(String method) {
		ParamUtils p = new ParamUtils();
		p.method = method;
		return p;
	}

	public static ParamUtils init(String method, Map<String, Object> map) {
		ParamUtils p = new ParamUtils();
		p.method = method;
		p.param = map;
		return p;
	}

	public ParamUtils addParam(String key, String value) {
		param.put(key, value);
		return this;
	}

	public ParamUtils addParams(Map<String, Object> map) {
		param.putAll(map);
		return this;
	}

	public ParamUtils addParams(Object object) {
		param.putAll(toMap(object));
		return this;
	}

	public ParamUtils addParams(Object object, String[] unConvert) {
		param.putAll(toMap(object, unConvert));
		return this;
	}

	public String getJSONStr() {
		if (method == null) {
			try {
				throw new Exception("没有设置请求方法,请求参数不正确!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}

		}
		Map<String, Map<String, Object>> params = new HashMap<String, Map<String, Object>>();
		params.put("body", param);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("method", method);
		params.put("head", head);
		return GsonUtil.GsonString(params);
	}

	private static Map<String, String> toMap(Object obj) {
		return toMap(obj, new String[0]);
	}

	private static Map<String, String> toMap(Object obj, String[] unConvert) {
		if (obj == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (Field f : obj.getClass().getDeclaredFields()) {
			if (contains(unConvert, f.getName())) {
				continue;
			}
			map.put(f.getName(), getFieldValue(obj, f).toString());
		}
		return map;
	}

	private static Object getFieldValue(Object target, Field f) {
		if (target == null || f == null)
			return null;
		return getFieldValue(target, f.getName());
	}

	/**
	 * 判断是否数组中包含目标字符串
	 * 
	 * 如果目标字符串为null，判断数组中是否有null，如果有，返回true
	 * 
	 * @param src
	 * @param str
	 * @return
	 */
	private static boolean contains(String[] src, String str) {
		if (src == null || src.length <= 0)
			return false;

		boolean result = false;

		if (str == null) {
			for (String tmp : src) {
				if (tmp == null) {
					result = true;
					break;
				}
			}
		} else {
			for (String tmp : src) {
				if (str.equals(tmp)) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	private static Object getFieldValue(Object o, String fieldName) {
		if (o == null || fieldName == null)
			return null;

		Method getMethod = getGetter(o.getClass(), fieldName);
		if (getMethod != null) {
			try {
				return getMethod.invoke(o, new Object[0]);
			} catch (IllegalArgumentException e) {
				Log.d(ParamUtils.class.getName(), "通过getter方法获取成员变量[" + fieldName + "]值错误");
			} catch (IllegalAccessException e) {
				Log.d(ParamUtils.class.getName(), "通过getter方法获取成员变量[" + fieldName + "]值错误", e);
			} catch (InvocationTargetException e) {
				Log.d(ParamUtils.class.getName(), "通过getter方法获取成员变量[" + fieldName + "]值错误", e);
			}
		}

		Field f = null;
		try {
			f = o.getClass().getDeclaredField(fieldName);
		} catch (SecurityException e) {
			Log.d(ParamUtils.class.getName(), "获取成员变量[" + fieldName + "]错误", e);
		} catch (NoSuchFieldException e) {
			Log.d(ParamUtils.class.getName(), "获取成员变量[" + fieldName + "]错误", e);
		}
		if (f == null)
			return null;

		if (f.isAccessible()) {
			try {
				return f.get(o);
			} catch (IllegalArgumentException e) {
				Log.d(ParamUtils.class.getName(), "获取成员变量[" + fieldName + "]值错误", e);
			} catch (IllegalAccessException e) {
				Log.d(ParamUtils.class.getName(), "获取成员变量[" + fieldName + "]值错误", e);
			}
		}
		return null;
	}

	private static Method getGetter(Class<?> clazz, String fieldName) {
		String name = "";
		if (fieldName != null) {
			name = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
		}
		String getMethodName = "get" + name;
		try {
			return clazz.getDeclaredMethod(getMethodName);
		} catch (SecurityException e) {
			Log.d(ParamUtils.class.getName(), "获取获取成员变量[" + fieldName + "]getter方法错误", e);
		} catch (NoSuchMethodException e) {
			Log.d(ParamUtils.class.getName(), "获取获取成员变量[" + fieldName + "]getter方法错误", e);
		}
		return null;
	}
}
