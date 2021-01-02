package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.PaymentFeignService;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/discovery")
    public CommonResult<Payment> getById() {
        return paymentFeignService.discovery();
    }


}
