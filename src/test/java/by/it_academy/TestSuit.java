package by.it_academy;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculatorWorkerTest.class, OperationsTest.class, ParserTest.class})
public class TestSuit {
}
