package com.atme.springcloud.service;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/discovery")
    CommonResult<Payment> discovery();

}
