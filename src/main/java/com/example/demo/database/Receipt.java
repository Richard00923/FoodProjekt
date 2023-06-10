package com.example.demo.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customerId;

    private int totalAmount;

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

    public Receipt() {
    }

    public Receipt(long customerId, List<OrderItems> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
    }
}
