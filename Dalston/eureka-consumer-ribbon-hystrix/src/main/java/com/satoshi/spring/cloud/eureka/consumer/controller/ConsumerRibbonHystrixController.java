package com.satoshi.spring.cloud.eureka.consumer.controller;

import com.satoshi.spring.cloud.eureka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRibbonHystrixController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc(){
        return consumerService.dc();
    }


}
