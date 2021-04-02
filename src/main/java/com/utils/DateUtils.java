package com.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-24 11:34
 */
public class DateUtils {
    //日期时间类型
    private static SimpleDateFormat simpleFormatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //日期类型
    private static SimpleDateFormat simpleFormatDate = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat simpleFormatDateTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    /**
     * 获取当前日期值 java.util.Date
     *
     * @return
     */
    public static Date getCurrentDateTime() {
        Date date = new Date(System.currentTimeMillis());
        String strDateTime = simpleFormatDateTime.format(date);
        Date dateTime = null;
        try {
            dateTime = simpleFormatDateTime.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String dateToStrLong(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }


    public static boolean isLatestWeek(Date addtime,Date now) {
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(now);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -7);  //设置为7天前
        Date before7days = calendar.getTime();   //得到7天前的时间
        if (before7days.getTime() < addtime.getTime()) {
            return true;
        } else {
            return false;
        }
    }
        /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        //String time= s.substring(0,10);
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);

        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static Date stampToDates(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        Date time = convertStrDateTimeToDate(res);
        return time;
    }

    /**
     * 日期字符串转换为java.util.Date
     *
     * @param str
     * @return
     */
    public static Date convertStrDateTimeToDate(String str) {
        Date date = null;
        try {
            date = simpleFormatDateTime.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * token的有效时间，30分钟，token过期需要重新登录
     *
     * @return
     */
    public static Date tokenExpiresIn() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, 90);   //三十天有效
        return calendar.getTime();
    }

    /**
     * 获取当前字符串日期值
     *
     * @return
     */
    public static String getCurrentStrDateTime() {
        Date date = new Date(System.currentTimeMillis());
        return simpleFormatDateTime.format(date);
    }

    /**
     * 获取当前字符串日期值,子到分
     *
     * @return
     */

    public static String getCurrentStrDateTimes() {
        Date date = new Date(System.currentTimeMillis());
        return simpleFormatDateTimes.format(date);
    }

    public static String formatDateToStr(Date date) {
        return simpleFormatDateTime.format(date);
    }

    /**
     * 计算两个时间的间隔值，精确到分钟
     *
     * @param strLargeDateTime
     * @param strSmallDateTime
     * @return
     */
    public static long calculateTimeDiff(String strLargeDateTime, String strSmallDateTime) {
        long minutes = 0;
        long diff = getDiffTimeStamp(strLargeDateTime, strSmallDateTime);
        minutes = diff / (1000 * 60);
        return minutes;
    }

    /**
     * 两个时间差，时间戳值
     *
     * @param strLargeDateTime
     * @param strSmallDateTime
     * @return
     */
    public static Long getDiffTimeStamp(String strLargeDateTime, String strSmallDateTime) {
        long diff = 0;
        try {
            Date smallDateTime = simpleFormatDateTime.parse(strSmallDateTime);
            Date largeDateTime = simpleFormatDateTime.parse(strLargeDateTime);
            diff = largeDateTime.getTime() - smallDateTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    /**
     * 当前时间是否在有效时间之前，是-返回true，否-返回false
     *
     * @param expiresIn
     * @return
     */
    public static boolean judgeDateSize(String expiresIn) {
        boolean bFlag = false;
        Date nowDate = getCurrentDateTime();
        try {
            bFlag = nowDate.before(simpleFormatDateTime.parse(expiresIn));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 计算给定时间的毫秒值
     *
     * @param dateTime
     * @return
     */
    public static Long calculateMillisByTime(Date dateTime) {
        Long result = null;
        long hour = 0L;
        long minute = 0L;
        long second = 0L;
        try {
            String strGmtWork = DateUtils.formatDateToStr(dateTime);
            String HHmm = strGmtWork.substring(11);
            String[] arrHHmm = HHmm.split(":");
            String hours = arrHHmm[0];
            String minutes = arrHHmm[1];
            String seconds = arrHHmm[2];
            hour = Long.parseLong(hours);
            minute = Long.parseLong(minutes);
            second = Long.parseLong(seconds);
            result = ((hour * 60 * 60) + (minute * 60) + second) * 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 计算两个日期之间相差的天数
     * startDate 购买的时间
     * endDate 当前时间
     */
    public static int BetweenDays(String startDate) {
        //startDate = startDate + ":00";

        String endDate = getCurrentStrDateTimes();
        endDate = endDate + ":00";
        /*// 获取日期
        Date date1 = MyDateUtil.parseDate(startDate, "yyyy-MM-dd HH:mm:ss");
        Date date2 = MyDateUtil.parseDate(endDate, "yyyy-MM-dd HH:mm:ss");*/
        Date startDates = convertStrDateTimeToDate(startDate);
        Date endDates = convertStrDateTimeToDate(endDate);
        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDates);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(endDates);
        long timeInMillis2 = calendar.getTimeInMillis();
        long betweenDays = (timeInMillis2 - timeInMillis1) / (1000L * 3600L * 24L);

        return (int) betweenDays;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        //时间格式定义
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前时间日期--nowDate
        String nowDate = format.format(new Date());
        //获取30天前的时间日期--minDate
        Calendar calc = Calendar.getInstance();
        calc.add(Calendar.DAY_OF_MONTH, -7);
        String minDate = format.format(calc.getTime());
        try {
            //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            //获取字符串转换后的时间--strDate
            String strDate = format.format(format.parse(str));
            //判断传的STR时间，是否在当前时间之前，且在30天日期之后-----测试的时候打印输出结果
//			System.out.println("nowDate.compareTo(strDate):"+ nowDate.compareTo(strDate));
//			System.out.println("strDate.compareTo(minDate):"+ strDate.compareTo(minDate));
            if (nowDate.compareTo(strDate) >= 0 && strDate.compareTo(minDate) >= 0) {
                convertSuccess = true;
            } else {
                convertSuccess = false;
            }
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }


}
