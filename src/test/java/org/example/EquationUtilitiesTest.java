package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquationUtilitiesTest {

    private final EquationUtilities equationUtilities = new EquationUtilities();

    @Test
    void isNumeric_GivenNumbers_ReturnsTrue() {
        String[] numbers = {"5", "-5", "0.75", "300", "50000"};

        for (String number : numbers) {
            assertTrue(equationUtilities.isNumeric(number));
        }

    }

    @Test
    void isNumeric_NotGivenNumbers_ReturnsFalse() {
        String[] numbers = {"*", "/", "(", ")", "-", "+", "ten", "h3ll0"};

        for (String number : numbers) {
            assertFalse(equationUtilities.isNumeric(number));
        }

    }

    @Test
    void formatEquation_EquationWithOutWhiteSpace_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200+3*4/5-6");
        String[] expected = new String[]{"200", "+", "3", "*", "4", "/", "5", "-", "6"};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithWhiteSpace_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200 / 5 - 6");
        String[] expected = new String[]{"200", "/", "5", "-", "6"};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithNumbersOperators_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200 + 3 * 4 / 5 - 6");
        String[] expected = new String[]{"200", "+", "3", "*", "4", "/", "5", "-", "6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithBrackets_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("(200 + 3) * 4 / (5 - 6)");
        String[] expected = new String[]{"(", "200", "+", "3", ")", "*", "4", "/", "(", "5", "-", "6", ")"};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithDecimals_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200 + 3.0 * 4 / 5 - 6");
        String[] expected = new String[]{"200", "+", "3.0", "*", "4", "/", "5", "-", "6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithNegatives_ReturnsEquationFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200 + -3 * -4 / 5 - -6");
        String[] expected = new String[]{"200", "+", "-3", "*", "-4", "/", "5", "-", "-6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void formatEquation_EquationWithNegatives_ReturnsEquationsFormattedCorrectly() {
        List<String> result = equationUtilities.formatEquation("200 + -3 * -4 / 5 - -6");
        String[] expected = new String[]{"200", "+", "-3", "*", "-4", "/", "5", "-", "-6",};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void validateEquation_GivenValidEquations_NotThrowException() {
        String[] equations = {"2+2", "200 + -3 * -4 / 5 - -6", "(((200 + 3)) * 4 / (5 - 6))"};

        for (String equation : equations) {
            equationUtilities.validateEquation(equation);
        }
    }

    @Test
    public void validateEquation_GivenEquationWithCharacters_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            equationUtilities.validateEquation("A 2 + yellow 2");
        });
        String expectedMessage = "Illegal Characters found in : A 2 + yellow 2";
        assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    public void validateEquation_GivenEquationWithInvalidBrackets_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            equationUtilities.validateEquation(")((200 + 3) * 4 / (5 - 6)");
        });
        String expectedMessage = "Invalid Brackets found in : )((200 + 3) * 4 / (5 - 6)";
        assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    public void validateEquation_GivenEquationWithMultipleOperators_ThrowsException() {
        String[] equations = {"7++4", "5.5.5.5 - 5", "5 // 5", "200 +--3 // 4 / 2.55.5 - -6.0"};
        for (String equation: equations) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                equationUtilities.validateEquation(equation);
            });
            String expectedMessage = "Multiple operators found in : " + equation;
            assertEquals(exception.getMessage(), expectedMessage);
        }
    }
}