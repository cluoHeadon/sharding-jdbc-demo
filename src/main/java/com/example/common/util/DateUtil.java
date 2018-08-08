package com.example.common.util;

import com.example.common.Constants.TimeConstant;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    /**
     * unix时间戳毫秒 转换为 字符串格式的时间
     *
     * @author cluo
     * @date 2018/08/03
     * @param millisecond 毫秒
     * @param pattern 要格式化的时间格式，比如年月（201805）：yyyyMM
     * @return 格式为：年月日的时间
     */
    public static String unixToDateString(long millisecond, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            return "";
        }

        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        return format.format(date);
    }

    /**
     * shardingkey转换为Date
     *
     * @date 2018/5/18
     * @param
     * @return
     */
    public static Date shardingKeyToDate(Long key) {
        Long unixTime = key >> 22;
        unixTime += TimeConstant.START_UNIX_TIME;
        String timeString = unixToDateString(unixTime, TimeConstant.DATE_FORMAT_YEAR_MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat(TimeConstant.DATE_FORMAT_YEAR_MONTH);
        Date result;
        try {
            result = sdf.parse(timeString);
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * 字符串转Date
     *
     * @date 2018/5/17
     * @param str 字符串的日期，如：2018-06-30
     * @return Date类型的日期
     */
    public static Date parseDate(String str) {
        Date result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            result = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * Date增减天数
     *
     * @date 2018/5/25
     */
    public static Date addDay(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, num);
        Date result = calendar.getTime();
        return result;
    }

    /**
     * Date增减月数
     *
     * @date 2018/5/18
     */
    public static Date addMonth(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, num);
        Date result = calendar.getTime();
        return result;
    }

    /**
     * 字符串格式的时间 转换为 sharding-jdbc默认的key格式
     *
     * @date 2018/5/17
     * @param time 时间
     * @return 相应的毫秒数
     */
    public static long dateToShardingJdbcKey(Date time) {
        long millisecond = dateToUnix(time);
        // 减去2016年1月1日0点0分0秒
        millisecond -= TimeConstant.START_UNIX_TIME;
        millisecond = millisecond << 22;

        return millisecond;
    }

    /**
     * Date格式的时间 转换为 unix时间戳毫秒
     *
     * @date 2018/5/17
     * @param time 时间
     * @return 相应的毫秒数
     */
    public static long dateToUnix(Date time) {
        return time.getTime();
    }
}
