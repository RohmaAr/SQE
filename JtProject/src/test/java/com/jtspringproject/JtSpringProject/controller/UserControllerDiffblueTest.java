package com.jtspringproject.JtSpringProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.cartService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerDiffblueTest {
    @MockBean
    private cartService cartService;

    @MockBean
    private productService productService;

    @Autowired
    private UserController userController;

    @MockBean
    private userService userService;

    /**
     * Method under test: {@link UserController#registerUser()}
     */
    @Test
    void testRegisterUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [register]: would dispatch back to the current handler URL [/register] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        assertEquals("register", (new UserController()).registerUser());
    }

    /**
     * Method under test: {@link UserController#buy()}
     */
    @Test
    void testBuy() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [buy]: would dispatch back to the current handler URL [/buy] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        assertEquals("buy", (new UserController()).buy());
    }

    /**
     * Method under test:  {@link UserController#deleteCustomer(int, Model)}
     */
    @Test
    void testDeleteCustomer() throws Exception {
        when(userService.deleteUser(anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/deleteCustomer");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/displayCustomers"))
                .andExpect(MockMvcResultMatchers
                        .redirectedUrl("/displayCustomers?message=Customer+deleted+successfully+reload+it+to+to+reflect+changes"));
    }

    /**
     * Method under test:  {@link UserController#deleteCustomer(int, Model)}
     */
    @Test
    void testDeleteCustomer2() throws Exception {
        when(userService.deleteUser(anyInt())).thenReturn(false);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/deleteCustomer");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/displayCustomers"))
                .andExpect(MockMvcResultMatchers.redirectedUrl(
                        "/displayCustomers?message=Customer+not+found+or+deletion+failed%2C+reload+it+to+reflect+changes"));
    }

    /**
     * Method under test:  {@link UserController#getCartDetail()}
     */
    @Test
    void testGetCartDetail() throws Exception {
        when(cartService.getCarts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/carts");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("carts"))
                .andExpect(MockMvcResultMatchers.view().name("cartproduct"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("cartproduct"));
    }

    /**
     * Method under test:  {@link UserController#getCartDetail()}
     */
    @Test
    void testGetCartDetail2() throws Exception {
        when(cartService.getCarts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/carts");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("carts"))
                .andExpect(MockMvcResultMatchers.view().name("cartproduct"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("cartproduct"));
    }

    /**
     * Method under test:  {@link UserController#getproduct()}
     */
    @Test
    void testGetproduct() throws Exception {
        when(productService.getProducts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/products");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("msg"))
                .andExpect(MockMvcResultMatchers.view().name("uproduct"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("uproduct"));
    }

    /**
     * Method under test: {@link UserController#getproduct()}
     */
    @Test
    void testGetproduct2() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("?");

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(1);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImage("?");
        product.setName("?");
        product.setPrice(1);
        product.setProductImage("?");
        product.setQuantity(1);
        product.setWeight(3);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productService.getProducts()).thenReturn(productList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/products");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"))
                .andExpect(MockMvcResultMatchers.view().name("uproduct"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("uproduct"));
    }

    /**
     * Method under test: {@link UserController#newUseRegister(User)}
     */
    @Test
    void testNewUseRegister() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        when(userService.addUser(Mockito.<User>any())).thenReturn(user);
        when(userService.isUserUnique(Mockito.<User>any())).thenReturn(true);
        when(userService.isEmailUnique(Mockito.<User>any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/newuserregister");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    /**
     * Method under test: {@link UserController#newUseRegister(User)}
     */
    @Test
    void testNewUseRegister2() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        when(userService.addUser(Mockito.<User>any())).thenReturn(user);
        when(userService.isUserUnique(Mockito.<User>any())).thenReturn(false);
        when(userService.isEmailUnique(Mockito.<User>any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/newuserregister");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/register?q=notUniqueUsername"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register?q=notUniqueUsername"));
    }

    /**
     * Method under test: {@link UserController#newUseRegister(User)}
     */
    @Test
    void testNewUseRegister3() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        when(userService.addUser(Mockito.<User>any())).thenReturn(user);
        when(userService.isUserUnique(Mockito.<User>any())).thenReturn(true);
        when(userService.isEmailUnique(Mockito.<User>any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/newuserregister");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/register?q=notUniqueEmail"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register?q=notUniqueEmail"));
    }

    /**
     * Method under test: {@link UserController#Test(Model)}
     */
    @Test
    void testTest() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [test]: would dispatch back to the current handler URL [/test] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        UserController userController = new UserController();
        ConcurrentModel model = new ConcurrentModel();
        String actualTestResult = userController.Test(model);
        Object getResult = model.get("f");
        assertEquals("abc", ((List<String>) getResult).get(1));
        assertEquals("test", actualTestResult);
        assertEquals("xyz", ((List<String>) getResult).get(0));
        assertEquals(2, ((Collection<String>) getResult).size());
    }

    /**
     * Method under test: {@link UserController#Test2()}
     */
    @Test
    void testTest2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [test2]: would dispatch back to the current handler URL [/test2] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        ModelAndView actualTest2Result = (new UserController()).Test2();
        Map<String, Object> model = actualTest2Result.getModel();
        Object getResult = model.get("marks");
        assertEquals(10, ((List<Integer>) getResult).get(0));
        assertEquals(2, ((Collection<Integer>) getResult).size());
        assertEquals(25, ((List<Integer>) getResult).get(1));
        assertTrue(actualTest2Result.isReference());
        assertSame(model, actualTest2Result.getModelMap());
    }

    /**
     * Method under test:
     * {@link UserController#userlogin(String, String, Model, HttpServletResponse)}
     */
    @Test
    void testUserlogin() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        when(userService.checkLogin(Mockito.<String>any(), Mockito.<String>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/userloginvalidate")
                .param("password", "foo")
                .param("username", "foo");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("msg"))
                .andExpect(MockMvcResultMatchers.view().name("userLogin"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("userLogin"));
    }

    /**
     * Method under test:  {@link UserController#userlogin(String, String, Model, HttpServletResponse)}
     */
    @Test
    void testUserlogin2() throws Exception {
        when(productService.getProducts()).thenReturn(new ArrayList<>());

        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("foo");
        when(userService.checkLogin(Mockito.<String>any(), Mockito.<String>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/userloginvalidate")
                .param("password", "foo")
                .param("username", "foo");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("msg", "user"))
                .andExpect(MockMvcResultMatchers.view().name("index"));
        ResultActions resultActions2 = resultActions.andExpect(MockMvcResultMatchers.cookie().value("username", "foo"));
        ResultActions resultActions3 = resultActions2.andExpect(MockMvcResultMatchers.cookie().secure("username", false));
        ResultActions resultActions4 = resultActions3.andExpect(MockMvcResultMatchers.cookie().httpOnly("username", false));
        resultActions4.andExpect(MockMvcResultMatchers.cookie().maxAge("username", -1))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    /**
     * Method under test:
     * {@link UserController#userlogin(String, String, Model, HttpServletResponse)}
     */
    @Test
    void testUserlogin3() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("?");

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(1);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImage("?");
        product.setName("?");
        product.setPrice(2);
        product.setProductImage("?");
        product.setQuantity(2);
        product.setWeight(3);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productService.getProducts()).thenReturn(productList);

        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("foo");
        when(userService.checkLogin(Mockito.<String>any(), Mockito.<String>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/userloginvalidate")
                .param("password", "foo")
                .param("username", "foo");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products", "user"))
                .andExpect(MockMvcResultMatchers.view().name("index"));
        ResultActions resultActions2 = resultActions.andExpect(MockMvcResultMatchers.cookie().value("username", "foo"));
        ResultActions resultActions3 = resultActions2.andExpect(MockMvcResultMatchers.cookie().secure("username", false));
        ResultActions resultActions4 = resultActions3.andExpect(MockMvcResultMatchers.cookie().httpOnly("username", false));
        resultActions4.andExpect(MockMvcResultMatchers.cookie().maxAge("username", -1))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    /**
     * Method under test: {@link UserController#userlogin(Model)}
     */
    @Test
    void testUserlogin4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("userLogin"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("userLogin"));
    }

    /**
     * Method under test: {@link UserController#userlogin(Model)}
     */
    @Test
    void testUserlogin5() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("userLogin"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("userLogin"));
    }
}
