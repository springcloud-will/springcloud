package com.atme.springcloud.service;

import com.atme.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Long create(Payment payment);

    Payment getById(@Param("id") Long id);

}
