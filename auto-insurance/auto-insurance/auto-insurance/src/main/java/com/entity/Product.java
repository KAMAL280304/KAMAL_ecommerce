package com.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private String categoryId;
    private int stockQuantity;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
//    public Product(String productId, String name, String description, double price, String categoryId, int stockQuantity) {
//        this.productId = productId;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//       this.categoryId = categoryId;
//       this.stockQuantity = stockQuantity;
//    }

}