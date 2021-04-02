package com.utils.constant;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-23 15:07
 */
public interface Const {

    //pro 线上
    /*String RUNNING_URI = "https://pq.jizhidamo.com/lingzhi/";
    String IMAGE_URI = "https://pq.jizhidamo.com/lingzhi/upload/";
    String IMAGE_PATH_COVER = "C:/jizhi-lingzhi/upload/images/cover";*/

    //local 线下
    //String RUNNING_URI = "https://www.ringsomeone.com/lingzhi/";//"http://localhost:8088/lingzhi/";
    String RUNNING_URI = "http://localhost:8088/lingzhi/";

    String IMAGE_URI = "https://www.ringsomeone.com/upload/";
    String IMAGE_PATH_COVER = "C:/lingzhi/cover/"; //"/Users/allenzhang/Documents/backup-project/"

    //响应的code值:0-失败，1-成功，-1-token失效
    int RES_ZERO = 0;
    int RES_ONE = 1;
    int RES_MINUS_ONE = -1;

    //待办日程：ADD-，UPDATE-编辑日程
    String SCHEDULE_ADD = "ADD";
    String SCHEDULE_UPDATE = "UPDATE";


    //已经被删除
    int IS_DELETED = 0;
    //未被删除
    int IS_NOT_DELETED = 1;

    //信息是否读：0-未读，1-已读
    int NO_READ = 0;
    int HAD_READ = 1;

    //日程类型：1-自己创建的，2-好友艾特的
    int SCHEDULE_MY = 1;
    int SCHEDULE_FRIEND = 2;

    //用户接受通知的状态值：通知提醒状态0-关闭，1-开启
    int NOTICE_CLOSE = 0;
    int NOTICE_OPEN = 1;

    //群组成员类型：角色1-群主，2-成员
    int GROUP_ROLE_LEADER = 1;
    int GROUP_ROLE_MEMBER = 2;

    int openVip=2;
    //好友状态值:0-删除，1-存在，2-待确认
    int STATUS_DELETED = 0;
    int STATUS_EXIST = 1;
    int STATUS_CONFIRM = 2;

    //微信授权登录
    String APP_ID = "";
    String APP_KEY = "";
    String SECRET = "";

    int CAPTCHA_INTERVAL = 1; //短信验证码的有效时长

    //短信验证码类型值：1-注册类型，2-登录类型
    int MESSAGE_REGISTER = 1;
    int MESSAGE_LOGIN = 2;

    //登录调试，true-打开，false-关闭
    boolean DEBUG_LOGIN = true;

}
