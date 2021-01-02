package com.atme.springcloud.service;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class OrderHystrixServiceFallback implements OrderHystrixService {

    public CommonResult<Payment> discovery() {
        Payment payment = new Payment();
        return new CommonResult<Payment>("统一处理", payment);
    }

    public CommonResult<String> discoveryTimeout() {
        return new CommonResult<String>("统一处理", "我错了");
    }
}
