package com.utils.WxpayUtils;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import net.sf.json.JSONObject;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;


import javax.net.ssl.HttpsURLConnection;


public class HttpUtil {
    /**
     * <p>方法说明: HTTP POST 请求
     * <p>编码格式: UTF8
     * <p>参数说明: String urL 请求的路径
     * <p>参数说明: String parAms 请求的参数
     * <p>返回说明: JSONObject
     */
    public static JSONObject doPost(String url, String params) throws Exception {
        Request request = Request.Post(url);
        request.bodyByteArray(params.getBytes("UTF8"));
        Response response = request.execute();
        String jsonData = response.returnContent().asString();

        /* 转化为 JSONObject 数据 */
        JSONObject json = JSONObject.fromObject(jsonData);
        return json;
    }

    /**
     * <p>方法说明: HTTP GET 请求
     * <p>编码格式: UTF8
     * <p>参数说明: String urL 请求的路径
     * <p>返回说明: JSONObject
     */
    public static JSONObject doGet(String url) throws Exception {
        Request request = Request.Get(url);
        request.setHeader("Content-type", "application/json;charset=UTF8");
        Response response = request.execute();
        String jsonData = response.returnContent().asString();
        JSONObject json = JSONObject.fromObject(jsonData);
        return json;
    }

    /**
     * <p>方法说明: HTTP GET 请求
     * <p>编码格式: UTF8 , 微信编码转为UTF-8
     * <p>参数说明: String urL 请求的路径
     * <p>返回说明: JSONObject
     */
    public static JSONObject doGetUTF8(String url) throws Exception {
        Request request = Request.Get(url);
        request.setHeader("Content-type", "application/json;charset=UTF8");
        Response response = request.execute();
        String jsonData = response.returnContent().asString();
        String string = new String(jsonData.getBytes("ISO-8859-1"), "UTF-8");
        JSONObject json = JSONObject.fromObject(string);
        return json;
    }


    /**
     * <p>方法说明: HTTP POST 请求
     * <p>编码格式: UTF8
     * <p>参数说明: String urL 请求的路径
     * <p>参数说明: String parAms 请求的参数
     * <p>返回说明: String
     */
    public static String doPostToStr(String url, String params) throws Exception {
        Request request = Request.Post(url);
        request.bodyByteArray(params.getBytes("UTF-8"));

        Response response = request.execute();
        return response.returnContent().asString();
    }

    /**
     * 开始post提交参数到接口
     * <p>
     * 并接受返回
     *
     * @param url
     * @param xml
     * @param method
     * @param contentType
     * @return
     */

    public static String xmlHttpProxy(String url, String xml, String method, String contentType) {

        InputStream is = null;

        OutputStreamWriter os = null;


        try {

            URL _url = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();

            conn.setDoInput(true);

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-type", "text/xml");

            conn.setRequestProperty("Cache-Control", "no-cache");

            conn.setRequestMethod("POST");

            os = new OutputStreamWriter(conn.getOutputStream());

            os.write(new String(xml.getBytes(contentType)));

            os.flush();


            //返回值

            is = conn.getInputStream();

            return getContent(is, "utf-8");

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (os != null) {
                    os.close();
                }

                if (is != null) {
                    is.close();
                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return null;

    }

    /**
     * 解析返回的值
     *
     * @param is
     * @param charset
     * @return
     */

    public static String getContent(InputStream is, String charset) {

        String pageString = null;

        InputStreamReader isr = null;

        BufferedReader br = null;

        StringBuffer sb = null;

        try {

            isr = new InputStreamReader(is, charset);

            br = new BufferedReader(isr);

            sb = new StringBuffer();

            String line = null;

            while ((line = br.readLine()) != null) {

                sb.append(line + "\n");

            }

            pageString = sb.toString();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (is != null) {

                    is.close();

                }

                if (isr != null) {

                    isr.close();

                }

                if (br != null) {

                    br.close();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

            sb = null;

        }

        return pageString;

    }

    /**
     * <p>方法说明: HTTP GET 请求
     * <p>编码格式: UTF8
     * <p>参数说明: String urL 请求的路径
     * <p>返回说明: String
     */
    public static String doGetToStr(String url) throws Exception {
        Request request = Request.Get(url);
        request.setHeader("Content-type", "application/json;charset=UTF8");
        Response response = request.execute();
        return response.returnContent().asString();
    }
}
