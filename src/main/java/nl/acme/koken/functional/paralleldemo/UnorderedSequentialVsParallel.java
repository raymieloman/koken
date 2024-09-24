package nl.acme.koken.functional.paralleldemo;

import java.util.List;

public class UnorderedSequentialVsParallel {
    // See OCP-17 book page 765 before showing this example
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Demo skip 5 from a serial or parallel stream");
        demoSkip5Serial();
        System.out.println();
        demoSkip5Parallel();
        System.out.println();
        System.out.println();
        System.out.println("Demo use Thread sleep ordered sequential vs ordered parallel stream");
        demoUnorderedSequential();
        demoUnorderedParallel();
    }

    private static void demoSkip5Serial() {
        // stream().unordered keeps order (skip 5 skips first five elements)
        System.out.printf("%10s", "Serial: ");
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).stream().unordered().skip(5).forEach(System.out::print);
    }

    private static void demoSkip5Parallel() {
        // stream().unordered.parallel() might distort order (skip 5 skips five random elements)
        System.out.printf("%10s", "Parallel: ");
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).stream().unordered().parallel().skip(5).forEach(System.out::print);
    }

    // unordered.parallel is/might be faster but that is especially the case for more difficult calculation per iteration of the stream
    private static void demoUnorderedSequential() {
        System.out.printf("%10s", "Serial: ");
        long startTime = System.nanoTime();
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).stream().unordered().peek(n -> {
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::print);
        long stopTime = System.nanoTime();
        System.out.println();
        System.out.println("Time: " + (stopTime - startTime));
    }

    // unordered.parallel is/might be faster but that is especially the case for more difficulter calculation per iteration of the stream
    private static void demoUnorderedParallel() {
        System.out.printf("%10s", "Parallel: ");
        long startTime = System.nanoTime();
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).stream().unordered().parallel().peek(n -> {
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::print);
        long stopTime = System.nanoTime();
        System.out.println();
        System.out.println("Time: " + (stopTime - startTime));
    }
}
