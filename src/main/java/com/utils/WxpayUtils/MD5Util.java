package com.utils.WxpayUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;

public class MD5Util extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response,String paramStr)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("sessionId", paramStr);
        session.setMaxInactiveInterval(43200*60);
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是："+sessionId);
        }else {
            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
        }
    }
    public  String md5Encodes(String paramStr) throws ServletException, IOException {
        String encodeStr = null;
        try {

            encodeStr = new String(paramStr);
            MessageDigest md = MessageDigest.getInstance("MD5");
            encodeStr = byteArrayToHexString(md.digest(encodeStr.getBytes("UTF-8")));
        } catch (Exception exception) {
        }
        doGet(null,null,encodeStr);
        return encodeStr;
    }
    public static String md5Encode(String paramStr) {
        String encodeStr = null;
        try {

            encodeStr = new String(paramStr);
            MessageDigest md = MessageDigest.getInstance("MD5");
            encodeStr = byteArrayToHexString(md.digest(encodeStr.getBytes("UTF-8")));
        } catch (Exception exception) {
        }

        return encodeStr;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
