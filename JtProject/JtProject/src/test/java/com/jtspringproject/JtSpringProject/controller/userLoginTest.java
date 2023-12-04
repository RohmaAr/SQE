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
import com.jtspringproject.JtSpringProject.services.userService;
import com.jtspringproject.JtSpringProject.models.User;
@SpringBootTest
@AutoConfigureMockMvc
class userLoginTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private userService userService;

    @Test
    public void testUserLogin() throws Exception {
        // Mocking the userService.checkLogin method
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setUsername("test");
        user.setAddress("ADDRESS");
        user.setPassword("password");
        when(userService.checkLogin(anyString(), anyString())).thenReturn(user);
        when(userService.getAdminMail()).thenReturn("admin@example.com");
        // Performing the POST request to /userloginvalidate with user data
        mockMvc.perform(MockMvcRequestBuilders.post("/userloginvalidate")
                        .param("username", user.getUsername())
                        .param("password", user.getPassword())
                        .param("email",user.getAddress())
                        .param("address",user.getAddress()))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("user", "products", "adminMail"))
                .andExpect(cookie().exists("username"));

        // Verifying that the userService.checkLogin method is called
        verify(userService, times(1)).checkLogin(eq("test"), eq("password"));
    }
}
