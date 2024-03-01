package com.example.demo.ordersystem.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name="order_items")
public class OrderItem {

    @Id
    private int orderItemId;

    @Column
    private int productId;

    @Column
    private int orderId;

    @Column
    private int orderQantity;

    public OrderItem(int productId,int orderQantity){
        this.productId = productId;
        this.orderQantity = orderQantity;
    }
}
