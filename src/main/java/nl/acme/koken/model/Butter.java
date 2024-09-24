package nl.acme.koken.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Butter extends Ingredient {

    Butter() {}
}
