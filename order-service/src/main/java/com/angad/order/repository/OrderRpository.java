package com.angad.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angad.order.entity.Order;

public interface OrderRpository extends JpaRepository<Order, Integer> {

}
