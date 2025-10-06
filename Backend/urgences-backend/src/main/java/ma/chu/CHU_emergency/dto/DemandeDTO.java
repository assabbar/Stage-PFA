package ma.chu.CHU_emergency.dto;

public class DemandeDTO {
    private String texte;
    private String date;

    public DemandeDTO() {}

    public DemandeDTO(String texte, String date) {
        this.texte = texte;
        this.date = date;
    }

    // Getters & Setters
    public String getTexte() { return texte; }
    public void setTexte(String texte) { this.texte = texte; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
