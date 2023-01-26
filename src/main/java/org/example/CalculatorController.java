package org.example;

import java.io.IOException;

public class CalculatorController implements Runnable {

    private final String[] options = {"Help", "Equation", "Back"};
    private final Calculator calculator = new Calculator();
    private final Commands commands;
    private final EquationRepository equationRepository;

    public CalculatorController(Commands commands, EquationRepository equationRepository) {
        this.commands = commands;
        this.equationRepository = equationRepository;
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
                    commands.printMessage("Equation");
                    commands.printMessage("Example equation (5 + 5) / 2");
                    commands.printMessage("Enter equation");
                    String equation = commands.getStringInput();
                    double result = calculator.calculate(equation);
                    commands.printMessage(String.valueOf(result));
                    try {
                        equationRepository.addToEquations(equation,result);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    break calculatorRunning;
            }

        }
    }
}
