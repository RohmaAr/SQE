package com.jtspringproject.JtSpringProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.jtspringproject.JtSpringProject.services.userService;
import com.jtspringproject.JtSpringProject.models.User;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@AutoConfigureMockMvc
class NewUserRegisterTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private userService service;

        @Test
        public void testNewUserRegister() throws Exception {
            // Mocking the userService.isEmailUnique and userService.isUserUnique methods
            when(service.isEmailUnique(any())).thenReturn(true);
            when(service.isUserUnique(any())).thenReturn(true);

            // Creating a sample User object
            User user = new User();
            user.setEmail("test@gmail.com");
            user.setUsername("test");
            user.setAddress("ADDRESS");
            user.setPassword("password");
            // Performing the POST request to /newuserregister with the user data
            mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                            .flashAttr("user", user))
                    .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                    .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
            verify(service, times(1)).addUser(eq(user));
            // Verifying that the userService.addUser method is called with the correct user object

        }
    @Test
    public void testNewUserRegisterInvalidEmail() throws Exception {
        // Mocking the userService.isEmailUnique and userService.isUserUnique methods
        when(service.isEmailUnique(any())).thenReturn(false);
        when(service.isUserUnique(any())).thenReturn(true);

        // Creating a sample User object
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setUsername("test");
        user.setAddress("ADDRESS");
        user.setPassword("password");
        // Performing the POST request to /newuserregister with the user data
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .flashAttr("user", user))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register?q=notUniqueEmail"));
        verify(service, times(0)).addUser(eq(user));
        // Verifying that the userService.addUser method is called with the correct user object

    }
    @Test
    public void testNewUserRegisterInvalidUsername() throws Exception {
        // Mocking the userService.isEmailUnique and userService.isUserUnique methods
        when(service.isEmailUnique(any())).thenReturn(true);
        when(service.isUserUnique(any())).thenReturn(false);

        // Creating a sample User object
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setUsername("test");
        user.setAddress("ADDRESS");
        user.setPassword("password");
        // Performing the POST request to /newuserregister with the user data
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .flashAttr("user", user))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register?q=notUniqueUsername"));
        verify(service, times(0)).addUser(eq(user));
        // Verifying that the userService.addUser method is called with the correct user object

    }



}