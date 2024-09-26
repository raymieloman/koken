package nl.acme.koken.trywithresources.exercise;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Drawer implements AutoCloseable {
    private Set<String> articles = new HashSet<>();
    @Getter
    private boolean open = true;

    public void add(String name) {
        articles.add(name);
    }

    public int size() {
        return this.articles.size();
    }

    @Override
    public void close() {
        System.out.println("Drawer is successfully closed");
        open = false;
    }
}