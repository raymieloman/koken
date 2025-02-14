package nl.acme.koken.functional.unary;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        UnaryOperator<Integer> byTwo = x -> x * 2;
        BinaryOperator<Integer> mul = (x, y) -> x * y;

        System.out.println(byTwo.apply(3));
        System.out.println(mul.apply(3,2));
    }
}
