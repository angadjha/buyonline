package com.angad.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.angad.order.common.Payment;
import com.angad.order.common.TransactionRequest;
import com.angad.order.common.TransactionResponse;
import com.angad.order.entity.Order;
import com.angad.order.repository.OrderRpository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RefreshScope
public class OrderService {

	private Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRpository orderRpository;
	
	@Value("${microservices.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_PAYMENTURI;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	public Order saveOrder(Order order) {
		return orderRpository.save(order);
		
	}

	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
		String message = " ";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		LOGGER.info("Order Service request: {}", new ObjectMapper().writeValueAsString(request));
		// call rest api PAYMENT-SERVICE
		//Payment paymentRes =  restTemplate.postForObject("http://localhost:9999/payment/doPayment", payment, Payment.class);
		Payment paymentRes =  restTemplate.postForObject(ENDPOINT_PAYMENTURI, payment, Payment.class);
		LOGGER.info("Payment Service Response from Order Service request Rest Call : {}", new ObjectMapper().writeValueAsString(paymentRes));

		message = paymentRes.getPaymentStatus().equals("success") ? "Payment Processing has been sucessfully done, Order has been placed" : "Payment Processing has not been done, Order added to cart";
		orderRpository.save(order);
		return new TransactionResponse(order,paymentRes.getAmount(),paymentRes.getTransactionId(),message);
	}
}
