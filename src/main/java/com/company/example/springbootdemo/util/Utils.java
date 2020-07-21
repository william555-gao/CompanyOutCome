package com.company.example.springbootdemo.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName:Util
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/6/2 10:27
 * @Version: 1.0
 */
@Log4j2
public class Utils {

    /**
     * 从request中获取请求方IP
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * @param request ff
     * @param para    ff
     * @return String ff
     * @Title: getParameterFromRequest
     * @Description: 获取Request中的parameter的值，如果没有的话则为“”
     * @time 2016年11月24日 上午10:55:03
     */
    public static String getParameterFromRequest(HttpServletRequest request, String para) {
        String value = request.getParameter(para);
        if (Utils.isNull(value)) {
            return "";
        } else {
            return value;
        }
    }


    /**
     * 通过不定长的参数，将需要返回到页面的值封装到ModelAndView中去
     * 返回的属性字段为各参数的类型名（首字母小写）
     * eg：如类型为PageInfo，则页面中可以用pageInfo字段来获取
     * 对于字符串基本类型，则返回string，故对于字符串，int等基本类型
     * 通过此方法获取mav对象后，在control层添加。
     *
     * @param mavName mav路径常量
     * @param args    需要返回到页面的对象
     * @return 返回的mav对象
     */
    public static ModelAndView getMav(String mavName, Object... args) {
        ModelAndView mav = new ModelAndView(mavName);
        for (final Object s : args) {
            if (null == s) {
                continue;
            }
            mav.addObject(s);
        }
        return mav;
    }


    /**
     * Is null boolean.
     *
     * @param objList List
     * @return boolean boolean
     */
    public static boolean isNull(List objList){
        return objList==null||objList.size()==0;
    }
    /**判断字符串是否为空*/
    /**
     * Is null boolean.
     *
     * @param value String
     * @return boolean boolean
     */
    public static boolean isNull(String value){
        return (value==null||value.trim().length()==0);
    }
    /**判断日期变量是否为空*/
    /**
     * Is null boolean.
     *
     * @param date Date
     * @return boolean boolean
     */
    public static boolean isNull(Date date){
        return date==null;
    }
    /**判断整型变量是否为空*/
    /**
     * Is null boolean.
     *
     * @param value Integer
     * @return boolean boolean
     */
    public static boolean isNull(Integer value){
        return value==null||value.intValue()<0;
    }

    /**
     *
     * @param value Long
     * @return boolean
     */
    public static boolean isNull(Long value){
        return value==null||value.intValue()<0;
    }
    /**
     * Get time string string.
     *
     * @param dateformat String
     * @return String string
     */
    public static String getTimeString(String dateformat){
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        Date now = new Date();
        return format.format(now);
    }

    /**
     * Get date format cn str string.
     *
     * @param date    Date
     * @param pattern String
     * @return String string
     */
    public static String getDateFormatCnStr(Date date,String pattern){
        if(date==null){
            return "";
        }
        String result = null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
            result = sdf.format(date);
        }catch(Exception e){
            log.error("时间转换出错：Date"+date.toString()+",pattern"+pattern, e);
        }
        if(!isNull(result)){
            return result;
        }
        return "";
    }
    /**
     * 获得时间对象，输入时间为“2007-12-12”*/
    /**
     * Get cn date date.
     *
     * @param dateStr String
     * @param patt    String
     * @return Date date
     */
    public static Date getCnDate(String dateStr,String patt){
        if(isNull(dateStr)){
            return null;
        }
        String pattern = "yyyy-MM-dd";
        if(!isNull(patt)){
            pattern=patt;
        }
        Date result=null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
            result = sdf.parse(dateStr);
        }catch(Exception e){
            log.error("时间转换出错：Date:"+dateStr+",pattern:"+patt, e);
        }
        return result;
    }
    /** 获得时间对象，支持两种格式的输入时间*/
    /**
     * Get cn date new date.
     *
     * @param dateStr String
     * @return Date date
     */
    public static Date getCnDateNew(String dateStr){
        String pattern = "yyyy-MM-dd";
        if (!Utils.isNull(dateStr) && dateStr.indexOf('-') == -1) {
            pattern = "yyyyMMdd";
        }
        return getCnDate(dateStr, pattern);
    }
}
