package com.atme.springcloud.service.impl;

import com.atme.springcloud.dao.PaymentDao;
import com.atme.springcloud.entities.CommonResult;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String timeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "三年之期已到。";
    }

    public Long create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }

    public String fallback() {
        return "你个废物。";
    }


}
