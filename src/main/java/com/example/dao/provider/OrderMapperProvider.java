package com.example.dao.provider;


import com.example.common.util.DateUtil;
import com.example.entity.OrderRequest;
import org.apache.ibatis.jdbc.SQL;

public class OrderMapperProvider {
    private final String TBL_ORDER = "order";

    public String getOrder(OrderRequest orderRequest) {
        SQL sql = new SQL().SELECT("*").FROM(TBL_ORDER);
        Integer userId = orderRequest.getUserId();
        if (userId != null) {
            sql.WHERE("user_id = #{userId}");
        }
        Long start = null;
        Long end = null;
        String startTime = orderRequest.getStart();
        String endTime = orderRequest.getEnd();
        if (startTime != null && endTime != null) {
            start = DateUtil.dateToShardingJdbcKey(DateUtil.parseDate(startTime));
            end = DateUtil.dateToShardingJdbcKey(DateUtil.addDay(DateUtil.parseDate(endTime), 1));
        }
        if (start != null && end != null) {
            sql.WHERE("order_id between #{start} and #{end}");
        }
        return sql.toString();
    }
}
