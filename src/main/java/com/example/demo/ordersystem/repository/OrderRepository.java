package com.example.demo.ordersystem.repository;

import com.example.demo.ordersystem.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
