package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Integer userId;
    private String startTime;
    private String endTime;
    private Long start;
    private Long end;
}
