package com.example.config;

import com.example.common.Constants.TimeConstant;
import com.example.common.util.DateUtil;
import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 精确分片算法
 *
 * @author cluo
 * @date 2018/08/03
 * @version
 * @copyright(c) gome inc Gome Co.,LTD
 */
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long id = preciseShardingValue.getValue();
        // 获取时间（年月日）
        Long time = id >> 22;
        time += TimeConstant.START_UNIX_TIME;
        String timeString = DateUtil.unixToDateString(time, TimeConstant.DATE_FORMAT_YEAR_MONTH);

        for (String each : collection) {
            if (each.endsWith(timeString)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
