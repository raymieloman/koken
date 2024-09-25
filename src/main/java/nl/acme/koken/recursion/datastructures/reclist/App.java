package nl.acme.koken.recursion.datastructures.reclist;

public class App {

    public static void main(String[] args) {
        RecList<Integer> recList = new RecList();
        recList.add(5);
        recList.add(10);
        recList.add(15);

        recList.pp();

        System.out.println("Size: " + recList.size());
    }
}
