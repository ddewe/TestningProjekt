package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void calculatorClassExists() {
    }

    @Test
    void addMethodExists() {
        calculator.add("");
    }

    @Test
    void addMethodReturnsZeroWhenInputIsEmpty() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void addMethodReturnsSumOfInput() {
        assertEquals(4, calculator.add("2,2"));
    }

    @Test
    void addMethodReturnsSumOfSingleDigitInput() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void addMethodReturnsSumOfUnknownAmountOfInputs() {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    void addMethodHandlesNewLineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

}
