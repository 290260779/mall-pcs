package com.utils.WxpayUtils;


import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.quark.api.bean.ResponseValues;
import com.utils.model.BaseModel;
import com.jfinal.kit.HttpKit;

import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;


import com.jfinal.kit.HttpKit;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;

/**
 * <p>类  说  明: TODO 微信支付工具
 * <p>创建时间: 2017年11月7日 上午10:37:46
 * <p>创  建  人: geYang
 **/
public class WxpayUtil extends BaseModel {
    private static final String STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * <p>方法说明: TODO 获取微信回调地址
     **/
    public static String getNotifyUrl(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        return requestURL.substring(0, requestURL.indexOf("/front/")) + WxpayConfig.NOTIFY_URL;
    }

    /**
     * <p>方法说明: TODO 统一下单 参数处理
     * <p>参数说明: String orderNo       订单号
     * <p>参数说明: String totalAmount   订单总金额
     * <p>参数说明: String notifyUrl     回调通知地址
     * <p>参数说明: String body          订单描述
     **/
    public static String getUnifiedOrder(String orderNo, String totalAmount, String notifyUrl, String body) {
        SortedMap<String, String> paramMap = new TreeMap<String, String>();
        paramMap.put("appid", WxpayConfig.APPID);     //应用ID
        paramMap.put("mch_id", WxpayConfig.MCH_ID);   //商户号
        paramMap.put("body", body);                   //商品描述
        paramMap.put("nonce_str", getNonceStr(null)); //随机字符串
        paramMap.put("out_trade_no", orderNo);        //商户订单号
        paramMap.put("total_fee", getTotalFee(totalAmount));//支付总金额
        paramMap.put("spbill_create_ip", getLocalhostIP());  //当前本机IP: 192.168.102.10
        paramMap.put("notify_url", notifyUrl);              //回调通知地址
        paramMap.put("trade_type", "APP");                  //支付类型
        paramMap.put("sign", rsaSign(paramMap));            //数据签名
        return getRequestXML(paramMap);     //请求参数
    }
    /*public static String createSgin(String orderNo,String totalAmount,String notifyUrl,String body) throws NoSuchAlgorithmException {
        String sign = "appid="+ WxpayConfig.APPID+
                "&body="+body+
                "&mch_id="+WxpayConfig.MCH_ID+
                "&nonce_str="+getNonceStr(null)+
                "&notify_url="+notifyUrl+
                "&openid="+""+
                "&out_trade_no="+orderNo+
                "&spbill_create_ip="+getLocalhostIP()+
                "&total_fee="+getTotalFee(totalAmount)+
                "&trade_type="+"APP";
        sign += "&key=Yq1qaz2wsx3edc4rfv5tgb6yHJJ123";
        //签名加密
        return getRequestXML(sign);
    }*/

    /**
     * <p>方法说明: TODO 返回APP 参数处理
     * <p>参数说明: String prepayId   预支付交易会话ID
     * <p>返回说明:
     *
     * @return
     */
    public static Map<String, String> getReturnParam(String prepayId) {
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;
        String timestamp = String.valueOf(totalSeconds).substring(0, 10);
//        String timestamp = (System.currentTimeMillis() / 1000 +"").substring(0, 10);
        SortedMap<String, String> returnMap = new TreeMap<String, String>();
        returnMap.put("appid", WxpayConfig.APPID);      //应用ID
        returnMap.put("partnerid", WxpayConfig.MCH_ID); //商户号
        returnMap.put("prepayid", prepayId);            //预支付交易会话ID
        returnMap.put("packageValue", "Sign=WXPay");         //扩展字段 固定值 Sign=WXPay
        returnMap.put("nonce_str", getNonceStr(null));   //随机字符串
        returnMap.put("timestamp", timestamp);          //时间戳
        returnMap.put("sign", rsaSign(returnMap));      //签名
        return returnMap;   //请求参数
    }

