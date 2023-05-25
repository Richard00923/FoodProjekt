package com.example.demo.database;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long order_id;

    private long customer_id;

    private int total_amount;

    private String date_time;

    public Order(long order_id, long customer_id, int total_amount) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.total_amount = total_amount;
        LocalDateTime now = LocalDateTime.now();
        this.date_time= now.toString();
    }

    public Order() {

    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
}
