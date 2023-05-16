package com.example.demo.database;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItems {
    @Id
    private long order_id;
    private int product_id;
    private int quantity;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public OrderItems(long order_id, int product_id, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
