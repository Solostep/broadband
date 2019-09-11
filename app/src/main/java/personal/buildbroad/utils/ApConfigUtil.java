package personal.buildbroad.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyn18 on 18-4-23.
 */

public class ApConfigUtil {
    public static String  getwifiMacAddress() {
        try {
            return loadFileAsString("/sys/class/net/wlan0/address")
                    .toUpperCase().substring(0, 17);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String loadFileAsString(String filePath)
            throws java.io.IOException {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();

    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }
                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:",b));
                }
                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }
    public static String getConnectedWifiMacAddress(Context context) {
        String connectedWifiMacAddress = null;
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> wifiList;

        if (wifiManager != null) {
            wifiList = wifiManager.getScanResults();
            WifiInfo info = wifiManager.getConnectionInfo();
            if (wifiList != null && info != null) {
                for (int i = 0; i < wifiList.size(); i++) {
                    ScanResult result = wifiList.get(i);
                    if (info.getBSSID().equals(result.BSSID)) {
                        connectedWifiMacAddress = result.BSSID;
                    }
                }
            }
        }
        return connectedWifiMacAddress;
    }
    /**
     * wifi获取 路由ip地址
     *
     * @param context
     * @return
     */
/*    public static String getWifiRouteIPAddress(Context context) {
        WifiManager wifi_service = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcpInfo = wifi_service.getDhcpInfo();
//        WifiInfo wifiinfo = wifi_service.getConnectionInfo();
//        System.out.println("Wifi info----->" + wifiinfo.getIpAddress());
//        System.out.println("DHCP info gateway----->" + Formatter.formatIpAddress(dhcpInfo.gateway));
//        System.out.println("DHCP info netmask----->" + Formatter.formatIpAddress(dhcpInfo.netmask));
        //DhcpInfo中的ipAddress是一个int型的变量，通过Formatter将其转化为字符串IP地址
        String routeIp = Formatter.formatIpAddress(dhcpInfo.gateway);
        Log.d("tag", "wifi route ip：" + routeIp);

        return routeIp;


    }*/

    public static String getWifiRouteMACAddress(Context context) {
        String netMac = "";
        WifiManager mWifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        if (mWifi.isWifiEnabled()) {
            //String netName = wifiInfo.getSSID(); //获取被连接网络的名称
            //String localMac = wifiInfo.getMacAddress();// 获得本机的MAC地址
            netMac =  mWifi.getConnectionInfo().getBSSID(); //获取被连接网络的mac地址
            if (netMac!=null&&!"".equals(netMac)&&!netMac.equals("00:00:00:00:00:00")&&!netMac.equals("02:00:00:00:00:00")){
                netMac = str2HexStr(netMac).toUpperCase();
            }else{
                netMac="";
            }
        }
        return netMac;
    }
    /**
     * mac地址转换为十六进制并减二
     * @param str
     * @return
     */
    private static String str2HexStr(String str) {
        if (null==str||"".equals(str)||str.equals("00:00:00:00:00:00")||str.equals("00-00-00-00-00-00")){
            return "";
        }
        String start = str.substring(0,str.length()-8);
        String union = "";
        if(str.contains("-")){
            union = "-";
        }else if(str.contains(":")){
            union = ":";
        }
        String end = str.substring(str.length()-8).replace(union,"");
        int parseInt = Integer.parseInt(end, 16);
        parseInt =parseInt - 2;
        end = Integer.toHexString(parseInt).toUpperCase();
        Log.d("tag","end:"+end);
        end = end.substring(0,2)+union+end.substring(2,4)+union+end.substring(end.length()-2);
        return start+end;
    }
}
