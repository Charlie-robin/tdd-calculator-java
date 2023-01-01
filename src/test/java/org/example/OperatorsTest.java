package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class OperatorsTest {

    private final Operators operators = new Operators();

    @Test
    void hasPrecedence_PrecedenceValue2ComparedToLowest_ReturnsTrue() {
        String[] operators = {"+", "-", "(", ")"};

        for (String operator : operators) {
            assertTrue(this.operators.hasPrecedence("*", operator));
            assertTrue(this.operators.hasPrecedence("/", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceValue1ComparedToLowest_ReturnsTrue() {
        String[] operators = { "(", ")"};

        for (String operator : operators) {
            assertTrue(this.operators.hasPrecedence("+", operator));
            assertTrue(this.operators.hasPrecedence("-", operator));
        }

    }

    @Test
    void hasPrecedence_PrecedenceComparedToSamePrecedence_ReturnsTrue() {
        assertTrue(operators.hasPrecedence("*", "/"));
        assertTrue(operators.hasPrecedence("/", "*"));
        assertTrue(operators.hasPrecedence("*", "*"));
        assertTrue(operators.hasPrecedence("/", "/"));
        assertTrue(operators.hasPrecedence("+", "-"));
        assertTrue(operators.hasPrecedence("-", "+"));
        assertTrue(operators.hasPrecedence("+", "+"));
        assertTrue(operators.hasPrecedence("-", "-"));
        assertTrue(operators.hasPrecedence("(", ")"));
        assertTrue(operators.hasPrecedence(")", "("));
        assertTrue(operators.hasPrecedence("(", "("));
        assertTrue(operators.hasPrecedence(")", ")"));
    }
}
