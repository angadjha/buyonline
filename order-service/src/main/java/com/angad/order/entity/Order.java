package com.angad.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {

	@Id
	private Integer id;
	
	private String name;
	
	private Integer qty;
	
	private Double price;
	
	
	
	
	
	
}
