package by.it_academy;

import java.util.Scanner;

import static by.it_academy.Constants.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class Runner {

    public static void main(String[] args) {
        CalculatorWorker calculatorWorker = new CalculatorWorker(new Parser(), new Operations());
        Scanner scanner = new Scanner(in);
        out.println(WELCOME_MESSAGE);
        String expression = "";
        while (!expression.toLowerCase().matches(COMMAND_STOP)) {
            expression = scanner.next();
            try {
                calculatorWorker.work(expression);
            } catch (RuntimeException e) {
                out.println(e.getMessage());
            }
        }
        out.println(CALCULATOR_STOPPED);
    }
}
