package com.example.demo.database;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long orderId;

    private long customerId;

    private int totalAmount;

    private String dateTime;

    public Order(long orderId, long customerId, int totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = now.toString();
    }

    public Order() {

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
