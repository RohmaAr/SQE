package com.jtspringproject.JtSpringProject;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@ExtendWith(SpringExtension.class)
class HibernateConfigurationDiffblueTest {
    @MockBean
    private DataSource dataSource;

    @Autowired
    private HibernateConfiguration hibernateConfiguration;

    @MockBean
    private HibernateTransactionManager hibernateTransactionManager;

    @MockBean
    private LocalSessionFactoryBean localSessionFactoryBean;

    /**
     * Method under test: {@link HibernateConfiguration#dataSource()}
     */
    @Test
    void testDataSource() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        hibernateConfiguration.dataSource();
    }

    /**
     * Method under test: {@link HibernateConfiguration#sessionFactory()}
     */
    @Test
    void testSessionFactory() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        hibernateConfiguration.sessionFactory();
    }

    /**
     * Method under test: {@link HibernateConfiguration#transactionManager()}
     */
    @Test
    void testTransactionManager() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        hibernateConfiguration.transactionManager();
    }
}
