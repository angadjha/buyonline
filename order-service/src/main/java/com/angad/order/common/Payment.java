package com.angad.order.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment {

	
    private String paymentStatus;
	
	private String transactionId;
	
	private Integer orderId;
	
	private Double amount;
}
