package com.example.demo.database;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "orders")
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


}
