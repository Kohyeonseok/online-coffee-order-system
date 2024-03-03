package com.example.demo.ordersystem.repository;

import com.example.demo.ordersystem.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct,Integer> {
    Optional<StoreProduct> findByStoreIdAndProductId(int store,int productId);
}
