package com.example.service;


import com.example.entity.Order;
import com.example.entity.OrderInfo;
import com.example.entity.OrderRequest;
import com.example.entity.OrderVo;

import java.util.List;

public interface OrderService {

    List<Order> getOrder(OrderRequest orderRequest);

    List<Order> getOrders();

    void addOrder(OrderVo orderVo);

    List<OrderInfo> getOrderInfo(OrderRequest orderRequest);
}
