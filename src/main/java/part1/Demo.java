package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        // Streams

        // 1- Iterating over a collection
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printListElements(numbers);
        printListElementsUsingStreams(numbers);
        printListElementsUsingStreamsAndMethodReference(numbers);

        // 2- Filtering
        filterListElements(numbers);
        filterListElementUsingStreams(numbers);
        filterListElementUsingStreamsWithMultipleFilter(numbers);

        // Question 1
        // creates a list of numbers from -1000 to 1001
        List<Integer> numbers2 = IntStream.range(-200, 200).boxed().collect(Collectors.toList());
        printNumbersDivisibleBy7AndEitherLowerThanMinus100orGreaterThan100(numbers2);

        // Question 2
        // creates a list and set of strings
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("abd");
        strings.add("bcd");
        strings.add("cde");
        strings.add("def");
        Set<String> set = Set.of("abc", "cde", "def");
        printStringsThatGivenSetContainsAndStartsWithGivenPrefix(strings, set, "de");
    }

    // iterating over a collection
    private static void printListElements(List<Integer> elements) {
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    private static void printListElementsUsingStreams(List<Integer> elements) {
        elements.stream().forEach(element -> System.out.println(element));
    }

    private static void printListElementsUsingStreamsAndMethodReference(List<Integer> elements) {
        elements.stream().forEach(System.out::println);
    }

    // filtering
    private static void filterListElements(List<Integer> elements) {
        for (Integer element : elements) {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }
    }

    private static void filterListElementUsingStreams(List<Integer> elements) {
        elements.stream().filter(element -> element % 2 == 0).forEach(System.out::println);
    }

    private static void filterListElementUsingStreamsWithMultipleFilter(List<Integer> elements) {
        elements.stream()
                .filter(element -> element % 2 == 0)
                .filter(element -> element > 5)
                .forEach(System.out::println);
    }

    private static void printNumbersDivisibleBy7AndEitherLowerThanMinus100orGreaterThan100(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 7 == 0)
                .filter(number -> number > 100 || number < -100)
                .forEach(System.out::println);
    }

    private static void printStringsThatGivenSetContainsAndStartsWithGivenPrefix(List<String> string, Set<String> set, String prefix) {
        string.stream()
                .filter(s -> s.startsWith(prefix))
                .filter(set::contains)
                .forEach(System.out::println);
    }
}
