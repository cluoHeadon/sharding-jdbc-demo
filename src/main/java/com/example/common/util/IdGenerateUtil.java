package com.example.common.util;

/**
 * userId生成器
 *
 * @author cluo
 * @date 2018/08/02
 * @version
 * @copyright(c) gome inc Gome Co.,LTD
 */
public class IdGenerateUtil {
    private static Integer id = 0;
    public static synchronized Integer getUserId() {
        id++;
        return id;
    }
}
