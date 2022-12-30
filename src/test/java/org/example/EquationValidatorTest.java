package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquationValidatorTest {

    private final EquationValidator equationValidator = new EquationValidator();

    @Test
    void isNumeric_GivenNumbers_ReturnsTrue() {
        String[] numbers = {"5", "-5", "0.75", "300", "50000"};

        for (String number : numbers) {
            assertTrue(equationValidator.isNumeric(number));
        }

    }

    @Test
    void isNumeric_NotGivenNumbers_ReturnsFalse() {
        String[] numbers = {"*", "/", "(", ")", "-", "+", "ten", "h3ll0"};

        for (String number : numbers) {
            assertFalse(equationValidator.isNumeric(number));
        }

    }

    @Test
    void formatEquation_EquationWithOutWhiteSpace_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200+3*4/5-6");
        String[] expected = new String[]{"200", "+", "3", "*", "4", "/", "5", "-", "6"};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithWhiteSpace_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 / 5 - 6");
        String[] expected = new String[]{"200", "/", "5", "-", "6"};
        assertArrayEquals(expected, result.toArray());
    }
    @Test
    void formatEquation_EquationWithNumbersOperators_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 + 3 * 4 / 5 - 6");
        String[] expected = new String[]{"200", "+", "3", "*", "4", "/", "5", "-", "6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithBrackets_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("(200 + 3) * 4 / (5 - 6)");
        String[] expected = new String[]{"(", "200", "+", "3", ")", "*", "4", "/", "(", "5", "-", "6", ")"};
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
    @Test
    void formatEquation_EquationWithNegatives_ReturnsEquationsFormattedCorrectly() {
        List<String> result = equationValidator.formatEquation("200 + -3 * -4 / 5 - -6");
        String[] expected = new String[]{"200", "+", "-3", "*", "-4", "/", "5", "-", "-6",};
        System.out.println(result);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void validateEquation() {
        // TODO: BREAK OUT TESTS
        equationValidator.validateEquation("2+2");
        equationValidator.validateEquation("2 + YELLOW 2");
        equationValidator.validateEquation("(((200 + 3)) * 4 / (5 - 6))");
        equationValidator.validateEquation(")(200 + 3) * 4 / (5 - 6)");
        equationValidator.validateEquation("5 ++ 6");
        equationValidator.validateEquation("7 // 2");
        equationValidator.validateEquation("200 +--3 // 4 / 2.55.5 - -6.0");
        equationValidator.validateEquation("200 + -3 * -4 / 5 - -6");
    }
}