package by.it_academy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorWorkerTest {
    private static CalculatorWorker calculatorWorker;

    @BeforeAll
    public static void setCalculatorWorkerTest() {
        CalculatorWorkerTest.calculatorWorker = new CalculatorWorker(new Parser(), new Operations());
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"43", "frgherh", "45.1/454+1.01", "464.3+1a"}
    )
    void testWorkExceptions(String expression) throws RuntimeException {
        Throwable exception = assertThrows(
                RuntimeException.class, () -> {
                    throw new RuntimeException("Incorrect input! Try again");
                }
        );
        try {
            calculatorWorker.work(expression);
        } catch (RuntimeException e) {
            assertEquals(exception.getMessage(), e.getMessage(), "Incorrect exception message");
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"25.14-34.12,-8.98",
            "-54.4-(-13.34),-41.06",
            "54.65+13.43,68.08",
            "52.12/3.21,16.24",
            "43.13*4.25,183.30"}
    )
    void testCalc(String expression, double expectedResult) {
        assertEquals(expectedResult, calculatorWorker.calc(expression), 10e-3,
                "Incorrect work of method 'calc'! expected " + expectedResult +
                        " => actual " + calculatorWorker.calc(expression));
    }
}