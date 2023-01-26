package org.example;

public class Main {

    /**
     * TODO:
     * - CLASSES FOR:
     *  - ERROR CONTROLLER
     * - TIDY UP TRY / CATCH
     */

    public static void main(String[] args) {

        Commands commands = new Commands();
        EquationRepository equationRepository = new EquationRepository();
        CalculatorController calculatorController = new CalculatorController(commands, equationRepository);

        int input;
        while (true) {
            String[] options = {"Calculate", "Quit"};
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

