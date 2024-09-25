package nl.acme.koken.designpatterns.template;

public abstract class Animal {

    private String name;


    public void walk() {
        System.out.println("Walking animal");
    }

    public abstract void sound();
}
