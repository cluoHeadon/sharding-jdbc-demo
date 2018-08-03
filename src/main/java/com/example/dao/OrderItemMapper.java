package com.example.dao;

import com.example.entity.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "orderItemId", column = "order_item_id"),
            @Result(property = "description", column = "description")
    })
    @Select("select * from order_item order by order_id")
    List<OrderItem> getOrderItems();

    @InsertProvider(type = OrderItemMapperProvider.class, method = "insertAll")
    int addOrderItems(@Param("orderItems") List<OrderItem> orderItems);
}
