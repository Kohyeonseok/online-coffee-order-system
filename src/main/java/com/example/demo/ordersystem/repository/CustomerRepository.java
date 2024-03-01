package com.example.demo.ordersystem.repository;

import com.example.demo.ordersystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
