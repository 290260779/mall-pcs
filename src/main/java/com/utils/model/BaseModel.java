package com.utils.model;

import com.quark.api.bean.ResponseValues;
import com.utils.constant.Const;

import java.util.logging.Logger;

/**
 * @Author WeiWei Zhang
 * @Date 2020-04-23 14:19
 */
public class BaseModel {

    public int code = Const.RES_ZERO;  //默认值为0-失败，1-成功
    public String msg = ""; //提示信息
    public Object result = null; //响应的结果集信息

    public Logger log = Logger.getLogger("BaseModel");

    public ResponseValues resValue() {
        ResponseValues responseValues = new ResponseValues();
        responseValues.put("code", code);
        responseValues.put("tip_msg", msg);
        responseValues.put("result", result);
        return responseValues;
    }
}
