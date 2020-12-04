package calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

    public int add(String numbers) {
        if (numbers.length() == 0) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);

        numbers = numbers.replace("\n", ",");

        String[] stringList = numbers.split(",");

        int[] intList = Stream.of(stringList).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(intList).sum();
    }
}
