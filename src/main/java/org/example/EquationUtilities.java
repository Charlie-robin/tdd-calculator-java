package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationUtilities {

    public boolean isNumeric(String strNum) {
        String isNumber = "-?\\d*\\.?\\d+";
        Pattern pattern = Pattern.compile(isNumber);
        return pattern.matcher(strNum).matches();
    }

    public List<String> formatEquation(String equation) {

        List<String> formattedEquation = new ArrayList<>();

        for (int i = 0; i < equation.length(); i++) {
            char item = equation.charAt(i);

            if (item == '-') {
                if (i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1)) && !Character.isDigit(equation.charAt(i - 1))) {
                    StringBuilder number = new StringBuilder();
                    number.append(item);
                    i++;
                    while (i < equation.length() && (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.')) {
                        number.append(equation.charAt(i));
                        i++;
                    }
                    formattedEquation.add(number.toString());
                    i--;
                } else {
                    formattedEquation.add(Character.toString(item));
                }
            } else if (Character.isDigit(item)) {
                StringBuilder number = new StringBuilder();
                while (i < equation.length() && (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.')) {
                    number.append(equation.charAt(i));
                    i++;
                }
                formattedEquation.add(number.toString());
                i--;
            } else if (item == '+' || item == '*' || item == '/' || item == '(' || item == ')') {
                formattedEquation.add(Character.toString(item));
            }
        }

        return formattedEquation;
    }

    public void validateEquation(String equation) throws IllegalArgumentException {
        if (hasCharacters(equation)) throw new IllegalArgumentException("Illegal Characters found in : " + equation);
        if (hasInvalidBrackets(equation)) throw new IllegalArgumentException("Invalid Brackets found in : " + equation);
        if (hasMultipleOperators(equation))
            throw new IllegalArgumentException("Multiple operators found in : " + equation);
    }

    private boolean hasCharacters(String equation) {
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

            if (!brackets.isEmpty() && brackets.peek() == Operators.OPENING_BRACKET && bracket == Operators.CLOSING_BRACKET) {
                brackets.pop();
            } else {
                brackets.push(bracket);
            }
        }

        return !brackets.isEmpty();
    }


}
