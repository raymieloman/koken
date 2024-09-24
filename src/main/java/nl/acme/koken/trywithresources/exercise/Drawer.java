package nl.acme.koken.trywithresources.exercise;

import java.util.*;

public class Drawer implements AutoCloseable {
    private Set<String> articles = new HashSet<>();
    private boolean open = true;

    public void add(String name) {
        articles.add(name);
    }

    public int size() {
        return articles.size();
    }

    @Override
    public void close() {
        System.out.println("Drawer is successfully closed");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}