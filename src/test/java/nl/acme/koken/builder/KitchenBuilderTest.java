package nl.acme.koken.builder;

import org.junit.jupiter.api.Assertions;

import java.awt.*;

public class KitchenBuilderTest {

    public void testKitchenBuilder() {
        Kitchen.KitchenBuilder kitchenBuilder = new Kitchen.KitchenBuilder("gasfornuisName");
        kitchenBuilder.color(Color.BLUE).kookstel("Husqvarna");

        Kitchen kitchen = kitchenBuilder.build();
        Assertions.assertEquals("gasfornuisName", kitchen.getGasfornuis());
        Assertions.assertEquals(Color.BLUE, kitchen.getColor());
        Assertions.assertEquals("Husqvarna", kitchen.getKookstel());
    }
}
