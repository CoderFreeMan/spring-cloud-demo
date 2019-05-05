package com.xwd.spring.cloud.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    //23位时间格式 yyyy-MM-dd HH:mm:ss,SSS
    public static final String DATETIME_23 = "yyyy-MM-dd HH:mm:ss,SSS";

    //19位时间格式 yyyyMMddHHmmss
    public static final String DATETIME_19 = "yyyy-MM-dd HH:mm:ss";

    //19位时间格式 yyyyMMddHHmmss
    public static final String DATETIME_16 = "yyyy-MM-dd HH:mm";

    //获得当前时间的年月日字符串
    public static final String DATE_8 = "yyyyMMdd";

    //获得当前时间的年月日字符串
    public static final String DATE_6 = "yyMMdd";

    //14位时间格式 yyyyMMddHHmmss
    public static final String DATETIME_14 = "yyyyMMddHHmmss";

    //17位精确到毫秒的时间格式：yyyyMMddHHmmssSSS
    public static final String DATETIME_17 = "yyyyMMddHHmmssSSS";

    public static final String DATE_YYYYMM = "yyyyMM";

    public static final int MILLISSECONDS_PER_DAY = 86400000;

    public static final int THOUSAND = 1000;

    /**
     * 转换字符串为Date
     *
     * @param dateStr 要转换的时间字符串
     * @param format  时间格式
     * @return Date 时间类型结果
     */
    public static Date formatStringToDate(String dateStr, String format) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        if (null == format || "".equals(format)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
            if (!dateStr.equals(df.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            logger.error("formatStringToDate error: ", e);
        }
        return date;
    }

    /**
     * 排除时区偏差
     *
     * @param date 日期
     * @return 格林尼治时间到当前的秒数
     */
    public static long calcExpiredTime(final Date date) {
        Date dateRes = date;
        if (date == null) {
            dateRes = new Date();
        }
        return (dateRes.getTime() + TimeZone.getDefault().getRawOffset()) / THOUSAND;
    }

    /**
     * 将过期时间long值转换为默认的日期格式
     *
     * @param timeStr 过期时间long值的字符串
     * @return 过期时间format
     */
    public static String calcExpiredTimeToFormat(String timeStr) {
        long time = Long.parseLong(timeStr) * THOUSAND - TimeZone.getDefault().getRawOffset();
        Date date = new Date(time);
        return formatDateToString(date, DATETIME_19);
    }

    /**
     * 将日期转换未指定类型的字符串
     *
     * @param date   要转换的date
     * @param format 格式
     * @return 转换完成的字符串
     */
    public static String formatDateToString(Date date, String format) {
        if (null == date) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 返回当前时间戳
     *
     * @param format 默认为：yyyyMMddHHmmss
     * @return string 时间字符串
     * @author huanghui
     * @see [类、类#方法、类#成员]
     */
    public static String getCurrentTimestamp(final String format) {
        String defaultFormat = format;
        if (null == defaultFormat || "".equals(defaultFormat)) {
            defaultFormat = DATETIME_14;
        }
        return formatDateToString(new Date(), defaultFormat);
    }

    /**
     * 计算密码过期时间，有效时间为6个月
     *
     * @param
     * @return 返回当前时间+6个月的时间
     */
    public static Date createExpireTime() {
        final int sixMonth = 6;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, sixMonth);
        return calendar.getTime();
    }

    /**
     * 计算密码过期时间
     *
     * @param overtime 有效时间值
     * @return 过期时间
     */
    public static Date createExpireTime(int overtime) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, overtime);
        return calendar.getTime();
    }

    /**
     * 日期字符串装换成秒数
     *
     * @param dateString 日期字符串，要求格式yyyy-MM-dd HH:mm:ss
     * @return 1970-1-1 00:00:00至指定日期的秒数
     */
    public static long dateString2Second(String dateString) {
        long minute = 0L;
        try {
            Date date = new SimpleDateFormat(DATETIME_19).parse(dateString);
            minute = date.getTime() / THOUSAND;
        } catch (ParseException e) {
            logger.error("dateString2Second is error: ", e);
        }
        return minute;
    }

    /**
     * 获得当前时间的年月日字符串
     *
     * @return
     */
    public static String getCurDateForString() {
        return formatDateToString(new Date(), DATE_8);
    }

    /**
     * 获取昨天的日期
     *
     * @return
     */
    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取本月已过日期数
     *
     * @return
     */
    public static int getPastDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取本月剩余日期数
     *
     * @return
     */
    public static int getResidualDaysOfMonth(Date date) {
        return getDaysOfMonth(date) - getPastDaysOfMonth(date);
    }

    /**
     * 获取本月总天数
     *
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取上月今天的日期
     *
     * @return
     */
    public static Date getTodayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 获取上周一的日期
     *
     * @return
     */
    public static Date getMonDayOfLastWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取上周为年内第几周
     *
     * @return
     */
    public static int getLastWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取到昨天时间
     * 时间格式“YYYY-MM-DD 00:00:00”
     *
     * @see [类、类#方法、类#成员]
     */
    public static String getYestdayTimeString() {
        return formatDateToString(getYesterday(), DATE_FORMAT_YYYY_MM_DD) + " 00:00:00";
    }

    /**
     * 获取到今日23:59:59时间
     * 时间格式“YYYY-MM-DD 23:59:59”
     *
     * @see [类、类#方法、类#成员]
     */
    public static String getTodayTimeString() {
        return formatDateToString(new Date(), DATE_FORMAT_YYYY_MM_DD) + " 23:59:59";
    }

    /**
     * 返回今天剩余的秒数
     *
     * @return
     */
    public static int getRemainSecondsOfToday() {
        Date date = new Date();
        String dateString = formatDateToString(date, DATE_FORMAT_YYYY_MM_DD) + " 23:59:59,999";
        long spareTime = (formatStringToDate(dateString, DATETIME_23).getTime() - date.getTime()) / THOUSAND;
        return (int) spareTime;
    }

    /**
     * 获取UTC时间
     *
     * @param
     * @return UTC时间串"yyyy-MM-dd hh:mm:ss"
     * @author liutao
     */
    public static String getUTCTime() {
        //1、获取本地时间
        Calendar calendar = Calendar.getInstance();
        //2、获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //3、获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //4、从本地时间扣除差异既可以得到UTC时间
        calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        //5、格式化时间格式
        SimpleDateFormat foo = new SimpleDateFormat(DATETIME_19);

        return foo.format(new Date(calendar.getTimeInMillis()));

    }

    /**
     * 根据UTC时间获取对应的本地时间
     *
     * @param uTcTimeString 时间串"yyyy-MM-dd hh:mm:ss"
     * @return Date
     * @author liutao
     */
    public static Date getCurTimeByUTCTime(String uTcTimeString) {
        //1、获取本地时间
        Date date = formatStringToDate(uTcTimeString, DATETIME_19);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //2、获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //3、获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //4、从UTC时间扣除差异既可以得到本地时间
        calendar.add(Calendar.MILLISECOND, zoneOffset + dstOffset);

        return new Date(calendar.getTimeInMillis());

    }
}
