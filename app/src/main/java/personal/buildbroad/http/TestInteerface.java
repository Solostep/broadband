//package personal.broadband.http;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.meoogo.util.HttpClientUtil;
//
//public class TestInteerface {
//
//	public static void main(String[] args) {
//		// register();
//		//resetPwd();
//		//setDeviceName();
//		//removeDev();
//		getBindDevice();
//	}
//
//	private static void resetPwd() {
////		HttpClient client = new DefaultHttpClient();
////		String url = "http://passport.21teacher.com/login/thirdparty/api/resetpwd?phone=18633096380&msgcode=434488&password=111111";
////		String result=HttpClientUtil.httpGet(url, client);
////		System.out.println(result);
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("phone", "18633096380");
//		params.put("msgcode", "434488");
//		params.put("password", "111111");
//
//
//		String result = HttpClientUtil.doPost("http://passport.21teacher.com/login/thirdparty/api/resetpwd/", params);
//		System.out.println(result);
//	}
//
//	private static void removeDev() {
////		HttpClient client = new DefaultHttpClient();
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("iusername", "weixin");
//		params.put("ipassword", "weixin");
//		params.put("username", "403913426005555");
//		params.put("usermac", "64:A6:51:E5:33:D3");
//		params.put("appmac", "D8:8F:76:C7:0E:C8");
//
//
//		String result = HttpClientUtil.doPost("http://140.143.3.192/api/Devices/removeDev/", params);
//		System.out.println(result);
//	}
//	private static void setDeviceName() {
////		HttpClient client = new DefaultHttpClient();
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("iusername", "weixin");
//		params.put("ipassword", "weixin");
//		params.put("username", "403913426005555");
//		params.put("alias", "测试设备");
//		params.put("usermac", "D8:8F:76:C7:0E:C8");
//
//
//		String result = HttpClientUtil.doPost("http://140.143.3.192/api/Devices/markDev/", params);
//		System.out.println(result);
//	}
//
//	private static void getBindDevice() {
////		HttpClient client = new DefaultHttpClient();
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("iusername", "weixin");
//		params.put("ipassword", "weixin");
//		params.put("username", "403913426005555");
//
//
//		String result = HttpClientUtil.doPost("http://140.143.3.192/api/Devices/devList/", params);
//		System.out.println(result);
//	}
//
//	private static void register() {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("username", "18603115200");
//		params.put("password", "app5210");
//		params.put("apid", "44-D1-FA-3D-2C-5E");
//		params.put("apidtype", "2"); /// AP设备绑定类型 2=apmac 1=acip |
//		params.put("apidcode", "849278D1-8B38-4124-9191-E2817981A23A"); // apid
//
//		params.put("wlanapmac", "44-D1-FA-3D-2C-5E"); // apmac
//
//		params.put("wlanuserip", "172.16.23.11"); /// wlanuserip
//		params.put("wlanusermac", "20-A6-80-DA-4B-49"); // wlanusermac
//		params.put("wlanacip", "36.110.85.86"); /// wlanacip
//
//		params.put("productid", "5");
//		params.put("iusername", "weixin");
//		params.put("ipassword", "weixin");
//		params.put("channel", "app");
//
//		String result = HttpClientUtil.doPost("http://140.143.3.192/api/newuser/register/", params);
//		System.out.println(result);
//	}
//
//	private static void getProduct() {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("iusername", "weixin");
//		params.put("ipassword", "weixin");
//		params.put("apidtype", "2");
//		params.put("apid", "44-D1-FA-3D-2C-5E");
//		String result = HttpClientUtil.doPost("http://140.143.3.192/api/newuser/getProInfo/", params);
//		System.out.println(result);
//	}
//
//}
