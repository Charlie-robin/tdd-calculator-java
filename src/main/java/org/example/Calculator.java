package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final EquationValidator equationValidator = new EquationValidator();



    public List<String> convertToPostFix(List<String> toConvert) {
        Stack<String> stack = new Stack<>();
        Stack<String> output = new Stack<>();


        for (String item : toConvert) {

            if (equationValidator.isNumeric(item)) {
                output.push(item);
                continue;
            }

            if (stack.isEmpty() || stack.peek().equals("(")) {
                stack.push(item);
                continue;
            }

            if (Objects.equals(item, ")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.push(stack.pop());
                }
                stack.pop();
                continue;
            }

            String lastItem = stack.pop();

            if (Precedence.hasPrecedence(lastItem, item)) {
                output.push(lastItem);
                stack.push(item);
            } else {
                stack.push(lastItem);
                stack.push(item);
            }
        }

        while (!stack.isEmpty()) {
            output.push(stack.pop());
    }

        return output;
    }

    public double evaluatePostFix(List<String> toEvaluate) {

        Stack<String> stack = new Stack<>();
        for (String item : toEvaluate) {
            if (equationValidator.isNumeric(item)) {
                stack.push(item);
                continue;
            }

            String operand2 = stack.pop();
            String operand1 = stack.pop();

            stack.push(String.valueOf(calculate(operand1, operand2, item)));
        }

        String result = stack.pop();

        return Double.parseDouble(result);
    }

    public double calculate(String a, String b, String operand) {
        switch (operand) {
            case "+":
                return Double.parseDouble(a) + Double.parseDouble(b);
            case "-":
                return Double.parseDouble(a) - Double.parseDouble(b);
            case "*":
                return Double.parseDouble(a) * Double.parseDouble(b);
            case "/":
                return Double.parseDouble(a) / Double.parseDouble(b);
            default:
                return 0d;
        }
    }

}