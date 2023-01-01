package org.example;

import java.util.List;

public class Main {

    /**
     * TODO:
     * - PRINT OPTIONS
     * - CLASSES FOR:
     *  - CALCULATOR COMMANDS
     *  - ERROR COMMANDS
     */

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Commands commands = new Commands();

        while (true) {
            commands.printMessage("Enter equation");
            String equation = commands.getStringInput();
            try {
                double result = calculator.calculate(equation);
                commands.printMessage(String.valueOf(result));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            }
        }

        commands.close();

    }
}

