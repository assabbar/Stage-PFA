package ma.chu.CHU_emergency.dto;

public class MessageDTO {
    private String nomMedecin;
    private String texte;
    private String date;

    public MessageDTO() {}

    public MessageDTO(String nomMedecin, String texte, String date) {
        this.nomMedecin = nomMedecin;
        this.texte = texte;
        this.date = date;
    }

    // Getters & Setters
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }

    public String getTexte() { return texte; }
    public void setTexte(String texte) { this.texte = texte; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
