package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private Long orderId;
    private Integer orderItemId;
    private Integer userId;
    private String description;
}
