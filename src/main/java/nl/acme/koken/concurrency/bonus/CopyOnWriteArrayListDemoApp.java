package nl.acme.koken.concurrency.bonus;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemoApp {
    public static void main(String[] args) {
        List<Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89));

        System.out.println(numbers);

        for (int element : numbers) {
            if (element % 2 == 0 ) {
                if (element < numbers.size()) {
                    numbers.remove(Integer.valueOf(element));
                }

            }
        }
        System.out.println(numbers);
    }
}


