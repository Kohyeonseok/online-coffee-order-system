package com.example.demo.ordersystem.service;

import com.example.demo.ordersystem.domain.CreateOrder;
import com.example.demo.ordersystem.domain.Order;
import com.example.demo.ordersystem.domain.StoreProduct;
import com.example.demo.ordersystem.repository.OrderRepository;
import com.example.demo.ordersystem.repository.StoreProductRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository,StoreService storeService){
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder createOrder){
        List<StoreProduct> storeProducts = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : createOrder.getQuantityByProduct().entrySet()){
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    createOrder.getStoreId(),
                    productId);

            int stockQuantity = storeProduct.getStockQuantity();

            if(buyQuantity > stockQuantity){
                throw new RuntimeException("재고가 없습니다.");
            }

            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
        storeService.saveAll(storeProducts);
    }
}
