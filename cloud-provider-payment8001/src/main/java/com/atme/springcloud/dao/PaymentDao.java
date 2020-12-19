package com.atme.springcloud.dao;

import com.atme.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    Long create(Payment payment);

    Payment getById(@Param("id") Long id);

}
