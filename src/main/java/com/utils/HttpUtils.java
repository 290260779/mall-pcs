package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.quark.api.bean.ResponseValues;
import com.utils.constant.Const;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-30 10:21
 */
public class HttpUtils {
    private static Logger log = Logger.getLogger("HttpUtils");

    /**
     * get 请求
     *
     * @param urlRequest 请求地址
     * @return
     */
    public static ResponseValues getMethod(String urlRequest, Map<String, String> params) {
        log.info("HttpUtils getMethod input value: urlRequest=" + urlRequest);
        String responseResult = "";
        int nCode = 0;
        String strTipMsg = "";
        ResponseValues responseValues = new ResponseValues();
        Document document;
        try {
            if (null == params) {
                document = Jsoup.connect(urlRequest).timeout(40000).ignoreContentType(true).get();

            } else {
                document = Jsoup.connect(urlRequest).timeout(40000).data(params).ignoreContentType(true).get();
            }
            responseResult = document.body().html();
            nCode = 1;
            strTipMsg = "请求数据成功";
        } catch (Exception e) {
            strTipMsg = "请求数据失败";
            log.info("HttpUtils getMethod Exception: " + e.toString());
            e.printStackTrace();
        }
        responseValues.put("code", nCode);
        responseValues.put("tip_msg", strTipMsg);
        responseValues.put("result", responseResult);
        log.info("HttpUtils getMethod output result: " + responseValues.toString());
        return responseValues;
    }

    /**
     * 封装请求微信的授权接口，返回一个JSONObject
     * @param url
     * @return
     */
    public static JSONObject doGetJson(String url) {
        JSONObject jsonObject = null;
        ResponseValues result = getMethod(url, null);
        int nCode = (int) result.get("code");
        if (nCode == Const.RES_ONE) {
            String resResult = (String) result.get("result");
            jsonObject = JSONObject.parseObject(resResult);
        }
        return jsonObject;
    }


    public static void main(String[] args) {
        String url = "https://pq.jizhidamo.com/jizhi-damo/box/receiveCardInfo?card_physical_addr=11111&bluetooth_addr=F0:08:D1:56:17:EA&wifi_name=33333&wifi_password=22222";
        ResponseValues result = getMethod(url, null);
        System.out.println(result.toString());
    }
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, ?> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String param = "";
        Iterator<String> it = paramMap.keySet().iterator();

        while(it.hasNext()) {
            String key = it.next();
            param += key + "=" + paramMap.get(key) + "&";
        }

        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
           e.getMessage();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
