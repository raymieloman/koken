package nl.acme.koken.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("ingredients.txt"))) {
            String ingredient;
            int counter = 0;
            while ((ingredient = br.readLine()) != null) {
                System.out.printf("%d) %s%n", ++counter, ingredient);
            }
        }
    }
}
