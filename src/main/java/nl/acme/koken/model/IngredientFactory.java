package nl.acme.koken.model;

import java.awt.*;

public final class IngredientFactory {
    public static Ingredient createBoter() {
        Butter boter = new Butter();
        boter.setColor(Color.GRAY);
        boter.setTaste("Fat");
        boter.setWeight(33.0);

        return boter;
    }

    public static Ingredient createUi(int strongness) {
        Onion ui = new Onion();
        ui.setStrongness(strongness);

        return ui;
    }

    // Utility class
    private IngredientFactory() {

    }
}
