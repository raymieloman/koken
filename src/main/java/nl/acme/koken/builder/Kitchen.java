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

    private Kitchen(KitchenBuilder builder) {
        this.gasfornuis = builder.gasfornuis;
        this.kookstel = builder.kookstel;
        this.color = builder.color;
    }

    public static class KitchenBuilder {
        private String gasfornuis;
        private String kookstel;
        private Color color;

        public KitchenBuilder(String gasfornuis) {
            this.gasfornuis = gasfornuis; // de verplichte velden van het te maken domeinobject moeten hier in de constructor.
        }

        public KitchenBuilder kookstel(String kookstel) {
            this.kookstel = kookstel;
            return this;
        }

        public KitchenBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public Kitchen build() {
            return new Kitchen(this);
        }
    }
}
