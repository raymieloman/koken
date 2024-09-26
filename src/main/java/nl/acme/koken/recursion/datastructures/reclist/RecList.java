package nl.acme.koken.recursion.datastructures.reclist;

public class RecList <T> {

    private T head;
    private RecList<T> tail;

    public void add(T value) {
        if(head == null) {
            head = value;
            tail = new RecList<>();
        } else {
            tail.add(value);
        }
    }

    public void pp() {
        if (head != null) {
            System.out.println(head);
            tail.pp();
        }
    }

    public int size() {
        if(head == null) {
            return 0;
        } else {
            return 1 + tail.size();
        }
    }
}
