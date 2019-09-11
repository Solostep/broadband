/**
 *  @Project       : oel_DemonstrationTraining

 *  @Program Name  : cn.com.teacher.cistus.dt.util.JsonUtils.java
 *  @Class Name    : JsonUtils
 *  @Description   : 类描述
 *  @Author        : leonlau
 *  @Creation Date : 2013-6-24 下午1:51:06 
 *  @ModificationHistory  
 */

package personal.buildbroad.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 基于fastjson
 * 
 * @Project : oel_DemonstrationTraining
 * @Program Name : cn.com.teacher.cistus.dt.util.JsonUtils.java
 * @Class Name : JsonUtils
 * @Description : 类描述
 * @Author : leonlau
 * @Creation Date : 2013-6-24 下午2:01:02
 * @ModificationHistory
 */
public class JsonUtils {
	private static final SerializeConfig config;
	static {
		config = new SerializeConfig();
		// config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
		// // 使用和json-lib兼容的日期输出格式
		// config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
		// // 使用和json-lib兼容的日期输出格式

	}
	private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
			SerializerFeature.WriteDateUseDateFormat };

	/**
	 * object 转为json
	 * 
	 * @Description : 方法描述
	 * @Method_Name : toJson
	 * @param obj
	 * @return
	 * @Update Author : leonlau
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, config, features);
	}

	/**
	 * json转对象
	 * 
	 * @Description : 方法描述
	 * @Method_Name : toBean
	 * @param json
	 * @param clazz
	 * @return
	 * @Update Date :
	 * @Update Author : leonlau
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	/**
	 * json转对象list
	 * 
	 * @Description : 方法描述
	 * @Method_Name : toBean
	 * @param json
	 * @param clazz
	 * @return
	 * @Update Date :
	 * @Update Author : leonlau
	 */
	public static <T> List<T> toList(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}

	/**
	 * json转对象map
	 * 
	 * @Description : 方法描述
	 * @Method_Name : toBean
	 * @param json
	 * @param clazz
	 * @return
	 * @Update Date :
	 * @Update Author : leonlau
	 */
	public static <K, V> Map<K, V> toMap(String json) {
		return JSON.parseObject(json, new TypeReference<Map<K, V>>() {
		});
	}

	/**
	 * 将jsonFile 解析出对象
	 * 
	 * @param jsonFile
	 * @param clazz
	 * @return
	 * @throws FileNotFoundException
	 */
	public static <T> T readJson(File jsonFile, Class<T> clazz) throws FileNotFoundException {
		FileReader fileReader = new FileReader(jsonFile);
		JSONReader jsonReader = new JSONReader(fileReader);
		T t = jsonReader.readObject(clazz);
		jsonReader.close();
		return t;
	}

	/**
	 * 将对象转换为json,并持久化
	 * 
	 * @param obj
	 * @param file
	 * @throws IOException
	 */
	public static void writeJson(Object obj, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		JSONWriter jsonWriter = new JSONWriter(fileWriter);
		jsonWriter.writeValue(obj);
		jsonWriter.close();
	}

}
