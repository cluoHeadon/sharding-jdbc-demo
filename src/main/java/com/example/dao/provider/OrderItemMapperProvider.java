package com.example.dao.provider;

import com.example.entity.OrderItem;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


public class OrderItemMapperProvider {
    public String insertAll(Map map) {
        List<OrderItem> orderItems = (List<OrderItem>) map.get("orderItems");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into order_item ");
        sb.append("(order_id, order_item_id, user_id, description) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'orderItems[{0}].orderId}, #'{'orderItems[{0}].orderItemId}, #'{'orderItems[{0}].userId}, #'{'orderItems[{0}].description})");
        for (int i = 0; i < orderItems.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < orderItems.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
