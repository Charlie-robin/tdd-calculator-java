package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PrecedenceTest {

    private final Precedence precedence = new Precedence();

    @Test
    void hasPrecedence_PrecedenceValue2ComparedToLowest_ReturnsTrue() {
        String[] operators = {"+", "-", "(", ")"};

        for (String operator : operators) {
            assertTrue(precedence.hasPrecedence("*", operator));
            assertTrue(precedence.hasPrecedence("/", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceValue1ComparedToLowest_ReturnsTrue() {
        String[] operators = { "(", ")"};

        for (String operator : operators) {
            assertTrue(precedence.hasPrecedence("+", operator));
            assertTrue(precedence.hasPrecedence("-", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceComparedToSamePrecedence_ReturnsTrue() {
        assertTrue(precedence.hasPrecedence("*", "/"));
        assertTrue(precedence.hasPrecedence("/", "*"));
        assertTrue(precedence.hasPrecedence("*", "*"));
        assertTrue(precedence.hasPrecedence("/", "/"));
        assertTrue(precedence.hasPrecedence("+", "-"));
        assertTrue(precedence.hasPrecedence("-", "+"));
        assertTrue(precedence.hasPrecedence("+", "+"));
        assertTrue(precedence.hasPrecedence("-", "-"));
        assertTrue(precedence.hasPrecedence("(", ")"));
        assertTrue(precedence.hasPrecedence(")", "("));
        assertTrue(precedence.hasPrecedence("(", "("));
        assertTrue(precedence.hasPrecedence(")", ")"));
    }
}
