package com.mall.api;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.quark.api.annotation.Api;
import com.quark.api.annotation.ApiOfDataType;
import com.quark.api.annotation.ApiOfReturnValue;
import com.quark.api.annotation.ApiOfURLParam;
import com.quark.api.bean.ResponseValues;
import com.service.WxMiniProgram;
import com.utils.constant.Const;


public class Login extends Controller {
    private WxMiniProgram wxMiniProgram = new WxMiniProgram();


    @Clear
    @Api(name = "微信小程序登录", url = Const.RUNNING_URI + "program/loginByWeiXin", author = "")
    @ApiOfURLParam(name = "code", explain = "微信标识", type = ApiOfDataType.String)
    @ApiOfURLParam(name = "encrypteData", explain = "解密用户敏感数据", type = ApiOfDataType.String)
    @ApiOfURLParam(name = "iv", explain = "解密用户敏感数据", type = ApiOfDataType.String)
    @ApiOfReturnValue(name = "code", explain = "1-表示成功，0-表示失败")
    @ApiOfReturnValue(name = "tip_msg", explain = "提示信息")
    @ApiOfReturnValue(name = "result", explain = "返回的结果信息")
    public void loginByWeiXin(String code, String encrypteData, String iv) {
        ResponseValues result = null;
        renderJson(result);
    }


}
