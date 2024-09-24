package nl.acme.koken.binarysearch;

import nl.acme.koken.assertion.Assertion;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11}; // Sorted array

        // Search for a value in the array
        int index = Arrays.binarySearch(numbers, 7);
        Assertion.equals(3, index);

        // If the value is found, it will return the index
        if (index >= 0) {
            System.out.println("Found 7 at index: " + index);
        } else {
            System.out.println("7 not found. Insertion point: " + (-index - 1));
        }
        // non existing
        index = Arrays.binarySearch(numbers, 6);
        Assertion.equals(-4, index);
    }
}