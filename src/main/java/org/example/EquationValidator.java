package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationValidator {

    public boolean isNumeric(String strNum) {
        String isNumber = "-?\\d*\\.?\\d+";
        Pattern pattern = Pattern.compile(isNumber);
        return pattern.matcher(strNum).matches();
    }

    public List<String> formatEquation(String equation) {
        String isNumberOrOperator = "(?<!\\d)-?\\d*\\.?\\d+|[+\\-*/()]";
        Pattern pattern = Pattern.compile(isNumberOrOperator);
        Matcher matcher = pattern.matcher(equation);
        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
    public void validateEquation(String equation) {
        // TODO: THROW ERRORS
        if (hasWords(equation)) return;
        if (hasMultipleOperators(equation)) return;
        if (hasInvalidBrackets(equation)) return;

        System.out.println("ALL GOOD " + equation);
    }

    private boolean hasWords(String equation) {
        String words = "[a-z]";
        Pattern pattern = Pattern.compile(words, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(equation);
        return matcher.find();
    }

    private boolean hasMultipleOperators(String equation) {
        String multipleOperatorsAndDecimals = "[+/*.]{2,}|-[+/*]|[+/*]-|-{3,}|\\d*\\.\\d*\\.";
        Pattern pattern = Pattern.compile(multipleOperatorsAndDecimals);
        Matcher matcher = pattern.matcher(equation);
        return matcher.find();
    }

    private boolean hasInvalidBrackets(String equation) {
        String notBracket = "[^()]";
        String justBrackets = equation.replaceAll(notBracket, "");
        Stack<Character> brackets = new Stack<>();

        for (int index = 0; index < justBrackets.length(); index++) {
            char bracket = justBrackets.charAt(index);

            if (!brackets.isEmpty() && brackets.peek() == '(' && bracket == ')') {
                brackets.pop();
            } else {
                brackets.push(bracket);
            }
        }

        return !brackets.isEmpty();
    }



}
