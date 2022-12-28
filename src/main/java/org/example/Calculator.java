package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {

    public List<String> convertToPostFix(String toConvert) {
        Stack<String> stack = new Stack<>();
        Stack<String> output = new Stack<>();

        String[] equation = toConvert.split("");

        boolean postDecimal = false;
        boolean postOperator = false;

        for (String item : equation) {

            if (isNumeric(item) && !postDecimal) {
                output.push(item);
                continue;
            }

            if (isDecimal(item)) {
                postDecimal = true;
            }

            if ((isNumeric(item) && postDecimal) || isDecimal(item)) {
                String temp = output.pop();
                output.push(temp + item);
                continue;
            }

            postDecimal = false;

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
            if (isNumeric(item)) {
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

    private boolean isDecimal(String item) {
        return item.equals(".");
    }

    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}