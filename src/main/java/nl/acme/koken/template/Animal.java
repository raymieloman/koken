package nl.acme.koken.template;

public abstract class Animal {

    private String name;


    public void walk() {
        System.out.println("Walking animal");
    }

    public abstract void sound();
}
