package com.jtspringproject.JtSpringProject.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class userDaoDiffblueTest {
    /**
     * Method under test: {@link userDao#deleteUser(int)}
     */
    @Test
    void testDeleteUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R083 Can't find a suitable constructor.
        //   Diffblue Cover was unable to construct an instance of NamedProcedureCallDefinition.
        //   No suitable constructor or factory method found. Please check that the class
        //   under test has a non-private constructor or factory method.
        //   See https://diff.blue/R083 for further troubleshooting of this issue.

        assertFalse((new userDao()).deleteUser(1));
    }
}
