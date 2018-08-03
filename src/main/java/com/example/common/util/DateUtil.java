package com.example.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
