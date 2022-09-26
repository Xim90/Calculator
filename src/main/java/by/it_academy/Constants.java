package by.it_academy;

public class Constants {
    private Constants() {
    }

    public static final String WELCOME_MESSAGE = """
            Welcome!
            Command 'end' to stop calculator
            Enter A[+-*/]B expression (A,B - fractional numbers)
            """;
    public static final String CALCULATOR_STOPPED = "Calculator stopped";
    public static final String PATTERN_NUMBERS = "-?\\d+(\\.\\d+)?";
    public static final String PATTERN_OPERATIONS = "(?<=[^(])[\\-+/*]";
    public static final String PATTERN_EXPRESSION =
            "^" + PATTERN_NUMBERS + PATTERN_OPERATIONS + "(\\()?" + PATTERN_NUMBERS + "(\\))?" + "$";
    public static final String PRINT_DOUBLE_FORMAT = "%5.2f\n";
    public static final String RIGHT_BRACKET = ")";
    public static final String LEFT_BRACKET = "(";
    public static final String COMMAND_STOP = "end";
    public static final String INCORRECT_INPUT = "Incorrect input! Try again";

    public static final String OPERATION_NOT_FOUND = "Error! Operation not found";

    public static final String DIVISION_ZERO = "Error! Division by zero";
}
