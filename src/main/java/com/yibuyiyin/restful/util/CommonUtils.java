package com.yibuyiyin.restful.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共工具类
 */
public class CommonUtils {
    private static final Random random;
    private static final SimpleDateFormat DEFAULT_SDF;
    
    public static String getMd5(final String data) {
        return DigestUtils.md5Hex(data);
    }
    
    public static String getRandomDigital(final int number) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; ++i) {
            sb.append(CommonUtils.random.nextInt(10));
        }
        return sb.toString();
    }
    
    public static String formatDate(final Date date, final String pattern) {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    public static String formatDate(final Date date) {
        return CommonUtils.DEFAULT_SDF.format(date);
    }
    
    public static String getUUID() {
        final String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
    
    public static Date parseDate(final String dateStr) throws ParseException {
        return CommonUtils.DEFAULT_SDF.parse(dateStr);
    }
    
    public static Date parseDate(final String dateStr, final String pattern) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }
    
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
                 *     驼峰格式字符串转换为下划线格式字符串
     * 
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
            	if(sb.length() > 0)
            		sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else if(Character.isDigit(c) && i > 0 && !Character.isDigit(param.charAt(i - 1))){
            	if(sb.length() > 0)
            		sb.append('_');
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static {
        random = new Random(1977L);
        DEFAULT_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    public static String addDay(String s, int n) {
        try {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));   
            cd.add(Calendar.DATE, n);//增加一天
            return sdf.format(cd.getTime());   
        } catch (Exception e) {
            return null;   
        } 
    }
}

