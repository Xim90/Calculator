package by.it_academy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationsTest {
    private static Operations operations;

    @BeforeAll
    public static void setOperations() {
        OperationsTest.operations = new Operations();
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,3", "3,1,4", "-3,0,-3", "-3,1,-2", "-3,-1,-4",
            "3.14,-5.25,-2.11", "23456789.34,999976.45,24456765.79"})
    void testAddition(double firstNumber, double secondNumber, double expectedResult) {
        assertEquals(expectedResult, operations.add(firstNumber, secondNumber), 10e-3,
                "Incorrect work of method 'add'");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,3", "3,1,2", "-3,0,-3", "-3,1,-4", "-3,-1,-2",
            "3.14,-5.25,8.39", "23456789.34,999976.45,22456812.89"})
    void testSubtraction(double firstNumber, double secondNumber, double expectedResult) {
        assertEquals(expectedResult, operations.subtract(firstNumber, secondNumber), 10e-3,
                "Incorrect work of method 'subtract'");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,0", "3,1,3", "-3,0,0", "-3,1,-3", "-3,-1,3",
            "3.14,-5.25,-16.49", "234567.34,9999.45,2345544387.96"})
    void testMultiplication(double firstNumber, double secondNumber, double expectedResult) {
        assertEquals(expectedResult, operations.multiply(firstNumber, secondNumber), 10e-3,
                "Incorrect work of method 'multiply'");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,0", "3,1,3", "-3,0,0", "-3,1,-3", "-3,-1,3",
            "3.14,-5.25,-0.6", "23456789.34,2999.45,7820.36"})
    void testDivision(double firstNumber, double secondNumber, double expectedResult) {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Error! Division by zero");
        });
        try {
            assertEquals(expectedResult, operations.divide(firstNumber, secondNumber), 10e-3,
                    "Incorrect work of method 'divide'");
        } catch (RuntimeException e) {
            assertEquals(exception.getMessage(), e.getMessage(), "Incorrect exception message");
        }
    }
}
