package com.example.controller;
import com.example.entity.Product;
import com.example.exception.ProductException;

public class ProductController {
    public String addProduct(String productName, String category_id) throws ProductException{
        if(productName == null || productName.isEmpty()){
            throw new ProductException(ProductException.PRODUCT_NOT_ADDED);
        }

        if(category_id==null || category_id.isEmpty()){
            throw new ProductException(ProductException.CATEGORY_NOT_FOUND);
        }
        return "Product Added Successfully";

    }
    public String updateProduct(String productId, Product productData) throws ProductException {
        if (productId == null || productId.isEmpty())   {
            throw new ProductException( ProductException.PRODUCT_NOT_FOUND);
        }
        if(!productId.equals(productData.getProductId()))
        {
            throw new ProductException(ProductException.PRODUCT_NOT_FOUND);
        }

        return "User Profile Updated Successfully";

    }

    public String getProductDetails(String productId) throws ProductException {
        if (productId == null || productId.isEmpty()) {
            throw new ProductException( ProductException.PRODUCT_GET_DATA);
        }
        if ("XXXX".equals(productId)) {
            throw new ProductException( ProductException.PRODUCT_NOT_FOUND);
        }
        else {
            return "Product data retrieved successfully";
        }
    }
    public Product getAllProductDetails()
    {

        return new Product("P004","Laptop","Gaming Laptop",10000.00,"C003",4);
    }
    public String deleteProduct(String productId) throws ProductException {
        if (productId == null || productId.isEmpty()) {
            throw new ProductException("Product ID cannot be null or empty");
        }

        if ("XXXX".equals(productId)) {
            throw new ProductException("Product not found");
        }

        return "Product deleted successfully";
    }
}
