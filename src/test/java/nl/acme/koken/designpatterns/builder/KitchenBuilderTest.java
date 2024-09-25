package nl.acme.koken.designpatterns.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class KitchenBuilderTest {

    @Test
    public void testKitchenBuilder() {
        Kitchen.KitchenBuilder kitchenBuilder = new Kitchen.KitchenBuilder("gasfornuisName");
        kitchenBuilder.color(Color.BLUE).kookstel("Husqvarna");

        Kitchen kitchen = kitchenBuilder.build();
        Assertions.assertEquals("gasfornuisName", kitchen.getGasfornuis());
        Assertions.assertEquals(Color.BLUE, kitchen.getColor());
        Assertions.assertEquals("Husqvarna", kitchen.getKookstel());

        // fluent api
        Kitchen anotherKitchen = new Kitchen.KitchenBuilder("aap").kookstel("noot").color(Color.RED).build();
    }
}
