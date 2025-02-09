package com.test;

import com.example.controller.ProductController;
import com.example.entity.Product;
import com.example.exception.ProductException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductControllerTest {

    @Mock
    private Product product;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() throws ProductException {
        when(product.getName()).thenReturn("Laptop");
        when(product.getCategoryId()).thenReturn("C001");
        String response=productController.addProduct("Laptop","C001");
        assertEquals("Product Added Successfully",response);
    }

    @Test
    public void testAddProduct_InvalidCategoryId() {
        when(product.getName()).thenReturn("Laptop");
        when(product.getCategoryId()).thenReturn("");
        ProductException ex=assertThrows(ProductException.class,()-> productController.addProduct("Laptop",""));
        assertEquals("Invalid Category or Category is null",ex.getMessage());
    }

    @Test
    public void testAddProduct_NullCategoryId() {
        when(product.getName()).thenReturn("Laptop");
        when(product.getCategoryId()).thenReturn(null);
        ProductException ex=assertThrows(ProductException.class,()-> productController.addProduct("Laptop",null));
        assertEquals("Invalid Category or Category is null",ex.getMessage());
    }

    @Test
    public void testAddProduct_invalidName() {
        when(product.getName()).thenReturn("");
        when(product.getCategoryId()).thenReturn("C001");
        ProductException ex=assertThrows(ProductException.class,()-> productController.addProduct("","C001"));
        assertEquals("Adding Product has been failed",ex.getMessage());
    }

    @Test
    public void testAddProduct_NullName() {
        when(product.getName()).thenReturn(null);
        when(product.getCategoryId()).thenReturn("C001");
        ProductException ex=assertThrows(ProductException.class,()-> productController.addProduct(null,"C001"));
        assertEquals("Adding Product has been failed",ex.getMessage());
    }


    @Test
    public void testUpdateProduct_ValidData() throws ProductException {
        when(product.getProductId()).thenReturn("P002");
        when(product.getName()).thenReturn("Laptop");
        when(product.getDescription()).thenReturn("A high-performance laptop");
        when(product.getPrice()).thenReturn(999.99);
        when(product.getCategoryId()).thenReturn("C001");
        when(product.getStockQuantity()).thenReturn(5);
        String response = productController.updateProduct("P002", product);
        assertEquals("User Profile Updated Successfully", response);
    }


    @Test
    public void testUpdateProduct_NullProductId() {
        when(product.getProductId()).thenReturn(null);
        ProductException ex = assertThrows(ProductException.class, () -> productController.updateProduct(null, product));
        assertEquals("Product Id already exists or Invalid Id",ex.getMessage());
    }

    @Test
    public void testUpdateProduct_MismatchedProductId() {
        when(product.getProductId()).thenReturn("P003");
        ProductException ex = assertThrows(ProductException.class, () -> productController.updateProduct("P002", product));
        assertEquals("Product Id already exists or Invalid Id",ex.getMessage());
    }


    @Test
    public void testGetProductDetails_ValidId() throws ProductException {
        when(product.getProductId()).thenReturn("AB01"); // Set up the mock (even though the controller doesn't use it directly in this case)
        String response = productController.getProductDetails("AB01"); // Still call with the real ID, as the method logic is defined.
        assertEquals("Product data retrieved successfully", response);
    }

    @Test
    public void testGetProductDetails_NullId() {
        when(product.getProductId()).thenReturn(null);
        ProductException ex = assertThrows(ProductException.class, () -> productController.getProductDetails(null));
        assertEquals("Cannot retrieve Data",ex.getMessage());
    }

    @Test
    public void testGetProductDetails_InvalidId()  {
        when(product.getProductId()).thenReturn("XXXX");
        ProductException ex = assertThrows(ProductException.class, () -> productController.getProductDetails("XXXX"));
        assertEquals("Product Id already exists or Invalid Id",ex.getMessage());
    }

    @Test
    public void testDeleteProduct_ValidId() throws ProductException {
        when(product.getProductId()).thenReturn("P003");
        String response = productController.deleteProduct("P003");
        assertEquals("Product deleted successfully", response);
    }

    @Test
    public void testDeleteProduct_InvalidId() {
        when(product.getProductId()).thenReturn("XXXX");
        ProductException ex = assertThrows(ProductException.class, () -> productController.deleteProduct("XXXX"));
        assertEquals("Product not found",ex.getMessage());
    }

    @Test
    public void testDeleteProduct_NullId() {
        when(product.getProductId()).thenReturn(null);
        ProductException ex = assertThrows(ProductException.class, () -> productController.deleteProduct(null));
        assertEquals("Product ID cannot be null or empty",ex.getMessage());
    }


    @Test
    public void testGetAllProductDetails() {
        Product returnedProduct = productController.getAllProductDetails();
        assertNotNull(returnedProduct);
    }
}
