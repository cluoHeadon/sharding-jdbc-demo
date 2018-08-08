package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Integer userId;
    private String start;
    private String end;
}
