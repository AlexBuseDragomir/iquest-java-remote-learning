package main;

import utility.StreamUtility;

import java.util.stream.Stream;

public class MainLauncher {

    public static void main(String[] args) {

        Stream<Integer> first = Stream.of(1, 3, 5, 7, 9);
        System.out.println("First stream values are: " + "1, 3, 5, 7, 9");
        Stream<Integer> second = Stream.of(2, 4, 6, 8, 10, 12, 14, 16);
        System.out.println("Second stream values are: " + "2, 4, 6, 8, 10, 12, 14, 16");

        Stream<Integer> result = StreamUtility.zip(first, second);

        System.out.println();
        System.out.println("Resulting stream:");
        result.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
