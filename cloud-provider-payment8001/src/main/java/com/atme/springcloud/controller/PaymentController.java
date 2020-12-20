package com.atme.springcloud.controller;

import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        Long primaryKey = paymentService.create(payment);
        if (primaryKey == 0) {
            return new CommonResult<Long>("Payment.FailToCreate", "创建支付记录失败");
        }
        return new CommonResult<Long>(primaryKey);
    }

    @GetMapping("/payment/getById")
    public CommonResult<Payment> getById(Long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null) {
            return new CommonResult<Payment>("Payment.NotExisted", "支付记录" + id + "不存在");
        }
        return new CommonResult<Payment>(payment);
    }
}
