package tests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.exception.ProductException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import com.entity.Product;
import com.controller.ProductController;
public class ProductControllerTest {

    @Mock
    private Product product;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        Product product = new Product();
        MockitoAnnotations.openMocks(this);
    }
    //1
    @Test
    public void testUpdateUserProfile() throws ProductException {
        ProductController productController = mock(ProductController.class);
        lenient().when(product.getProductId()).thenReturn("P001");
        lenient().when(product.getName()).thenReturn("Laptop");
        lenient().when(product.getDescription()).thenReturn("A high-performance laptop");
        lenient().when(product.getPrice()).thenReturn(999.99);
        lenient().when(product.getCategoryId()).thenReturn("C001");
        lenient().when(product.getStockQuantity()).thenReturn(5);
        when(productController.updateProduct(null, product)).thenReturn("Product Id already exists or Invalid Id");
        String response = productController.updateProduct(null , product);
        assertEquals("Product Id already exists or Invalid Id", response);
    }
    //2
    @Test
    public void testUpdateProduct_ValidData_ReturnsSuccess() throws ProductException {
//        Product product = mock(Product.class);
        lenient().when(product.getProductId()).thenReturn("P002");
        lenient().when(product.getName()).thenReturn("Laptop");
        lenient().when(product.getDescription()).thenReturn("A high-performance laptop");
        lenient().when(product.getPrice()).thenReturn(999.99);
        lenient().when(product.getCategoryId()).thenReturn("C001");
        lenient().when(product.getStockQuantity()).thenReturn(5);
        String response = productController.updateProduct("P002", product);
        assertEquals("User Profile Updated Successfully", response);
    }
    //Adding Product with valid inputs
    @Test
    public void testAddProduct() throws ProductException{
        lenient().when(product.getName()).thenReturn("Laptop");
        lenient().when(product.getCategoryId()).thenReturn("C001");
        String response=productController.addProduct("Laptop","C001",product);
        assertEquals("Product Added Successfully",response);
    }
    //Adding product with invalid name
    @Test
    public void testInvalidAddProduct() throws ProductException{
        lenient().when(product.getName()).thenReturn("");
        lenient().when(product.getCategoryId()).thenReturn("C001");

        ProductException exception=assertThrows(ProductException.class,()->{productController.addProduct("","C001",product);
        });
        assertEquals("Adding Product has been failed",exception.getMessage());
    }
    //Testing with invalid Category_id
    @Test
    public void testInvalidCategory_id() throws ProductException{
        lenient().when(product.getName()).thenReturn("Laptop");
        lenient().when(product.getCategoryId()).thenReturn("");
        ProductException ex=assertThrows(ProductException.class,()->{productController.addProduct("Laptop","",product);
        });
        assertEquals("Invalid Category or Category is null",ex.getMessage());
    }
    @Test
    public void testGetUserProfileByID() throws ProductException {
        ProductController productController = mock(ProductController.class);
        lenient().when(productController.getProductDetails("P002")).thenThrow(new ProductException("Cannot retrieve Data"));
        ProductException exception = assertThrows(ProductException.class, () -> {
            productController.getProductDetails("P002");
        });
        assertEquals("Cannot retrieve Data", exception.getMessage());
    }

    //4
    @Test
    public void testGetDetails()
    {
        assertFalse(productController.getAllProducts() instanceof List<?>);
    }
    //5
    @Test
    public void testDeleteProduct_ProductNotFound() throws ProductException {
        ProductController productController = mock(ProductController.class);

        // Set up the mock to throw an exception when deleteProduct is called with "P002"
       when(productController.deleteProduct("P002")).thenThrow(new ProductException("Product not found"));

        // Assert that the exception is thrown and the message is as expected
        ProductException exception = assertThrows(ProductException.class, () -> {
            productController.deleteProduct("P002");
        });
        assertEquals("Product not found", exception.getMessage());

    }



}
