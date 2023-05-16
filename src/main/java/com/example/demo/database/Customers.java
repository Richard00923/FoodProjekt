package com.example.demo.database;

import jakarta.persistence.*;

@Entity

public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private long customer_id;
    private CustomerType customer_type;
    private long loyalty_card;

    public Customers() {
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

    public Customers(CustomerType customer_type, long loyalty_card) {
        this.customer_type = customer_type;
        if (customer_type.equals(CustomerType.Guest)) {
            this.loyalty_card = Long.parseLong(null);
        } else {
            this.loyalty_card = loyalty_card;

        }

    }

    public void setValue(CustomerType value) {
        this.customer_type = value;
    }
}
