package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getById")
    public CommonResult<Payment> getById(Long id) {
        Map<String, Long> pathVar = new HashMap<String, Long>();
        pathVar.put("id", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getById?id={id}", CommonResult.class, pathVar);
    }


}
