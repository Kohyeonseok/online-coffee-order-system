package com.example.demo.ordersystem.domain;


import lombok.Getter;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name="order_items")
public class OrderItem {

    @Id
    @Column("order_item_id")
    private int orderItemId;

    @Column("product_id")
    private int productId;

    @Column(value="order_id")
    private int orderId;

    @Column("order_quantity")
    private int orderQuantity;

    public OrderItem(int productId,int orderQuantity){
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }
}
