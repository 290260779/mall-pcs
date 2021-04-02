package com.interceptors;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.quark.api.bean.ResponseValues;
import com.utils.constant.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-23 15:38
 */
public class TokenInterceptor implements Interceptor {

    //private Token tokenDao = new Token().dao();
    private Logger log = Logger.getLogger("TokenInterceptor");
    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        HttpServletRequest request = controller.getRequest();
        HttpServletResponse response = controller.getResponse();
        String tokenValue = request.getHeader("token");
        if (tokenValue == null) {
            log.info("TokenInterceptor intercept token is null");
            resJson(response);
        } else {
            boolean isValid = verifyToken(tokenValue);
            if (isValid) {
                inv.invoke();
            } else {
                log.info("TokenInterceptor intercept token is invalid");
                resJson(response);
            }
        }
    }

    private boolean verifyToken(String tokenValue) {
        String search_token_sql = "SELECT id,token_value,expires_in FROM token WHERE token_value = ?";
      /*  Token token = tokenDao.findFirst(search_token_sql,tokenValue);*/
        String token=null;
        if (token != null) {
            long currentDateTime = System.currentTimeMillis();//时间转换问题currentDateTime: 178958992-10-20 14:32:45
            //long expiresIn = token.getExpiresIn().getTime();
            long expiresIn = 0;
            log.info("expiresIn: " +expiresIn+"; currentDateTime: "+currentDateTime);
            log.info("TokenInterceptor verifyToken "+(currentDateTime <= expiresIn));
            return currentDateTime <= expiresIn;
        }
        log.info("TokenInterceptor verifyToken token is null");
        return false;
    }

    private void resJson(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            ResponseValues responseValues = new ResponseValues();
            responseValues.put("code", Const.RES_MINUS_ONE);
            responseValues.put("tip_msg", "用户令牌token无效");
//            responseValues.put("result", ""); //废弃result字段，android端不好解析
            String content = JSON.toJSONString(responseValues);
            writer.print(content);
        } catch (IOException e) {
            log.info("AccessInterceptor returnJson Exception: 拦截器输出流异常" + e);
        }
    }

}