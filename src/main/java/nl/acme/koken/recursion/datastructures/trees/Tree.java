package nl.acme.koken.recursion.datastructures.trees;

public class Tree <T extends Comparable<T>> {

    private T value;
    private Tree<T> left;
    private Tree<T> right;

    public void put(T t) {
        if(t == null) return;
        if(value == null) {
            value = t;
            left = new Tree<>();
            right = new Tree<>();
        } else {
            if(t.compareTo(value) < 0) {
                left.put(t);
            } else {
                right.put(t);
            }
        }
    }

    public boolean contains(T t) {
        // Simplest case, no data
        if (this.value == null) return false;
        // Simpler case, data check for equality
        if (this.value.equals(t)) return true;
        // reduce the problem and invoke a recursive call
        if (t.compareTo(this.value) < 0) {
            return left.contains(t);
        } else {
            return right.contains(t);
        }
    }

    public void printInorder() {
        if(value != null) {
            left.printInorder();
            System.out.println(value);
            right.printInorder();
        }
    }
}
