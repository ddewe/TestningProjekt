package calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

    public int add(String numbers) {
        if (numbers.length() == 0) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);

        numbers = ReturnRefactoredString(numbers);

        int[] intList = Stream.of(numbers.split(",")).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(intList).sum();
    }

    private String ReturnRefactoredString(String numbers) {

        if (numbers.startsWith("//")) {
            String delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.replace(delimiter, ",");
            numbers = numbers.substring(4);
        }

        numbers = numbers.replace("\n", ",");
        return numbers;
    }
}
