package com.example.qixin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创  建   时  间： 2019/1/22 0:11
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
public class Order implements Serializable {

    private Long id;
    private String title;
    private String orderNo;
    private double amount;
    private int status;

}
