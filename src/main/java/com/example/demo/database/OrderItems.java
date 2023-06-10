package com.example.demo.database;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_items_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;
    private int productId;
    private int quantity;

    public OrderItems() {
    }

    public long getOrderId() {
        return id;
    }

    public void setOrderId(long orderId) {
        this.id = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public OrderItems(long orderId, int productId, int quantity) {
        this.id = orderId;
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
