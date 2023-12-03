package com.jtspringproject.JtSpringProject.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {productDao.class})
@ExtendWith(SpringExtension.class)
class productDaoDiffblueTest {
    @Autowired
    private productDao productDao;

    /**
     * Method under test: {@link productDao#deletProduct(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletProduct() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        int id = 0;

        // Act
        Boolean actualDeletProductResult = this.productDao.deletProduct(id);

        // Assert
        // TODO: Add assertions on result
    }
}
