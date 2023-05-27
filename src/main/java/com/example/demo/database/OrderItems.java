package com.example.demo.database;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItems {
    @Id
    private long orderId;
    private int productId;
    private int quantity;

    public OrderItems() {

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public OrderItems(long orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
