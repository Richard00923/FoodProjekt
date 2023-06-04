package com.example.demo.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;

    private long customerId;

    private int totalAmount;

    private Date dateTime;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

    public Receipt() {
    }

    public Receipt(long customerId, List<OrderItems> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        calculateTotalAmount();

    }

    private void calculateTotalAmount() {
        int total = 0;
        for (OrderItems orderItem : orderItems) {
            total += orderItem.getQuantity();
        }
        this.totalAmount = total;
        this.dateTime = new Date();
    }
}