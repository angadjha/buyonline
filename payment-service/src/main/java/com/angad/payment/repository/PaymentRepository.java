package com.angad.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angad.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByOrderId(Integer orderId);

}
