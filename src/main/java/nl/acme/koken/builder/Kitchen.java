package nl.acme.koken.builder;

import lombok.Data;
import lombok.ToString;

import java.awt.*;

@Data
@ToString(callSuper = true)
public class Kitchen {

    private String gasfornuis;
    private String kookstel;
    private Color color;

    public static class KitchenBuilder {
        private String gasfornuis;
        private String kookstel;
        private Color color;

        public KitchenBuilder(String gasfornuis) {
            this.gasfornuis = gasfornuis; // de verplichte velden van het te maken domeinobject moeten hier in de constructor.
        }


    }
}
