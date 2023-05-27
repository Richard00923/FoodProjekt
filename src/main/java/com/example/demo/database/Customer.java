package com.example.demo.database;

import jakarta.persistence.*;

@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private long customerId;
    private CustomerType customerType;
    private long loyaltyCard;

    public Customer() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(int loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public CustomerType getValue() {
        return customerType;
    }

    public Customer(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setValue(CustomerType value) {
        this.customerType = value;
    }
}
