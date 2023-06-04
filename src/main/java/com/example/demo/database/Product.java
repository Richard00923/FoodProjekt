package com.example.demo.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private double price;


    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


}