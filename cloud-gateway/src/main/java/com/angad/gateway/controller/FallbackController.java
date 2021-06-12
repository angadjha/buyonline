package com.angad.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/orderServiceFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("Order Service is down, please try after sometime");
	}
	
	@RequestMapping("/paymentServiceFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("Payment Service is down, please try after sometime");
	}
	
	@RequestMapping("/authServiceFallback")
	public Mono<String> authServiceFallback(){
		return Mono.just("Authentication Service is down, please try after sometime");
	}
}
