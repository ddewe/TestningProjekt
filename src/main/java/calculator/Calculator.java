package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Calculator {

    private List<Integer> negativeNumbers = new ArrayList<>();
    private String delimiter = "";

    public int add(String numbers) {
        if (numbers.length() == 0) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);


        numbers = ReturnRefactoredString(numbers);

        int[] intList = Stream.of(numbers.split(","))
                .filter(number -> Integer.parseInt(number) < 1000)
                .mapToInt(Integer::parseInt).toArray();

        CheckForNegativeNumbers(intList);

        return Arrays.stream(intList).sum();

    }

    private void CheckForNegativeNumbers(int[] intList) {
        for (Integer number : intList) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            System.out.println("Negatives not allowed: " + negativeNumbers.toString());
            throw new IllegalArgumentException();
        }
    }

    private String ReturnRefactoredString(String numbers) {


        //[,]\n1***2***3
        //[*][%]\n1*2%3

        if (numbers.startsWith("//[")) {
            delimiter = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
            numbers = numbers.replace(delimiter, ",");
            numbers = numbers.substring(numbers.indexOf("]") + 2);

            while (numbers.charAt(1) == ']') {
                delimiter = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
                numbers = numbers.replace(delimiter, ",");
                numbers = numbers.substring(numbers.indexOf("]") + 2);
            }

        }
        else if (numbers.startsWith("//")) {
            delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.replace(delimiter, ",");
            numbers = numbers.substring(4);
        }

        numbers = numbers.replace("\n", ",");

        return numbers;
    }
}
