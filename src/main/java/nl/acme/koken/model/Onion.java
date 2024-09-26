package nl.acme.koken.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.awt.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Onion extends Ingredient {
    private int strongness;

    Onion() {
        this.setWeight(100.0);
        this.setColor(Color.WHITE);
        this.setTaste("SuperStrong");
    }
}
