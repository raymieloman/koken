package nl.acme.koken.miscellaneous;

import java.util.ArrayList;
import java.util.List;

// When adding this to the pom.xml, 'mvn clean compile' will warn and will fails since the warnings are marked as 'errors'
/*
  <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                    <showWarnings>true</showWarnings>
                    <compilerArgs>
                        <arg>-Xlint:all,-serial,-processing,-options</arg>-->
                        <arg>-Werror</arg>
                    </compilerArgs>
                </configuration>
            </plugin>
        </plugins>
    </build>
 */
public class SomeWarnings {

    public static void main(String[] args) {
        System.out.println(m());
    }

    public static void demoRawList() {
        List list = new ArrayList();
        list.add("Poedel");
    }

    public static void demoUnnecessaryCast() {
        String s = (String) "Poedel";
    }

    public static void demoDivisionByZero() {
        System.out.println(42/0);
    }

    public static int m() {
        try {
            throw new NullPointerException();
        }  catch (NullPointerException npe) {
            System.err.println("Caught NullPointerException.");
            return 1;
        } finally {
            return 0;
        }
    }
}