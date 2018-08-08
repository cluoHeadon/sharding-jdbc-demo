package com.example.dao;


import com.example.dao.provider.OrderMapperProvider;
import com.example.entity.Order;
import com.example.entity.OrderRequest;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Results(id = "order", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "description", column = "description"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("select * from order order by order_id")
    List<Order> getOrders();

    @ResultMap(value = "order")
    @SelectProvider(type = OrderMapperProvider.class, method = "getOrder")
    List<Order> getOrder(OrderRequest orderRequest);

    @Insert("insert into order(order_id, user_id, description) " +
            "values(#{order.orderId}, #{order.userId}, #{order.description})")
    int addOrder(@Param("order") Order order);
}
