package com.example.service.impl;

import com.example.common.util.IdGenerateUtil;
import com.example.dao.OrderItemMapper;
import com.example.dao.OrderMapper;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.OrderRequest;
import com.example.entity.OrderVo;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public List<Order> getOrder(OrderRequest orderRequest) {
        return orderMapper.getOrder(orderRequest);
    }

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public void addOrder(OrderVo ordervo) {
        Order order = ordervo.getOrder();
        List<OrderItem> orderItems = ordervo.getOrderItems();
        addSnowId(order, orderItems);

        orderMapper.addOrder(order);
        orderItemMapper.addOrderItems(orderItems);

    }

    /**
     * 给订单和订单项设置雪花id
     *
     * @author cluo
     * @date 2018/08/03
     * @param order
     * @param orderItems
     */
    private void addSnowId(Order order, List<OrderItem> orderItems) {
        Long snowId = IdGenerateUtil.getSnowId();
        order.setOrderId(snowId);
        for (OrderItem item : orderItems) {
            item.setOrderId(snowId);
        }
    }
}
