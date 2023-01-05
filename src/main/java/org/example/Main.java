package org.example;

import java.util.List;

public class Main {

    /**
     * TODO:
     * - CLASSES FOR:
     *  - ERROR COMMANDS
     */

    public static void main(String[] args) {
        String[] options = {"Calculate", "Quit"};
        Commands commands = new Commands();
        CalculatorController calculatorController = new CalculatorController(commands);
        int input;

        while (true) {
            commands.printMessage("Welcome to the Calculator Home");
            commands.printMessage("What would you like to do?");
            commands.printNumberedOptions(options);
            input = commands.getIntegerInput(options.length);

            try {
                if (input == 1) {
                    calculatorController.run();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            }
        }

        commands.close();

    }
}

