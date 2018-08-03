package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderVo {
    private Order order;
    private List<OrderItem> orderItems;
}
