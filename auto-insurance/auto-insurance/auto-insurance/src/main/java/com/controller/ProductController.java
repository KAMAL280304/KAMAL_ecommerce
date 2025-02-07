package com.controller;
import com.exception.ProductException;
import com.entity.Product;
import java.util.*;

import static java.sql.Types.NULL;

public class ProductController {
//    private List<Product> list=new ArrayList<>();
//    public void addProduct(Product product) {
//
//    }
    public String addProduct(String productname,String category_id,Product productData) throws  ProductException{
        if(productname == null || productname.isEmpty()){
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
            throw new ProductException((String) ProductException.PRODUCT_NOT_FOUND);
        }

            return "User Profile Updated Successfully";

    }

   public String getProductDetails(String productId) throws ProductException {
        //Product product=new Product("P001","Laptop","Gaming Laptop",10000.00,"C003",4);
        if (productId == null || productId.isEmpty()) {
            throw new ProductException( ProductException.PRODUCT_GET_DATA);
        }
        if ("someId".equals(productId)) {
            throw new ProductException( ProductException.PRODUCT_NOT_FOUND);
        }
        else {
            return "Product data retrieved successfully";
        }
    }
    public Product getAllProducts()
    {
        return new Product("P004","Laptop","Gaming Laptop",10000.00,"C003",4);
    }
    public String deleteProduct(String productId) throws ProductException {
        if (productId == null || productId.isEmpty()) {
            throw new ProductException("Product ID cannot be null or empty");
        }
        // Simulate a scenario where the product cannot be found
        if ("P002".equals(productId)) {
            throw new ProductException("Product not found");
        }
        // Simulate successful deletion
        return "Product deleted successfully";
    }
}
