package ma.chu.CHU_emergency.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatutInterconsultation {
    EN_SUIVI("En Suivi"),
    EN_INSTANCE("En Instance"),
    CLOTUREE("Clôturée");

    private final String label;

    StatutInterconsultation(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}