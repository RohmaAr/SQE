package com.jtspringproject.JtSpringProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.jtspringproject.JtSpringProject.services.categoryService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;

@SpringBootTest
@AutoConfigureMockMvc
class addProductPostTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private categoryService categoryService;

    @MockBean
    private productService productService;

    @Test
    void testAddProductValidInLink() throws Exception {
        // Mocking necessary data
        Category category = new Category();
        category.setId(1);
        category.setName("TestCategory");

        when(categoryService.getCategory(1)).thenReturn(category);

        // Performing the POST request to /products/add with product data
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/add")
                        .param("name", "TestProduct")
                        .param("categoryid", "1")
                        .param("price", "100")
                        .param("weight", "200")
                        .param("quantity", "10")
                        .param("description", "Test description")
                        .param("productImage", "https://media.istockphoto.com/id/1460493721/photo/three-perfect-ripe-yellow-bananas-isolated-on-white-background.jpg?s=1024x1024&w=is&k=20&c=gHtp0dOO4-8c9ZhFZhJnVUHJolIqvRsXlcs6mAaHe8U="))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/products"));

        // Verifying that the productService.addProduct method is called
        verify(productService, times(1)).addProduct(any(Product.class));
    }
    @Test
    void testAddProductValidOnLink() throws Exception {
        // Mocking necessary data
        Category category = new Category();
        category.setId(1);
        category.setName("TestCategory");

        when(categoryService.getCategory(1)).thenReturn(category);

        // Performing the POST request to /admin/products/add with product data
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/add")
                        .param("name", "TestProduct")
                        .param("categoryid", "1")
                        .param("price", "100")
                        .param("weight", "200")
                        .param("quantity", "10")
                        .param("description", "Test description")
                        .param("productImage", "https://www.istockphoto.com/photo/dark-web-browser-close-up-on-lcd-screen-with-shallow-focus-on-https-padlock-gm1272564863-374793680?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fimages%2F"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/products"));

        // Verifying that the productService.addProduct method is called
        verify(productService, times(1)).addProduct(any(Product.class));
    }

    @Test
    void testAddProductInvalidOutLink() throws Exception {
        // Mocking necessary data
        Category category = new Category();
        category.setId(1);
        category.setName("TestCategory");

        when(categoryService.getCategory(1)).thenReturn(category);

        // Performing the POST request to /products/add with product data
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/add")
                        .param("name", "TestProduct")
                        .param("categoryid", "1")
                        .param("price", "100")
                        .param("weight", "200")
                        .param("quantity", "10")
                        .param("description", "Test description")
                        .param("productImage", "https://www.istockphoto.com/photo/dark-web-browser-close-up-on-lcd-screen-with-shallow-focus-on-https-padlock-gm1272564863-374793680?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fimages%2Fsearch%2Fwebsite%2F&utm_term=website"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/products/add?t=tooLong"));

        // Verifying that the productService.addProduct method is called
        verify(productService, times(0)).addProduct(any(Product.class));
    }

}