    public static ResponseValues createOrder(String body, String attach) throws Exception {
        String sign = "";
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;
        String timestamp = String.valueOf(totalSeconds).substring(0, 10);


        String nonce_str = getNonceStr(null);

        // body = new String(body.getBytes(),"UTF-8");
        sign = "appid=" + WxpayConfig.APPID + "&attach=" + attach + "&body=" + body + "&mch_id=" + WxpayConfig.MCH_ID + "&nonce_str="
                + nonce_str + "&notify_url=" + "http://192.168.0.106:8088/lingzhi//wxPayNotify/pay" + "&out_trade_no=" + nonce_str
                + "&spbill_create_ip=" + getLocalhostIP() + "&total_fee=" + "asjkdhj" + "&trade_type=" + "APP"
                + "&key=" + WxpayConfig.MCH_ID;
        //json2map(sign);


        String pams = MD5Util.md5Encode(sign).toUpperCase();
        String xml = ("<xml>" + "<appid><![CDATA[" + WxpayConfig.APPID + "]]></appid>" + "<mch_id><![CDATA[" + WxpayConfig.MCH_ID
                + "]]></mch_id>" + "<body><![CDATA[" + body + "]]></body>" + "<nonce_str><![CDATA[" + nonce_str + "]]></nonce_str>" + "<notify_url><![CDATA["
                + "http://192.168.0.106:8088/lingzhi//wxPayNotify/pay" + "]]></notify_url>" + "<out_trade_no><![CDATA[" + nonce_str + "]]></out_trade_no>"
                + "<spbill_create_ip><![CDATA[" + getLocalhostIP()
                + "]]></spbill_create_ip>" + "<total_fee><![CDATA[" + 28.00 + "]]></total_fee>"
                + "<trade_type><![CDATA[" + "APP" + "]]></trade_type>" + "<sign><![CDATA[" + pams + "]]></sign>"
                + "</xml>");
        Map<String, String> postHeader = new HashMap<String, String>();
        postHeader.put("Content-Type", "text/html;charset=UTF-8");
        /*String unifiedOrder_result_str = HttpKit.post("https://api.mch.weixin.qq.com/pay/unifiedorder", xml,
                postHeader);*/

        String xmlStr = HttpUtil.xmlHttpProxy(WxpayConfig.REQUEST_URL, xml, "POST", "UTF-8");
        String prepayid = Jsoup.parse(xmlStr).select("prepay_id").text();
        ResponseValues values = new ResponseValues();
        values.put("prepayid", prepayid);
        values.put("package", "prepay_id=" + prepayid);
        values.put("noncestr", nonce_str);
        values.put("timestamp", timestamp);
        String appsign_str = "appId=" + WxpayConfig.APPID + "&nonceStr=" + nonce_str + "&package=" + "prepay_id=" + prepayid
                + "&signType=MD5" + "&timeStamp=" + timestamp;
        //String appsign = com.jfinal.kit.EncryptionKit.md5Encrypt(appsign_str + "&key=" + WxpayConfig.MCH_ID).toUpperCase();
        String appsign = MD5Util.md5Encode(appsign_str).toUpperCase();
        values.put("sign", appsign);
        return values;
    }

    public static SortedMap<String, String> json2map(String str_json) {
        SortedMap<String, String> res = null;
        try {
            Gson gson = new Gson();
            res = gson.fromJson(str_json, new TypeToken<SortedMap<String, String>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
        }
        return res;
    }

    /**
     * <p>方法说明: TODO 关闭/查看 订单 参数处理
     * <p>参数说明: String orderNo 商户订单号
     **/
    public static String closeORqueryOrderParam(String orderNo) {
        SortedMap<String, String> returnMap = new TreeMap<String, String>();
        returnMap.put("appid", WxpayConfig.APPID);      //应用ID
        returnMap.put("mch_id", WxpayConfig.MCH_ID);    //商户号
        returnMap.put("out_trade_no", orderNo);         //商户订单号
        returnMap.put("nonce_str", getNonceStr(null));  //随机字符串
        returnMap.put("sign", rsaSign(returnMap));      //签名
        return getRequestXML(returnMap);     //请求参数
    }

    /**
     * <p>方法说明: TODO 验证签名
     * <p>参数说明: Map<String,String> paramMap
     * <p>返回说明: boolean
     **/
    public static boolean rsaCheck(Map<String, String> paramMap) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓微信支付签名验证处理↓↓↓↓↓↓↓↓↓↓");
        SortedMap<String, String> paramSorMap = new TreeMap<String, String>();
        paramSorMap.putAll(paramMap);
        boolean rsaCheck = paramMap.get("sign").equals(rsaSign(paramSorMap));
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        return rsaCheck;
    }

