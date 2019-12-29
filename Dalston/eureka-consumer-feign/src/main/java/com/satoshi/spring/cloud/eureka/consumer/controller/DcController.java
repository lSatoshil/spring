package com.satoshi.spring.cloud.eureka.consumer.controller;

import com.satoshi.spring.cloud.eureka.consumer.interfaces.DcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DcInterface dcInterface;

    @GetMapping("/consumer")
    public String dc(){
        return dcInterface.consumer();
    }

}
