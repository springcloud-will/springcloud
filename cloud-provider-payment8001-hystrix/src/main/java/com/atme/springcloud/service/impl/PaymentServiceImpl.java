package com.atme.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atme.springcloud.dao.PaymentDao;
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
        return "服务降级，你个废物。";
    }

    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率到多少
    })
    public String paymentCircuitBreaker(Long id) {

        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id 不能为负数，请稍后再试";
    }

}
