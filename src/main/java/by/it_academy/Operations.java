package by.it_academy;

import static by.it_academy.Constants.DIVISION_ZERO;

public class Operations {
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double divide(double firstOperand, double secondOperand) throws RuntimeException {
        if (secondOperand == 0) {
            throw new RuntimeException(DIVISION_ZERO);
        } else {
            return firstOperand / secondOperand;
        }
    }
}
