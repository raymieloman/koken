package nl.acme.koken.recursion.fibon;

public class App {

    public static void main(String[] args) {
        int n = fibon(6);
        System.out.println("Fibonacci number 6: " + n);
        System.out.println(fibon(5));
        System.out.println(fibon(10));

    }

    // note: this is a bad algorithm but shows the principle of recursion pretty well!!!
    // Why bad? It makes the calls for every solution twice, see below on the return fibon ... recursive call.
    public static int fibon(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return fibon(n - 2) + fibon(n - 1);
        }
    }
}
