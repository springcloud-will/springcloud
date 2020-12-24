package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    private final static String InstanceName = "PAYMENT-SERVICE-8002";

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        Long primaryKey = paymentService.create(payment);
        if (primaryKey == 0) {
            return new CommonResult<Long>(InstanceName, "Payment.FailToCreate", "创建支付记录失败");
        }
        return new CommonResult<Long>(InstanceName, primaryKey);
    }

    @GetMapping("/payment/getById")
    public CommonResult<Payment> getById(Long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null) {
            return new CommonResult<Payment>(InstanceName, "Payment.NotExisted", "支付记录" + id + "不存在");
        }
        return new CommonResult<Payment>(InstanceName, payment);
    }
}
