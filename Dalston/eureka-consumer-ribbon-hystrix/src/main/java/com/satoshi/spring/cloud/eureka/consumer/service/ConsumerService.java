package com.satoshi.spring.cloud.eureka.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String dc(){
        return restTemplate.getForObject("http://eureka-client/dc",String.class);
    }

    public String fallback(){
        return "fallback";
    }
}
