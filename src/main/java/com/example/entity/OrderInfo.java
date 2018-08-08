package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderInfo {
    private Long orderId;
    private Integer userId;
    private Integer orderItemId;
    private String orderDescription;
    private String orderItemDescription;
    private Date createTime;
}
