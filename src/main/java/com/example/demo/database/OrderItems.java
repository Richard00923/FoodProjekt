package com.example.demo.database;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_items_id")
    private long orderItemsId;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;
    private int productId;
    private int quantity;

    public OrderItems() {
    }

    public long getOrderId() {
        return orderItemsId;
    }

    public void setOrderId(long orderId) {
        this.orderItemsId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public OrderItems(long orderId, int productId, int quantity) {
        this.orderItemsId = orderId;
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
