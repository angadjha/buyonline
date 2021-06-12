package com.angad.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angad.order.common.TransactionRequest;
import com.angad.order.common.TransactionResponse;
import com.angad.order.entity.Order;
import com.angad.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrderTest")
	public Order bookOrderTest(@RequestBody Order order) {
		return orderService.saveOrder(order);
		
	}
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
		return orderService.saveOrder(request);
		
	}
}
