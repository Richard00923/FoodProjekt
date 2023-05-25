package com.example.demo.database;

import jakarta.persistence.*;

@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false)
    private long customer_id;
    private CustomerType customer_type;
    private long loyalty_card;

    public Customer() {
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public long getLoyalty_card() {
        return loyalty_card;
    }

    public void setLoyalty_card(int loyalty_card) {
        this.loyalty_card = loyalty_card;
    }

    public CustomerType getValue() {
        return customer_type;
    }

    public Customer(CustomerType customer_type) {
        this.customer_type = customer_type;
    }

    public void setValue(CustomerType value) {
        this.customer_type = value;
    }
}
