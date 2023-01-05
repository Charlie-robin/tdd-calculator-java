package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();


    @Test
    void convertToPostFix_SimpleEquation_ReturnsCorrectFormat() {
        List<String> equation = List.of("2", "+", "3");
        String[] result = calculator.convertToPostFix(equation).toArray(new String[0]);
        String[] expected = new String[]{"2", "3", "+"};
        assertArrayEquals(expected, result);
    }

    @Test
    void convertToPostFix_SimpleEquationWithPrecedence_ReturnsCorrectFormat() {
        List<String> equation = List.of("2", "-", "3", "/", "20");
        String[] result = calculator.convertToPostFix(equation).toArray(new String[0]);
        String[] expected = new String[]{"2", "3", "20", "/", "-"};
        assertArrayEquals(expected, result);
    }

    @Test
    void convertToPostFix_ScientificEquationWithPrecedenceAndBrackets_ReturnsCorrectFormat() {
        List<String> equation = List.of("(", "5", "*", "4", "+", "3", "*", "2", ")", "-", "1");
        String[] result = calculator.convertToPostFix(equation).toArray(new String[0]);
        String[] expected = new String[]{"5", "4", "*", "3", "2", "*", "+", "1", "-"};
        assertArrayEquals(expected, result);
    }

    @Test
    void convertToPostFix_EquationWithDecimalsAndBracketsAndPrecedence_ReturnsCorrectFormat() {
        List<String> equation = List.of("(", "4.45", "+", "3.75", ")", "/", "1.5");
        String[] result = calculator.convertToPostFix(equation).toArray(new String[0]);
        String[] expected = new String[]{"4.45", "3.75", "+", "1.5", "/"};
        assertArrayEquals(result, expected);
    }

    @Test
    void evaluatePostFix_PostFixSimpleEquation_ReturnsCorrectValue() {
        Double result = calculator.evaluatePostFix(List.of("2", "3", "+"));
        assertEquals(5, result);
    }

    @Test
    void evaluatePostFix_PostFixSimpleEquationWithPrecedence_ReturnsCorrectValue() {
        Double result = calculator.evaluatePostFix(List.of("2", "3", "20", "/", "-"));
        assertEquals(1.85, result);
    }

    @Test
    void evaluatePostFix_PostFixScientificEquationWithPrecedenceAndBrackets_ReturnsCorrectValue() {
        Double result = calculator.evaluatePostFix(List.of("5", "4", "*", "3", "2", "*", "+", "1", "-"));
        assertEquals(25, result);
    }

    @Test
    void evaluatePostFix_PostFixEquationWithDecimalsAndBracketsAndPrecedence_ReturnsCorrectValue() {
        Double result = calculator.evaluatePostFix(List.of("4.45", "3.75", "+", "1.5", "/"));
        assertEquals(5.466666666666666, result);
    }

    @Test
    void calculate_GivenAddition_ReturnsAdditionResult() {
        assertEquals(5, calculator.calculate("2", "3", '+'));
    }

    @Test
    void calculate_GivenSubtraction_ReturnsSubtractionResult() {
        assertEquals(177, calculator.calculate("200", "23", '-'));
    }

    @Test
    void calculate_GivenDivision_ReturnsDivisionResult() {
        assertEquals(2, calculator.calculate("20", "10", '/'));
    }

    @Test
    void calculate_GivenMultiplication_ReturnsMultiplicationResult() {
        assertEquals(200, calculator.calculate("20", "10", '*'));
    }

    @Test
    void calculate_GivenRandomCharacter_ReturnsZero() {
        assertEquals(0, calculator.calculate("20", "10", '!'));
    }

    @Test
    void calculate_SimpleEquation_ReturnsValue() {
        assertEquals(calculator.calculate("2+2"), 4);
    }

    @Test
    void calculate_SimpleEquationWithPrecedence_ReturnsValue() {
        assertEquals(calculator.calculate("2-3/20"), 1.85);
    }

    @Test
    void calculate_ScientificEquationWithPrecedenceAndBrackets_ReturnsValue() {
        assertEquals(calculator.calculate("( 5 * 4 + 3 * 2 ) - 1"), 25);
    }
    @Test
    void calculate_ScientificEquationWithPrecedenceBrackets_ReturnsValue() {
        assertEquals(calculator.calculate("((2-1)/2)--2*2"), 4.5);
    }
}