package ma.chu.CHU_emergency.dto;

public class MedecinDTO {
    private String codeMedecin;
    private String nom;
    private String service; // nom du service (lié à HopitalService)

    public MedecinDTO() {}

    public MedecinDTO(String codeMedecin, String nom, String service) {
        this.codeMedecin = codeMedecin;
        this.nom = nom;
        this.service = service;
    }

    // Getters & Setters
    public String getCodeMedecin() { return codeMedecin; }
    public void setCodeMedecin(String codeMedecin) { this.codeMedecin = codeMedecin; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
}
