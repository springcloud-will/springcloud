package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/discovery")
    public CommonResult<Payment> discovery() {
        return orderHystrixService.discovery();
    }

    @GetMapping("/consumer/payment/discoveryTimeout")
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    })
    public CommonResult<String> discoveryTimeout() {
        return orderHystrixService.discoveryTimeout();
    }

    public CommonResult<String> fallback() {
        return new CommonResult<String>("客户端错误", "我是谁？我在哪？");
    }

}
