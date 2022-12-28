package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void convertToPostFix_SimpleEquation_ReturnsCorrectFormat() {
        String[] result = calculator.convertToPostFix("2+3").toArray(new String[0]);
        String[] expected =  new String[]{"2", "3", "+"};
        assertArrayEquals(result, expected);
    }

    @Test
    void convertToPostFix_SimpleEquationWithPrecedence_ReturnsCorrectFormat() {
        String[] result = calculator.convertToPostFix("2-3/20").toArray(new String[0]);
        String[] expected =  new String[]{"2", "3", "2","0","/", "-"};
        assertArrayEquals(result, expected);
    }

    @Test
    void convertToPostFix_ScientificEquationWithPrecedenceAndBrackets_ReturnsCorrectFormat() {
        String[] result = calculator.convertToPostFix("(5*4+3*2)-1").toArray(new String[0]);
        String[] expected =  new String[]{"5","4","*","3","2","*","+","1","-"};
        assertArrayEquals(result, expected);
    }

    @Test
    void convertToPostFix_EquationWithDecimalsAndBracketsAndPrecedence_ReturnsCorrectFormat() {
        String[] result = calculator.convertToPostFix("(4.45+3)/1").toArray(new String[0]);
        String[] expected =  new String[]{"4.45","3","+","1","/"};
        assertArrayEquals(result, expected);
    }

    @Test
    void evaluatePostFix() {
    }

    @Test
    void calculate() {
    }
}