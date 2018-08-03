package com.example.service.impl;

import com.example.common.util.IdGenerateUtil;
import com.example.dao.OrderMapper;
import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public int addOrder(Order order) {
        order.setOrderId(IdGenerateUtil.getSnowId());
        return orderMapper.addOrder(order);
    }
}
