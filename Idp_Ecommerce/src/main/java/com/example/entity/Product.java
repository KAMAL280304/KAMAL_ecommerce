package com.example.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private String categoryId;
    private int stockQuantity;
}
