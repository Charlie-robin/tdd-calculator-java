package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PrecedenceTest {


    @Test
    void hasPrecedence_PrecedenceValue2ComparedToLowest_ReturnsTrue() {
        String[] operators = {"+", "-", "(", ")"};

        for (String operator : operators) {
            assertTrue(Precedence.hasPrecedence("*", operator));
            assertTrue(Precedence.hasPrecedence("/", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceValue1ComparedToLowest_ReturnsTrue() {
        String[] operators = { "(", ")"};

        for (String operator : operators) {
            assertTrue(Precedence.hasPrecedence("+", operator));
            assertTrue(Precedence.hasPrecedence("-", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceComparedToSamePrecedence_ReturnsTrue() {
        assertTrue(Precedence.hasPrecedence("*", "/"));
        assertTrue(Precedence.hasPrecedence("/", "*"));
        assertTrue(Precedence.hasPrecedence("*", "*"));
        assertTrue(Precedence.hasPrecedence("/", "/"));
        assertTrue(Precedence.hasPrecedence("+", "-"));
        assertTrue(Precedence.hasPrecedence("-", "+"));
        assertTrue(Precedence.hasPrecedence("+", "+"));
        assertTrue(Precedence.hasPrecedence("-", "-"));
        assertTrue(Precedence.hasPrecedence("(", ")"));
        assertTrue(Precedence.hasPrecedence(")", "("));
        assertTrue(Precedence.hasPrecedence("(", "("));
        assertTrue(Precedence.hasPrecedence(")", ")"));
    }
}
