package com.angad.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment {

	@Id
	@GeneratedValue
	private Integer paymentId;
	
	private String paymentStatus;
	
	private String transactionId;
	
	private Integer orderId;
	
	private Double amount;
	
}
