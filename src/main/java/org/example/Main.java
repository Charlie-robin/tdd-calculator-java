package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<String> postFix = calculator.convertToPostFix("(5.555*4.4+3*2)-1");
        System.out.println("Postfix " + postFix);
        System.out.println(calculator.evaluatePostFix(postFix));
        System.out.println("5 4 * 3 2 * + 1 -");

    }
}