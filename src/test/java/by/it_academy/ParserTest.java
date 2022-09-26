package by.it_academy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    private static Parser parser;

    @BeforeAll
    public static void setParser() {
        ParserTest.parser = new Parser();
    }

    @ParameterizedTest
    @CsvSource(value = {"3+4,3,4", "43.7-6.4,43.7,6.4", "-23*56.1,-23,56.1", "64.563/56,64.563,56"})
    void getNumbers(String expression, double number1, double number2) {
        double[] expectedResult = new double[]{number1, number2};
        double[] actualResult = parser.getNumbers(expression);
        assertArrayEquals(expectedResult, actualResult, "Incorrect result of numbers parsing! expected " +
                Arrays.toString(expectedResult) + " => actual " + Arrays.toString(actualResult));
    }

    @ParameterizedTest
    @CsvSource(value = {"3+4.1,+", "43.7-6.4,-", "-23*56.1,*", "64.563/56,/"})
    void getOperation(String expression, String expectedOperation) {
        String actualResult = parser.getOperation(expression);
        assertEquals(expectedOperation, actualResult, "Incorrect result of operation parsing! " +
                "Expected " + expectedOperation + " Actual " + actualResult);
    }
}