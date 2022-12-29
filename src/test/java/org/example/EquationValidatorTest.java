package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquationValidatorTest {

    private final EquationValidator equationValidator = new EquationValidator();


    @Test
    void isNumeric() {
    }

    @Test
    void formatEquation_EquationWithNumbersOperators_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 + 3 * 4 / 5 - 6");
        String[] expected = new String[]{ "200", "+", "3", "*", "4", "/", "5", "-", "6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithBrackets_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("(200 + 3) * 4 / (5 - 6)");
        String[] expected = new String[]{"(", "200", "+", "3", ")", "*", "4", "/", "(", "5", "-", "6",")"};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithDecimals_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 + 3.0 * 4 / 5 - 6");
        String[] expected = new String[]{"200", "+", "3.0", "*", "4", "/", "5", "-", "6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithNegatives_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 + -3 * -4 / 5 - -6");
        String[] expected = new String[]{"200", "+", "-3", "*", "-4", "/", "5", "-", "-6",};
        assertArrayEquals(expected, result.toArray());
    }
}