package nl.acme.koken.io.redirect;

import nl.acme.koken.assertion.Assertion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class App {

    public static void main(String[] args) {
        redirectStdoutToByteArrayOutputStream();
    }

    public static void redirectStdoutToByteArrayOutputStream() {
        // Save current state
        PrintStream console = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        System.out.println("Line 1.");
        System.out.println("Line 2.");
        System.out.println("Line 3.");

        System.setOut(console);

        String[] splitted = baos.toString().split(String.format("%n"));
        Assertion.equals("Line 1.", splitted[0]);
        Assertion.equals("Line 2.", splitted[1]);
        Assertion.equals("Line 3.", splitted[2]);
    }
}