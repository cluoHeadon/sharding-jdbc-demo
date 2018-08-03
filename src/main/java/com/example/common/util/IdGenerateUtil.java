package com.example.common.util;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;

/**
 * userId生成器
 *
 * @author cluo
 * @date 2018/08/02
 * @version
 * @copyright(c) gome inc Gome Co.,LTD
 */
public class IdGenerateUtil {
//    public static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 1);
    public static DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
    private static Integer id = 0;
    public static synchronized Integer getUserId() {
        id++;
        return id;
    }

    public static long getSnowId() {
        return keyGenerator.generateKey().longValue();
    }
}
