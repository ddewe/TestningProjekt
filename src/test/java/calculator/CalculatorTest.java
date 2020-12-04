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

}
