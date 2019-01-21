package com.example.qixin.transactional;

import com.example.qixin.entity.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


/**
 * 创  建   时  间： 2019/1/22 0:13
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@Service
public class TestService {


    public void parent(){
        log.info("========parent()方法被调用===========");
        Order order = new Order();
    }


    public void child(){

    }

}
