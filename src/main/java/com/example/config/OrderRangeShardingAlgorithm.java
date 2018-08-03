package com.example.config;

import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;

/**
 * 范围分片算法
 *
 * @author cluo
 * @date 2018/08/03
 * @version
 * @copyright(c) gome inc Gome Co.,LTD
 */
public class OrderRangeShardingAlgorithm  implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        return null;
    }
}
