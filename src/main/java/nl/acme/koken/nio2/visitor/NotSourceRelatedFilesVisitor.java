package nl.acme.koken.nio2.visitor;

import lombok.ToString;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
public class NotSourceRelatedFilesVisitor extends SimpleFileVisitor<Path> {
    public static final String REGEX = "\\.git|target|\\.idea|\\.java";

    private int fileCounter;
    private long size;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(file.toFile().getAbsolutePath());
        if (!matcher.find()) { // find is an occurrence in the String, matches is an exact match. Hence, it's name! :-)
            fileCounter++;
            size += file.toFile().length();
        }

        return FileVisitResult.CONTINUE;
    }
}