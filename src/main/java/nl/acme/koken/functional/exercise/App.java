package nl.acme.koken.functional.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class App {

    public static void main(String[] args) {
        Function<Integer, Integer> square = n -> n * n; // can also be an UnaryOperator<...>
        UnaryOperator<Integer> squareAlternate = n -> n * n;

        UnaryOperator<Integer> squareMod2 = n -> (n * n) % 2;


        List<Integer> numbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

        for (Integer number : numbers) {
            System.out.printf("%d => %d%n", number, square.apply(number));
        }

        for (Integer number : numbers) {
            System.out.printf("%d => %d%n", number, square.apply(number));
        }

    }
}
