package nl.acme.koken.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Butter extends Ingredient {

    Butter() {}
}
