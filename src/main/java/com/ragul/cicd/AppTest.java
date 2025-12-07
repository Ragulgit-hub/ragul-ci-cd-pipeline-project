package com.ragul.cicd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {

    @Test
    void messageIsCorrect() {
        String msg = App.getMessage();
        assertEquals("Hi, welcome to the Ragul's CI/CD pipeline project!", msg);
    }

    @Test
    void messageIsNotNull() {
        String msg = App.getMessage();
        assertNotNull(msg);
    }
}
