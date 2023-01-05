package org.example;

public class CalculatorController implements Runnable {

    private final String[] options = {"Help", "Equation", "Back"};
    private final Calculator calculator = new Calculator();
    private final Commands commands;

    public CalculatorController(Commands commands) {
        this.commands = commands;
    }



    @Override
    public void run() {
        calculatorRunning: while (true) {
            commands.printNumberedOptions(options);
            int input = commands.getIntegerInput(options.length);

            switch (input){
                case 1:
                    commands.printMessage("Help");
                    commands.printMessage("This calculator supports the following operations:");
                    commands.printOptions(calculator.getSupportedOperators());
                    break;
                case 2:
                    commands.printMessage("Example equation (5 + 5) / 2");
                    commands.printMessage("Enter equation");
                    String equation = commands.getStringInput();
                    double result = calculator.calculate(equation);
                    commands.printMessage(String.valueOf(result));
                    break;
                default:
                    break calculatorRunning;
            }

        }
    }
}
