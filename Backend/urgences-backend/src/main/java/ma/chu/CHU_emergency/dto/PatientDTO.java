package ma.chu.CHU_emergency.dto;

public class PatientDTO {
    private String ip;     // correspond à idPatient dans l’entité
    private String nom;
    private String genre;
    private int age;

    public PatientDTO() {}

    public PatientDTO(String ip, String nom, String genre, int age) {
        this.ip = ip;
        this.nom = nom;
        this.genre = genre;
        this.age = age;
    }

    // Getters & Setters
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
