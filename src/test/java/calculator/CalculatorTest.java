package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(0, calculator.add(""), "Add method should return 0 when input is an empty string.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"6", "3,3", "2,2,2"})
    void addMethodHandlesUnknownAmountsOfInput(String unknownAmountOfInputs) {
        assertEquals(6, calculator.add(unknownAmountOfInputs), "Add method should return sum of input regardless of the amount of inputs.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"//[*][%]\n1*2%3", "//[*][%][#]\n1*2%3", "1\n2,3", "6\n,", "//;\n1;5", "//[***]\n1***2***3", "//[**][%%%%]\n1**2%%%%3", "//[****][%][###]\n1****2%2###1"})
    void addMethodHandlesAllDelimiterScenarios(String DifferentDelimiters) {
        assertEquals(6, calculator.add(DifferentDelimiters), "Add method should be able to handle different delimiters in same input");
    }

    @Test
    void negativeInputsThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> calculator.add("-5,-1"), "Add method should throw an IllegalArgumentException when input contains negative numbers.");
    }

    @Test
    void addMethodIgnoresNumbersBiggerThan1000() {
        assertEquals(10, calculator.add("1200,5,5"), "Add method should ignore numbers above 1000");
    }

    @Test
    void addMethodCanHandleSpacesInInput() {
        assertEquals(10, calculator.add("5, 5"), "Add method should be able to handle spaces in the input");
    }

}
