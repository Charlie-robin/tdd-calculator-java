package org.example;

import java.util.Scanner;


public class Commands {
    private final Scanner scanner = new Scanner(System.in);
    public void printMessage(String message){
        System.out.println(message);
    }

    public void printCommands(String[] commands){
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + " : " + commands[i]);
        }
    }

    public int getIntegerInput(int rangeLimit){

        int input = 0;
        boolean isActive = true;

        while(isActive){
            printMessage("Enter a number between 1 - " + rangeLimit);
            int userInput = scanner.nextInt();

            if(userInput > 0 && userInput <= rangeLimit){
                isActive = false;
                input = userInput;
            } else {
                printMessage("Unable to understand input, try again");
            }
        }

        scanner.nextLine();

        return input;
    }

    public String getStringInput() {

        boolean isActive = true;

        String input = "";

        while (isActive) {
            printMessage("Enter text below:");
            String userInput = scanner.nextLine();

            if (!userInput.equals("")) {
                input = userInput;
                isActive = false;
            } else {
                printMessage("Unable to understand input, try again");
            }
        }

        return input;
    }

    public void close() {
        scanner.close();
    }

}