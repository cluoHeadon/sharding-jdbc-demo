package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {
    private Long orderId;
    private Integer userId;
    private String description;
    private Date createTime;
}
