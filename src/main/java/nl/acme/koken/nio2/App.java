package nl.acme.koken.nio2;

import nl.acme.koken.assertion.Assertion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        getFileFromPath();
        iterateOverPathUsingList();
        iterateOverPathUsingStream();
        checkSomeAttr();
        fiddleWithFileDate();
        iterateOverDirectoryAndDirectories();
    }

    private static void getFileFromPath() {
        Path footballResults = Paths.get("footballresults.txt");
        File file = footballResults.toFile(); // for legacy use for Java IO ...
        Assertion.equals("footballresults.txt", file.getName());
    }

    private static void iterateOverPathUsingList() throws IOException {
        Path footballResults = Paths.get("footballresults.txt");

        final List<String> lines = Files.readAllLines(footballResults);
        lines.forEach(System.out::println);
    }

    private static void iterateOverPathUsingStream() throws IOException {
        Path footballResults = Paths.get("footballresults.txt");

        Files.readAllLines(footballResults).stream()
                .filter(l -> l.contains("Heracles"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }


    private static void checkSomeAttr() throws IOException {
        Path footballResults = Paths.get("footballresults.txt");

        Assertion.ensure(Files.isRegularFile(footballResults), " someFile (footballresults.txt) should be a regular file here");
        Assertion.ensure(!Files.isSymbolicLink(footballResults), "someFile should NOT be a symbolic link here");
        System.out.println("The length of the football file is: " + Files.size(footballResults));
    }

    private static void fiddleWithFileDate() throws IOException {
        Path footballResults = Paths.get("footballresults.txt");

        // print the file date
        System.out.println(Files.getLastModifiedTime(footballResults).toMillis());
        System.out.println(new Date(Files.getLastModifiedTime(footballResults).toMillis()));

        // touch the file (Linux:   $ touch footballresults.txt)
        Files.setLastModifiedTime(footballResults, FileTime.fromMillis(System.currentTimeMillis()));

        // print the file date
        System.out.println(Files.getLastModifiedTime(footballResults).toMillis());
        System.out.println(new Date(Files.getLastModifiedTime(footballResults).toMillis()));
    }


    private static void iterateOverDirectoryAndDirectories() throws IOException {
        // list all java files in a certain directory
        Path src = Paths.get("src/main/java");
        System.out.println(src.toAbsolutePath());

        // iterate over files in directory
        // one level deep ... hence nothing ...
        try (Stream<Path> files = Files.list(src)) {
            files.filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .filter(p -> p.endsWith(".java"))
                    .peek(n -> {
                        Assertion.fail("Should not be here since not expected java files in this src/main/java dir");
                    })
                    .forEach(System.out::println);

            // deep(er) recursively iterate over files and subdirectories
            try (Stream<Path> walker = Files.walk(src)) {
                walker.filter(p -> !Files.isDirectory(p))
                        .map(p -> p.toAbsolutePath())
                        .forEach(System.out::println);
            }

            // deep(er)
            try (Stream<Path> walker = Files.walk(src)) {
                long amountOfFiles =
                        walker.filter(p -> !Files.isDirectory(p))
                                .count();
                System.out.printf("There are %d .java files in this project%n", amountOfFiles);
            }
        }
    }
}