package nl.acme.koken.trywithresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        // Reader is closed!
    }
}
