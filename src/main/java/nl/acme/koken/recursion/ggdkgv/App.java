package nl.acme.koken.recursion.ggdkgv;

import nl.acme.koken.assertion.Assertion;

public class App {

    public static void main(String[] args) {
        Assertion.equals(3, ggd(9, 6));
        Assertion.equals(9, ggd(27, 18));
        Assertion.equals(300, kgv(100, 30));
    }

    public static int ggd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return ggd(m, n % m);
    }

    public static int kgv(int n, int m) {
        return n*m/ggd(n, m);
    }
}
