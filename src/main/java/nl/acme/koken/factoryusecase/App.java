package nl.acme.koken.factoryusecase;

import nl.acme.koken.model.Ingredient;
import nl.acme.koken.model.IngredientFactory;

public class App {
    public static void main(String[] args) {
        Ingredient boter = IngredientFactory.createBoter();
        Ingredient ui = IngredientFactory.createUi(3);
        System.out.println(boter);
        System.out.println(ui);
    }
}
