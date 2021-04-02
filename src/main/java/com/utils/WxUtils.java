package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.utils.AES.AES;
import com.utils.AES.WxPKCS7Encoder;
import com.utils.WxpayUtils.CommonUtil;
import com.utils.WxpayUtils.HttpUtil;
import com.utils.WxpayUtils.Template;
import com.utils.model.TemplateParam;
import org.apache.commons.codec.binary.Base64;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-30 15:30
 * 类说明：微信授权工具类
 */
public class WxUtils {
    private static final String APP_ID = "";
    private static final String APP_SECRET = "";

    //通过code获取access_token
    public static JSONObject getAccessToken(String codeValue) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID + "&secret=" +
                APP_SECRET + "&code=" + codeValue + "&grant_type=authorization_code";
        return HttpUtils.doGetJson(url);
    }

    //检查access_token的有效性
    public static JSONObject validateAccessToken(String accessToken, String openId) {
        String validateUrl = "https://api.weixin.qq.com/sns/auth?access_token=" + accessToken + "&openid=" + openId;
        return HttpUtils.doGetJson(validateUrl);
    }

    //通过refresh_token刷新access_token
    public static JSONObject refreshAccessToken(String refreshToken) {
        String refreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + APP_ID + "&grant_type=refresh_token&refresh_token=" + refreshToken;
        return HttpUtils.doGetJson(refreshTokenUrl);
    }

    //获取用户信息
    public static JSONObject getUserInfo(String accessToken, String openId) {
        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" +
                accessToken + "&openid=" + openId + "&lang=zh_CN";
        return HttpUtils.doGetJson(userInfoUrl);
    }

    /**
     * 获取微信小程序的session_key和openid
     *
     * @param codes
     * @return
     */
    public static Map getSessionKeyAndOpenId(String codes) throws Exception {
        Map map = null;
        //微信登录的code值
        String wxCode = codes;
        //封装需要的参数信息
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        //开发者设置中的appId
        requestUrlParam.put("appid", "wx727c5a5050969834");
        //开发者设置中的appSecret
        requestUrlParam.put("secret", "2106abab6643aa96073a920a98004b68");
        //固定调取微信的URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //小程序调用wx.login返回的code
        requestUrlParam.put("js_code", wxCode);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        map = JSONObject.parseObject(HttpUtils.sendPost(requestUrl, requestUrlParam));
        return map;
    }


    /**
     * AES解密
     *
     * @param data           //密文，被加密的数据
     * @param key            //秘钥
     * @param iv             //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     * @return
     * @throws Exception
     */
    public static String decrypts(String data, String key, String iv, String encodingFormat) throws Exception {
//        initialize();

        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(data.getBytes());
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key.getBytes());
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv.getBytes());
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return result;
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 解密数据
     *
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedData, String sessionKey, String iv) {
        String result = "";
        try {
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                result = new String(WxPKCS7Encoder.decode(resultByte));
                JSONObject jsonObject = JSONObject.parseObject(result);
                return jsonObject.toJSONString();
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }

    /*public static void main(String[] args) throws Exception {
        System.out.println(wxMessage("omGT94ny9K-dxEdIhH7A7cnP3oUc"));
    }*/

    public static String wxMessage(String openid,String title,String time,String content,String name) throws Exception {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + "wx727c5a5050969834"
                + "&secret="
                + "2106abab6643aa96073a920a98004b68";
        net.sf.json.JSONObject result = HttpUtil.doGet(url);
        JSONObject object = JSONObject.parseObject(result.toString());
        String Access_Token = object.getString("access_token");
        Template template = new Template();
        template.setTemplate_id("fyjRA7XPlvqUietYJql0T4qo9b7Bdlqb6PyOtQn2tXE");
        template.setTouser(openid);
        template.setPage("pages/index/index");
        List<TemplateParam> paras = new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("thing1", title));
        paras.add(new TemplateParam("time2", time));
        paras.add(new TemplateParam("thing3", content));
        paras.add(new TemplateParam("name4", name));
        paras.add(new TemplateParam("thing6", "请进入小程序查看哦"));
        template.setTemplateParamList(paras);
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", Access_Token);

        System.out.println(template.toJSON());
        net.sf.json.JSONObject jsonResult = CommonUtil.httpsRequest(requestUrl, "POST", template.toJSON());
        if (jsonResult != null) {
            System.out.println(jsonResult);
            int errorCode = jsonResult.getInt("errcode");
            String errorMessage = jsonResult.getString("errmsg");
            if (errorCode == 0) {
                System.out.println("Send Success 发送成功");
            } else {
                System.out.println("订阅消息发送失败:" + errorCode + "," + errorMessage);
            }
        }
        return null;
    }
}
