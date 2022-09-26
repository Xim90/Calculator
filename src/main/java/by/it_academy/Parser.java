package by.it_academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it_academy.Constants.*;

public class Parser {

    public double[] getNumbers(String expression) {
        String[] stringNumbers = expression.split(PATTERN_OPERATIONS);
        double[] numbers = new double[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Double.parseDouble(stringNumbers[i].replace(LEFT_BRACKET, "")
                    .replace(RIGHT_BRACKET, ""));
        }
        return numbers;
    }

    public String getOperation(String expression) {
        Pattern pattern = Pattern.compile(PATTERN_OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        String operation = "";
        while (matcher.find()) {
            operation = matcher.group();
        }
        return operation;
    }
}
