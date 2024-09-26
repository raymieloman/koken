package nl.acme.koken.model;

import lombok.Data;
import lombok.ToString;

import java.awt.*;


@Data
@ToString
public abstract class Ingredient {
    private String taste;
    private Double weight;
    private Color color;
}
