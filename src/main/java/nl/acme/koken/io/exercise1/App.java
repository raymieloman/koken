package nl.acme.koken.io.exercise1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {

    public static final String fileName = "myfood.txt";
    public static final List<String> foodList = Arrays.asList("Potatoes", "Hamburger", "Milk");

    public static void main(String[] args) throws IOException {
        createFile(fileName);
        readFile(fileName);
        Files.delete(Paths.get(fileName));
    }

    public static void createFile(String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (var food : foodList) {
                writer.write(food);
                writer.newLine();
            }
        }
    }
    
    public static void readFile(String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().forEach(System.out::println);
        }
    }
}
