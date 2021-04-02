package com.utils;

import com.alibaba.fastjson.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CountDownUtils {
    private static long day = 0;
    private static long hour = 0;
    private static long minute = 0;
    private static long second = 0;
    private static boolean dayNotAlready = false;
    private static boolean hourNotAlready = false;
    private static boolean minuteNotAlready = false;
    private static boolean secondNotAlready = false;


    public static void main(String[] args) throws ParseException {

        System.out.println(addDateMinut("2020-08-17 10:14:49",43200));


    }

    /**
     * 给指定的时间添加值
     *
     * @param date
     * @param dates
     * @return
     */
    public static String addTime(String date, String dates) {
        Map map = getDistanceTime(date, dates);//获取到两个时间相差多久

        Integer day = map.get("day").hashCode();//天
        Integer hour = map.get("hour").hashCode();//时
        Integer min = map.get("min").hashCode();//分
        if (day != 0) {//天
            day = day * 1440;
        }
        if (hour != 0) {//小时时
            hour = hour * 60;
        }
       /* Integer[] strings = new Integer[map.size()];
        strings[0] = day;
        strings[1] = hour;
        strings[2] = min+1;*/
        String dateTime= DateUtils.getCurrentStrDateTimes();
        dateTime=dateTime+":00";
        String   time=null;
        String   timeTwo=null;
        String   timeTo=null;
        if(day!=0){
            time =addDateMinut(dateTime,day);//把时间差添加进去，得到具体的提醒时间
        }
        if(hour!=0){
            if(time==null){
                timeTwo =addDateMinut(dateTime,hour);//把时间差添加进去，得到具体的提醒时间
            }else{
                timeTwo =addDateMinut(time,hour);//把时间差添加进去，得到具体的提醒时间
            }
        }
        if(min!=0){
            if(timeTwo==null){
                timeTo =addDateMinut(dateTime,min+1);//把时间差添加进去，得到具体的提醒时间
            }else {
                timeTo =addDateMinut(timeTwo,min+1);//把时间差添加进去，得到具体的提醒时间
            }
        }
        System.out.println("真正的提醒的时间"+timeTo);

        return timeTo;
    }

    // 获取两个时间相差分钟数
    public static String addDateMinut(String day, int x) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
        //引号里面个格式也可以是 HH:mm:ss或者HH:mm等等，很随意的，不过在主函数调用时，要和输入的变
        //量day格式一致
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        System.out.println("front 显示输入的日期:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, x);// 24小时制
        date = cal.getTime();
        System.out.println("after: 显示更新后的日期" + format.format(date));  //显示更新后的日期
        cal = null;
        return format.format(date);

    }


    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static Map getDistanceTime(String starttime, String endtime) {
        DateFormat dfb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = new HashMap();
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = dfb.parse(starttime);
            two = dfb.parse(endtime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);//天
            hour = (diff / (60 * 60 * 1000) - day * 24);//时
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);//分
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);//秒
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("day", day);
        map.put("hour", hour);
        map.put("min", min);
        map.put("sec", sec);
        return map;
    }


}
