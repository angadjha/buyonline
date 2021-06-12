package com.angad.payment.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angad.payment.entity.Payment;
import com.angad.payment.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {

	private Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) throws JsonProcessingException {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		LOGGER.info("Payment Service request: {}", new ObjectMapper().writeValueAsString(payment));
		return paymentRepository.save(payment);
		
	}
	
	
	public String paymentProcessing() {
		return new Random().nextBoolean() ? "success" : "false";
	}


	public Payment findByOrderId(Integer orderId) throws JsonProcessingException {
		Payment payment = paymentRepository.findByOrderId(orderId);
		LOGGER.info("Payment Service findByOrderId: {}", new ObjectMapper().writeValueAsString(payment));
		return payment;
	}
}
