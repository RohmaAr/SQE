package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.Cart;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {cartDao.class})
@ExtendWith(SpringExtension.class)
class cartDaoDiffblueTest {
    @Autowired
    private cartDao cartDao;

    /**
     * Method under test: {@link cartDao#setSessionFactory(SessionFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetSessionFactory() {
        // TODO: Complete this test.
        //   Reason: R081 Exception in arrange section.
        //   Diffblue Cover was unable to construct an instance of the class under test using
        //   com.jtspringproject.JtSpringProject.dao.cartDao.setSessionFactory(SessionFactory).
        //   The arrange section threw
        //   java.lang.NullPointerException: Cannot invoke "org.hibernate.boot.registry.StandardServiceRegistry.getService(java.lang.Class)" because the return value of "org.hibernate.boot.spi.MetadataBuildingOptions.getServiceRegistry()" is null
        //       at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:173)
        //   See https://diff.blue/R081 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        cartDao cartDao = null;
        SessionFactory sf = null;

        // Act
        cartDao.setSessionFactory(sf);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link cartDao#addCart(Cart)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCart() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Cart cart = null;

        // Act
        Cart actualAddCartResult = this.cartDao.addCart(cart);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link cartDao#getCarts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCarts() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange and Act
        // TODO: Populate arranged inputs
        List<Cart> actualCarts = this.cartDao.getCarts();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link cartDao#updateCart(Cart)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCart() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Cart cart = null;

        // Act
        this.cartDao.updateCart(cart);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link cartDao#deleteCart(Cart)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCart() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Cart cart = null;

        // Act
        this.cartDao.deleteCart(cart);

        // Assert
        // TODO: Add assertions on result
    }
}
