package nl.acme.koken.navigable;

import nl.acme.koken.assertion.Assertion;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        NavigableSet<String> treinTijden = new TreeSet<>();

        // tijden ingevoerd door de NS
        treinTijden.add("1015");
        treinTijden.add("1030");
        treinTijden.add("1045");

        // Ik wil met de trein en het is nu 10:20
        String time = treinTijden.higher("1020");
        Assertion.equals("1030", time);

        System.out.print("== HeadSet: =>");
        SortedSet<String> headSet = treinTijden.headSet("1022");
        System.out.println(headSet);
        Assertion.ensure(headSet.contains("1015"));

        System.out.print("== TailSet: =>");
        SortedSet<String> tailSet = treinTijden.tailSet("1022");
        System.out.println(tailSet);
        Assertion.ensure(tailSet.contains("1030"));
        Assertion.ensure(tailSet.contains("1045"));

        time = treinTijden.lower("1020");
        Assertion.equals("1015", time);
        System.out.println(time);
    }
}