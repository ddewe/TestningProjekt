package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void calculatorClassExists() {
        Calculator calculator = new Calculator();
    }

    @Test
    void addMethodExists() {
        Calculator calculator = new Calculator();
        calculator.add("");
    }

    @Test
    void addMethodReturnsZeroWhenInputIsEmpty() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
    }

}
