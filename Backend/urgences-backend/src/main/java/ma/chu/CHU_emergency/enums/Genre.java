package ma.chu.CHU_emergency.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genre {
    HOMME("Homme"),
    FEMME("Femme");

    private final String label;

    Genre(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
