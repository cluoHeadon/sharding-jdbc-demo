package com.example.dao;

import com.example.entity.OrderItem;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class UserMapperProvider {
    public String insertAll(Map map) {
        List<OrderItem> orderItems = (List<OrderItem>) map.get("users");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into user ");
        sb.append("(user_id, name, age, address) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'users[{0}].userId}, #'{'users[{0}].name}, #'{'users[{0}].age}, #'{'users[{0}].address})");
        for (int i = 0; i < orderItems.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < orderItems.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
