package nl.acme.koken.recursion.fac;

public class App {
    public static void main(String[] args) {
        int facThree = fac(3);
        System.out.println(facThree);
    }

    public static int fac(int n) {
        // simplest case
        if (n == 0) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
