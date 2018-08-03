package com.example.service;


import com.example.entity.Order;
import com.example.entity.OrderVo;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    void addOrder(OrderVo orderVo);
}
