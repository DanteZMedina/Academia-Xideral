package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private boolean inStock;

    private LocalDateTime createdAt;

    public Product() {}

    public Product(String name, String description, BigDecimal price,
                   String category, boolean inStock, LocalDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.createdAt = createdAt;
    }

    // getters y setters
}