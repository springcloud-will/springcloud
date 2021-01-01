package com.atme.springcloud.service.impl;

import com.atme.springcloud.dao.PaymentDao;
import com.atme.springcloud.entities.Payment;
import com.atme.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public Long create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
