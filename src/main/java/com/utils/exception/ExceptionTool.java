package com.utils.exception;

import java.util.logging.Logger;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-24 10:02
 */
public class ExceptionTool {
    private static Logger log = Logger.getLogger("ExceptionTool");

    public static void throwException(Class clazz,String method,String msg,Exception e) {
        String clazzName = clazz.getSimpleName();
        StringBuilder sb = new StringBuilder("");
        sb.append(clazzName).append(" ")
                .append(method).append(" ")
                .append("exception is ")
                .append(e.toString())
                .append(" 提示信息 ")
                .append(msg);
        log.info(sb.toString());
        e.printStackTrace();
    }
}
