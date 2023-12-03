package com.jtspringproject.JtSpringProject.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CartNotFoundExceptionDiffblueTest {
    /**
     * Method under test:
     * {@link CartNotFoundException#CartNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        CartNotFoundException actualCartNotFoundException = new CartNotFoundException("An error occurred");
        assertEquals("An error occurred", actualCartNotFoundException.getLocalizedMessage());
        assertEquals("An error occurred", actualCartNotFoundException.getMessage());
        assertNull(actualCartNotFoundException.getCause());
        assertEquals(0, actualCartNotFoundException.getSuppressed().length);
    }

    /**
     * Method under test:
     * {@link CartNotFoundException#CartNotFoundException(String, Throwable)}
     */
    @Test
    void testConstructor2() {
        Throwable cause = new Throwable();
        CartNotFoundException actualCartNotFoundException = new CartNotFoundException("An error occurred", cause);

        assertEquals("An error occurred", actualCartNotFoundException.getLocalizedMessage());
        assertEquals("An error occurred", actualCartNotFoundException.getMessage());
        Throwable cause2 = actualCartNotFoundException.getCause();
        assertNull(cause2.getLocalizedMessage());
        assertNull(cause2.getMessage());
        assertNull(cause2.getCause());
        Throwable[] suppressed = actualCartNotFoundException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertSame(cause, cause2);
        assertSame(suppressed, cause2.getSuppressed());
    }
}
