package nl.acme.koken.designpatterns.factoryusecase;

import nl.acme.koken.model.Ingredient;
import nl.acme.koken.model.IngredientFactory;

public class App {
    public static void main(String[] args) {
        Ingredient butter = IngredientFactory.createBoter();
        Ingredient ui = IngredientFactory.createUi(3);
        System.out.println(butter);
        System.out.println(ui);
    }
}
