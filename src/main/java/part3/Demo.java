package part3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        System.out.println(getEvenNumbersFromList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(collectEvenNumbersToList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(collectEvenNumbersToSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(collectElementsToMap(List.of("b", "cc", "ddd")));
        System.out.println(collectElementsToMapWithDuplicateKeys(List.of("a", "b", "cc", "ddd")));

        System.out.println(groupElementsByLength(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j")));
        System.out.println(groupElementsByLengthCollectToList(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j")));
        System.out.println(concatStrings(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j")));
        System.out.println(concatStringsWithDelimiter(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j"), "-"));
        System.out.println(partitionByLength(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j"), 3));
        System.out.println(partitionByLengthWithExplicitDownstream(Arrays.asList("abc", "bc", "cd", "def", "eghi", "f", "gij", "h", "i", "j"), 3));

        System.out.println(filterEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(filterEvenNumbersCollecting(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        System.out.println(sumNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(findAverage(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        summarize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        System.out.println(groupNumbersByDigitCountAndMinValue(List.of(2, 3, 7, 14, 16, 20, 25)));

        Map<Integer, Map<Integer, String>> map = new HashMap<>();
        map.put(1, new HashMap<>());
        map.put(2, new HashMap<>());
        map.put(3, new HashMap<>());
        map.get(1).put(11, "111");
        map.get(1).put(12, "112");
        map.get(2).put(21, "211");
        map.get(2).put(22, "212");
        map.get(3).put(31, "311");

        System.out.println(convertNestedValues(map));

        System.out.println(groupWordsByLengthWithSortedValueList(Arrays.asList("a", "b", "ab", "bcd", "abc", "aab", "cbe", "bcdef", "abcde")));
        System.out.println(groupNumbersByDigitCountAndSummingValues(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        System.out.println(groupNumbersByDigitCountAndSummingValuesReducing(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        System.out.println(groupNumbersByDigitCountAndCountOfAssociatedValues(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        System.out.println(partitionAndOrderValues(num -> num % 2 == 0, Arrays.asList(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));

        System.out.println(reduceNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 0));
        System.out.println(groupByListSizeAndEliminateDuplicateValues(List.of(List.of(1,2,3), List.of(3,4,5), List.of(6,7), List.of(7,8))));
    }

    private static List<Integer> getEvenNumbersFromList(List<Integer> list) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : list) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    private static List<Integer> collectEvenNumbersToList(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    private static Set<Integer> collectEvenNumbersToSet(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet());
    }

    private static Map<Integer, String> collectElementsToMap(List<String> list) {
        return list.stream().collect(Collectors.toMap(String::length, String::toUpperCase));
    }

    private static Map<Integer, String> collectElementsToMapWithDuplicateKeys(List<String> list) {
        return list.stream().collect(Collectors.toMap(String::length, String::toUpperCase, (s1, s2) -> s1 + " " + s2));
    }

    private static Map<Integer, List<String>> groupElementsByLength(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(String::length));
    }

    private static Map<Integer, List<String>> groupElementsByLengthCollectToList(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
    }

    private static String concatStrings(List<String> list) {
        return list.stream().filter(s -> s.length() > 2).collect(Collectors.joining());
    }

    private static String concatStringsWithDelimiter(List<String> list, String delimiter) {
        return list.stream().filter(s -> s.length() > 2).collect(Collectors.joining(delimiter));
    }

    private static Map<Boolean, List<String>> partitionByLength(List<String> list, int length) {
        return list.stream().collect(Collectors.partitioningBy(s -> s.length() > length));
    }

    private static Map<Boolean, List<String>> partitionByLengthWithExplicitDownstream(List<String> list, int length) {
        return list.stream().collect(Collectors.partitioningBy(s -> s.length() > length, Collectors.toList()));
    }

    private static List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> filterEvenNumbersCollecting(List<Integer> list) {
        return list.stream().collect(Collectors.filtering(number -> number % 2 == 0, Collectors.toList()));
    }

    private static int sumNumbers(List<Integer> list) {
        return list.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    private static double findAverage(List<Integer> list) {
        return list.stream().collect(Collectors.averagingInt(Integer::intValue));
    }

    private static void summarize(List<Integer> list) {
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(intSummaryStatistics.toString());
    }

    private static Map<Integer, Optional<Integer>> groupNumbersByDigitCountAndMinValue(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(number -> String.valueOf(number).length(), Collectors.minBy(Comparator.naturalOrder())));
    }

    private static Map<Integer, Map<Integer, Integer>> convertNestedValues(Map<Integer, Map<Integer, String>> map) {
        return map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey, // outer key mapper
                outerEntry -> outerEntry.getValue() // outer value mapper
                        .entrySet().stream().collect(Collectors.toMap(
                                Map.Entry::getKey, // inner key mapper
                                innerEntry -> Integer.parseInt(innerEntry.getValue()))))); // outer value mapper
    }

    private static Map<Integer, List<String>> groupWordsByLengthWithSortedValueList(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(
                String::length,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted().collect(Collectors.toList()))));
    }

    private static Map<Integer, Integer> groupNumbersByDigitCountAndSummingValues(List<Integer> numbers) {
        return numbers.stream().collect(
                Collectors.groupingBy(num -> String.valueOf(num).length(),
                        Collectors.summingInt(Integer::intValue)));
    }

    private static Map<Integer, Integer> groupNumbersByDigitCountAndSummingValuesReducing(List<Integer> numbers) {
        return numbers.stream().collect(
                Collectors.groupingBy(num -> String.valueOf(num).length(),
                        Collectors.reducing(0, Integer::intValue, Integer::sum)));
    }

    private static Map<Integer, Long> groupNumbersByDigitCountAndCountOfAssociatedValues(List<Integer> numbers) {
        return numbers.stream().collect(
                Collectors.groupingBy(num -> String.valueOf(num).length(),
                        Collectors.counting()));
    }

    private static <T> Map<Boolean, List<T>> partitionAndOrderValues(Predicate<T> predicate, List<T> numbers) {
        return numbers.stream().collect(
                Collectors.partitioningBy(predicate,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().sorted().collect(Collectors.toList()))));
    }

    private static Integer reduceNumbers(List<Integer> numbers, int initialIdentity) {
        return numbers.stream().collect(Collectors.reducing(initialIdentity, Integer::intValue, Integer::sum));
    }

    private static Map<Integer, Set<Integer>> groupByListSizeAndEliminateDuplicateValues(List<List<Integer>> nestedNumbers) {
        return nestedNumbers.stream().collect(
                Collectors.groupingBy(List::size,
                        Collectors.flatMapping(Collection::stream, Collectors.toSet())));
    }
}
