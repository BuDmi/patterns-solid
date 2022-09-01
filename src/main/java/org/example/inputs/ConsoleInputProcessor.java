package org.example.inputs;

import java.util.Scanner;

public class ConsoleInputProcessor implements InputsProcessor{
    private final Scanner scanner;

    public ConsoleInputProcessor() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int readUserIntegerNumber() {
        return scanner.nextInt();
    }

    @Override
    public String readUserText() {
        return scanner.next();
    }

    @Override
    public boolean readUserAcceptance() {
        String userAnswer = scanner.nextLine();
        return userAnswer.equals("y");
    }
}
