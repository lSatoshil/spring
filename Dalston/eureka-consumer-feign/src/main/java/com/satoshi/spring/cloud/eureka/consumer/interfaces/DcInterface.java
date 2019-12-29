package com.satoshi.spring.cloud.eureka.consumer.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface DcInterface {

    @GetMapping("/dc")
    String consumer();
}