    /**
     * <p>方法说明: TODO sign签名
     * <p>参数说明: SortedMap<String,String> paramMap
     * <p>返回说明: String
     **/
    private static String rsaSign(SortedMap<String, String> paramMap) {
        StringBuffer paramStr = new StringBuffer();
        Set<Entry<String, String>> paramSet = paramMap.entrySet();
        Iterator<Entry<String, String>> it = paramSet.iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String k = entry.getKey();
            String v = entry.getValue();
            if (v != null && !"sign".equals(k) && !"key".equals(k)) {
                paramStr.append(k + "=" + v + "&");
            }
        }
        paramStr.append("key=" + WxpayConfig.APP_KEY);     //注：key为商户平台设置的密钥key
        String sign = MD5Util.md5Encode(paramStr.toString()).toUpperCase();//注：MD5签名方式
        System.out.println("微信签名参数==" + paramStr.toString());
        System.out.println("微信签  名  值==" + sign);
        return sign;
    }

    /**
     * <p>方法说明: TODO 生成随机字符串
     * <p>参数说明: Integer length 默认16
     * <p>返回说明: 长度为 length 的字符串
     **/
    public static String getNonceStr(Integer length) {
        String result = "";
        if (length == null) {
            length = 16;
        }
        StringBuffer nonceStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            nonceStr.append(STR.charAt(rd.nextInt(STR.length() - 1)));
        }
        long pam = System.currentTimeMillis();
        result = pam + "" + nonceStr;
        result = result.toUpperCase();
        System.out.println("getNonceStr result = " + result);
        return result;
    }

    /**
     * <p>方法说明: TODO 获取本机IP
     * <p>返回说明: 通过 获取系统所有的networkInterface网络接口 然后遍历 每个网络下的InterfaceAddress组,
     * 获得符合  "InetAddress instanceof Inet4Address" 条件的一个IpV4地址
     **/
    private static String getLocalhostIP() {
        String ip = null;
        Enumeration<?> allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                List<InterfaceAddress> interfaceAddress = netInterface.getInterfaceAddresses();
                for (InterfaceAddress add : interfaceAddress) {
                    InetAddress inetAddress = add.getAddress();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) {
                        ip = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("获取IP异常");
        }
        return ip;
    }

    /**
     * <p>方法说明: TODO 将请求参数转换为XML格式的String
     * <p>参数说明: SortedMap<String,String> paramMap
     * <p>返回说明: String
     **/
    private static String getRequestXML(SortedMap<String, String> paramMap) {
        StringBuffer requestXML = new StringBuffer();
        requestXML.append("<xml>");
        Set<Entry<String, String>> paramSet = paramMap.entrySet();
        Iterator<Entry<String, String>> it = paramSet.iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String k = entry.getKey();
            String v = entry.getValue();
            requestXML.append("<" + k + ">" + v + "</" + k + ">");
        }
        requestXML.append("</xml>");
        System.out.println("微信请求参数==" + requestXML);

        return requestXML.toString();
    }

    /**
     * <p>方法说明: TODO 获取整数格式支付总金额
     * <p>参数说明: String totalAmount  保留两位小数的金额
     * <p>返回说明: String getTotalFee  整数的金额
     **/
    private static String getTotalFee(String totalAmount) {
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return decimalFormat.format(Double.valueOf(totalAmount) * 100);
    }


    /**
     * <p>方法说明: TODO 订单查看处理
     **/
    public static Map<String, String> orderQuery(String orderNo) throws Exception {
        System.out.println("↓↓↓↓↓↓↓↓↓↓微信支付订单查看处理↓↓↓↓↓↓↓↓↓↓");
        String receiveParam = HttpUtil.doPostToStr(WxpayConfig.ORDER_QUERY_URL, closeORqueryOrderParam(orderNo));
        return XMLutlis.doXMLParse(receiveParam);
    }

    /**
     * <p>方法说明: TODO 订单关闭处理
     **/
    public static Map<String, String> colseOrder(String orderNo) throws Exception {
        System.out.println("↓↓↓↓↓↓↓↓↓↓微信支付订单关闭处理↓↓↓↓↓↓↓↓↓↓");
        String receiveParam = HttpUtil.doPostToStr(WxpayConfig.CLOSE_ORDER_URL, closeORqueryOrderParam(orderNo));
        return XMLutlis.doXMLParse(receiveParam);
    }


    public static void main(String[] args) throws Exception {
        String orderNo = "R20171027114996454";
        System.out.println(orderQuery(orderNo));//查询订单结果数据
        //System.out.println(colseOrder(orderNo));
    }


}