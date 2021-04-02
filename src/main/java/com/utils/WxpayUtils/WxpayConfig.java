package com.utils.WxpayUtils;

public class WxpayConfig {
    /**
     * 微信开发平台应用ID
     */
    public static final String APPID = "wxb7583515beb0f211";//已改
    /**
     * 微信支付商户号
     */
    public static final String MCH_ID = "1603215051";//已改
    /**
     * 应用对应的凭证
     *
     */
    public static final String APP_SECRET = "68c39252926ac35b091b9f824c1e065e";
    /**
     * 应用对应的密钥
     * //微信支付appsecret
     */
    public static final String APP_KEY = "HclM2EDVFJJgvNvfiAS36JuXxwN4PJeN";//已改
    /**
     * 商户号对应的密钥
     * api秘钥
     */
    public static final String PARTNER_KEY = "m6itdr9rutyjrb1Zf3r4d7CW1NmtpL7x";//已改
    /**
     * 商户id
     */
    public static final String PARTNER_ID = "14698sdfs402dsfdew402";
    /**
     * 常量固定值
     */
    public static final String GRANT_TYPE = "client_credential";
    /**
     * 微信服务器回调通知URL
     */
    public static final String NOTIFY_URL = "/wxPayNotify/pay";
    /**
     * 获取预支付ID的接口URL 统一下单接口地址
     */
    public static final String REQUEST_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 关闭订单接口,避免出现(订单重复提交出错)
     */
    public static final String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
    /**
     * 查看订单接口
     */
    public static final String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";


}
