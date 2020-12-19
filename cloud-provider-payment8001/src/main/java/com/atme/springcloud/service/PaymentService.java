package com.atme.springcloud.service;

import com.atme.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    Long create(Payment payment);

    Payment getById(@Param("id") Long id);

}
