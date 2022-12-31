package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Stack;


public class Calculator {

    private final EquationUtilities equationUtilities = new EquationUtilities();
    private final Precedence precedence = new Precedence();

    public List<String> convertToPostFix(List<String> toConvert) {
        Stack<String> stack = new Stack<>();
        Stack<String> output = new Stack<>();


        for (String item : toConvert) {

            if (equationUtilities.isNumeric(item)) {
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

            if (precedence.hasPrecedence(lastItem, item)) {
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
            if (equationUtilities.isNumeric(item)) {
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

    public double calculate(String equation){
        equationUtilities.validateEquation(equation);
        List<String> formatEquation = equationUtilities.formatEquation(equation);
        List<String> postFix = convertToPostFix(formatEquation);
        return evaluatePostFix(postFix);
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
                // TODO: THROW ERROR / 0
                return Double.parseDouble(a) / Double.parseDouble(b);
            default:
                return 0d;
        }
    }

}