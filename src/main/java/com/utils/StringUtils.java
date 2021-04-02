package com.utils;


import com.quark.api.bean.ResponseValues;
import com.utils.DateUtils;
import com.utils.model.Friend;
import com.utils.model.Times;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-24 14:46
 */
public class StringUtils {
    public String periodValidity="SELECT  id,member_id,period_validity FROM `orders` WHERE member_id=?";

    public String MemberGmtCreate="SELECT id,phone,ios_client_id,android_client_id,gmt_create  FROM member AND is_prompt=0  ORDER BY gmt_create DESC";
    /**
     * 字符串为 null 或者内部字符全部为 ' ' '\t' '\n' '\r' 这四类字符时返回 true
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int len = str.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     * 生成六位数的nickId
     *
     * @return
     */
    public static String makeNickId() {
        String number = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String lowerChar = "abcdefghijklmnopqrstuvwxyz";
//        String upperChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int len = 6;
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(number.length());
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }

    /**
     * 生成token值
     *
     * @return
     */
    public static String generatorTokenValue() {
        String strCurrentTime = String.valueOf(System.currentTimeMillis());
        return DigestUtils.md5Hex(strCurrentTime);
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 验证手机号码
     *
     * @param phoneNumber
     * @return true-手机号码正确，false-手机号码错误
     */
    public static boolean verifyPhone(String phoneNumber) {
        boolean bPhone = notBlank(phoneNumber);
        if (bPhone) {
            String strRegex = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
            Pattern pattern = Pattern.compile(strRegex, Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(phoneNumber);
            return matcher.matches();
        }
        return false;
    }

    /*public static void main(String[] args) throws ParseException {
        String time="2020-08-13 20:50:00";
        String times="2020-08-13 20:30:00";
        time(time,times);
        System.out.println(time(time,times));
    }*/
    public static String time(String startTime, String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm");

        java.util.Date now = df.parse(startTime);

        java.util.Date date = df.parse(endTime);

        long l = now.getTime() - date.getTime();

        String stac = null;

        //当前时间还没有到被提醒的时间
        if (l <= 0) {
            l = Math.abs(l);
            long day = l / (24 * 60 * 60 * 1000);

            long hour = (l / (60 * 60 * 1000) - day * 24);

            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);

            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

            String str = "" + day + "天" + hour + "小时" + min + "分";
            stac = str.replace("-", "");
        }
        //当前时间已经晚于被提醒的时间
        else {
            stac = "0";
        }

        return stac;
    }

    public static String Times(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(time);
        String tiem = sdf.format(date);
        return tiem;
    }

    /*public static void main(String[] args) throws ParseException {
        Times t = new Times();
        ResponseValues result = new ResponseValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2020-08-15 08:15:00");
        String strGmtWork = DateUtils.formatDateToStr(date);
        String strCurrent = DateUtils.getCurrentStrDateTime();
        String strDiffTime = null;
        boolean bFlag = DateUtils.judgeDateSize(strGmtWork);
        if (!bFlag) {
            t.setDelayed_status(1);//已过期，红色
            t.setEarliestTime("0");//剩余时间
        } else {
            long totalGmtDiff = DateUtils.getDiffTimeStamp(strGmtWork, strCurrent);
            long minutes = totalGmtDiff / (1000 * 60);
            long days = minutes / (60 * 24);
            long hours = (minutes - days * (60 * 24)) / (60);
            long min = ((totalGmtDiff / (60 * 1000)) - days * 24 * 60 - hours * 60);
            if (minutes <= 1440) {
                strDiffTime = "剩余" + hours + "小时" + min + "分钟";
                if (hours == 0) {
                    strDiffTime = "剩余" + min + "分钟";
                    System.out.println(strDiffTime);
                }
                t.setDelayed_status(1);//红色紧急
                t.setEarliestTime(strDiffTime);//剩余时等于小于1天，显示剩余时间
            } else {
                strDiffTime = "剩余" + days + "天" + hours + "小时";
                result.put("remain_time", strDiffTime); //剩余时间
                t.setDelayed_status(2);//黄色
                t.setEarliestTime(strDiffTime);//剩余时等于小于2天，显示剩余时间
            }
            if (minutes > 4320) {//三天
                t.setEarliestTime("0");//剩余时间三天
                t.setDelayed_status(3);//正常颜色
            }
        }
    }*/


    public static Times times(String times) throws ParseException {
        Times t = new Times();
        ResponseValues result = new ResponseValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(times);
        String strGmtWork = DateUtils.formatDateToStr(date);
        String strCurrent = DateUtils.getCurrentStrDateTime();
        String strDiffTime = null;
        boolean bFlag = DateUtils.judgeDateSize(strGmtWork);
        if (!bFlag) {
            t.setDelayed_status(1);//已过期，红色
            t.setEarliestTime("0");//剩余时间
        } else {
            long totalGmtDiff = DateUtils.getDiffTimeStamp(strGmtWork, strCurrent);
            long minutes = totalGmtDiff / (1000 * 60);
            long days = minutes / (60 * 24);
            long hours = (minutes - days * (60 * 24)) / (60);
            long min = ((totalGmtDiff / (60 * 1000)) - days * 24 * 60 - hours * 60);
            if (minutes <= 1440) {
                strDiffTime = "剩余" + hours + "小时" + min + "分钟";
                if (hours == 0) {
                    strDiffTime = "剩余" + min + "分钟";
                }
                t.setDelayed_status(1);//红色紧急
                t.setEarliestTime(strDiffTime);//剩余时等于小于1天，显示剩余时间
            } else {
                strDiffTime = "剩余" + days + "天" + hours + "小时";
                result.put("remain_time", strDiffTime); //剩余时间
                t.setDelayed_status(2);//黄色
                t.setEarliestTime(strDiffTime);//剩余时等于小于2天，显示剩余时间
            }
            if (minutes > 4320) {//三天
                t.setEarliestTime("0");//剩余时间三天
                t.setDelayed_status(3);//正常颜色
            }
        }
        return t;
    }


    public static void listSort(List<Map<String, Object>> resultList) {
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = MapUtils.getString(o1, "name");
                String name2 = MapUtils.getString(o2, "name");
                Collator instance = Collator.getInstance(Locale.CHINA);
                return instance.compare(name1, name2);

            }
        });
    }


    //定义排序函数
    public static String[] getSortOfChinese(String[] array) {
        // Collator 类是用来执行区分语言环境这里使用CHINA

        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
        // JDKz自带对数组进行排序。
        Arrays.sort(array, cmp);

        return array;
    }

    public static void main(String[] args) {
       /* String[] a = {"王五", "李四", "张三", "刘六", "白一", "苦二"};
        getSortOfChinese(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }*/
        List list = new ArrayList();
        list.add("王五");
        list.add("李四");
        list.add("张三");
        list.add("刘六");
        list.add("白一");
        list.add("白一");
        StringUtils stringUtils = new StringUtils();
        System.out.println(stringUtils.sorta(list));
    }


    //字母Z使用了两个标签，这里有２７个值
    //i, u, v都不做声母, 跟随前面的字母
    private char[] chartable =
            {
                    '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈',
                    '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然',
                    '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝', '座'
            };
    private char[] alphatableb =
            {
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                    'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
            };
    private char[] alphatables =
            {
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
            };
    private int[] table = new int[27];  //初始化

    {
        for (int i = 0; i < 27; ++i) {
            table[i] = gbValue(chartable[i]);
        }
    }

    //主函数,输入字符,得到他的声母,
    //英文字母返回对应的大小写字母
    //其他非简体汉字返回 '0'  按参数
    public char Char2Alpha(char ch, String type) {
        if (ch >= 'a' && ch <= 'z')
            return (char) (ch - 'a' + 'A');//为了按字母排序先返回大写字母
        // return ch;
        if (ch >= 'A' && ch <= 'Z')
            return ch;

        int gb = gbValue(ch);
        if (gb < table[0])
            return '0';

        int i;
        for (i = 0; i < 26; ++i) {
            if (match(i, gb))
                break;
        }

        if (i >= 26) {
            return '0';
        } else {
            if ("b".equals(type)) {//大写
                return alphatableb[i];
            } else {//小写
                return alphatables[i];
            }
        }
    }

    //根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串
    public String String2Alpha(String SourceStr, String type) {
        String Result = "";
        int StrLength = SourceStr.length();
        int i;
        try {
            for (i = 0; i < StrLength; i++) {
                Result += Char2Alpha(SourceStr.charAt(i), type);
            }
        } catch (Exception e) {
            Result = "";
        }
        return Result;
    }

    //根据一个包含汉字的字符串返回第一个汉字拼音首字母的字符串
    public String String2AlphaFirst(String SourceStr, String type) {
        String Result = "";
        try {
            Result += Char2Alpha(SourceStr.charAt(0), type);
        } catch (Exception e) {
            Result = "";
        }
        return Result;
    }

    private boolean match(int i, int gb) {
        if (gb < table[i])
            return false;
        int j = i + 1;

        //字母Z使用了两个标签
        while (j < 26 && (table[j] == table[i]))
            ++j;
        if (j == 26)
            return gb <= table[j];
        else
            return gb < table[j];
    }

    //取出汉字的编码
    private int gbValue(char ch) {
        String str = new String();
        str += ch;
        try {
            byte[] bytes = str.getBytes("GBK");
            if (bytes.length < 2)
                return 0;
            return (bytes[0] << 8 & 0xff00) + (bytes[1] &
                    0xff);
        } catch (Exception e) {
            return 0;
        }
    }

    public List sorta(List<Friend> list) {
        Map map = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList listfei = new ArrayList();
        Map mapTwo = null;
        List listTwo = new ArrayList();
        Map mapTwos = null;
        String[] alphatableb =
                {
                        "A", "B", "C", "D", "E", "F", "G", "H", "I",
                        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
                };
        for (String a : alphatableb) {
            for (int i = 0; i < list.size(); i++) {//为了排序都返回大写字母
                if (a.equals(String2AlphaFirst(list.get(i).getNick_name(), "b"))) {
                    mapTwo = new HashMap();
                    mapTwo.put("cover", list.get(i).getCover());
                    mapTwo.put("nick_name", list.get(i).getNick_name());
                    mapTwo.put("id", list.get(i).getLinked_member_id());
                    arraylist.add(mapTwo);
                }


            }
            if (mapTwo != null && arraylist.size() != 0) {
                map.put("list", arraylist);
                map.put("lieet", a);
                    /*listTwo.get(listTwo.size());

                    System.out.println(listTwo.get(listTwo.size()));*/

                listTwo.add(map);
                map = new HashMap();
                arraylist = new ArrayList();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if ("0".equals(String2AlphaFirst(list.get(i).getNick_name(), "b"))) {  //首字符不是字母的特殊字符
                mapTwos = new HashMap();
                mapTwos.put("cover", list.get(i).getCover());
                mapTwos.put("nick_name", list.get(i).getNick_name());
                mapTwos.put("id", list.get(i).getLinked_member_id());
                listfei.add(mapTwos);
            }
        }

        map.put("lieet", "#");
        map.put("list", listfei);
        listTwo.add(map);
        return listTwo;
    }



}