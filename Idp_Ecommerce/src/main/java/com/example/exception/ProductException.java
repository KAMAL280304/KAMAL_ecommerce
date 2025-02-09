package com.example.exception;

public class ProductException extends Exception {
    public static final String PRODUCT_NOT_ADDED="Adding Product has been failed";
    public static final String CATEGORY_NOT_FOUND="Invalid Category or Category is null";
    public static final String PRODUCT_NOT_FOUND ="Product Id already exists or Invalid Id";
    public static final String PRODUCT_GET_DATA = "Cannot retrieve Data";


    public ProductException(String message) {
        super(message);
    }
}
