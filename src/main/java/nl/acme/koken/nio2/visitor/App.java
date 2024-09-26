package nl.acme.koken.nio2.visitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        NotSourceRelatedFilesVisitor visitor = new NotSourceRelatedFilesVisitor();
        Files.walkFileTree(Paths.get(""), visitor);

        System.out.println(visitor);
    }
}