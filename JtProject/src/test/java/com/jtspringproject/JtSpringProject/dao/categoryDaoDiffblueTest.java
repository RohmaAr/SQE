package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.Category;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {categoryDao.class})
@ExtendWith(SpringExtension.class)
class categoryDaoDiffblueTest {
    @Autowired
    private categoryDao categoryDao;

    /**
     * Method under test: {@link categoryDao#addCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCategory() {
        // TODO: Complete this test.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String name = "";

        // Act
        Category actualAddCategoryResult = this.categoryDao.addCategory(name);

        // Assert
        // TODO: Add assertions on result
    }
}
