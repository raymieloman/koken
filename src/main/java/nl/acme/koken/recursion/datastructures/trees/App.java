package nl.acme.koken.recursion.datastructures.trees;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.put(3);
        tree.put(1);
        tree.put(5);


        System.out.println(tree.contains(5));
        System.out.println(tree.contains(88));

        tree.printInorder();
    }
}
