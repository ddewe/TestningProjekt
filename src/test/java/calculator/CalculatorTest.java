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

    @Test
    void addMethodHandlesNewLineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"), "Add method should be able to handle New Line as a delimiter.");
    }

    @Test
    void addMethodHandlesNewLineDelimiterAndComma() {
        assertEquals(1, calculator.add("1\n,"), "Add method should be able to handle input even when it contains both New Line and commas");
    }

    @Test
    void addMethodHandlesDifferentDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"), "Add method should be able to handle different delimiters");
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
    void delimitersCanBeOfAnyLength() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"), "Add method should be able to handle delimiters of any length");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[*][%]\n1*2%3", "//[*][%][#]\n1*2%3"})
    void AddMethodHandlesMultipleDelimiters(String multipleDelimiters) {
        assertEquals(6, calculator.add(multipleDelimiters), "Add method should be able to handle different delimiters in same input");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[**][%%%%]\n1**2%%%%3", "//[****][%][###]\n1****2%2###1"})
    void MultipleDelimitersCanBeOfAnyLength(String unknownLengthDelimiters) {
        assertEquals(6, calculator.add(unknownLengthDelimiters), "Add method should be able to handle unknown amounts of delimiters of unknown length");
    }

    @Test
    void addMethodCanHandleSpacesInInput() {
        assertEquals(10, calculator.add("5, 5"), "Add method should be able to handle spaces in the input");
    }

}
