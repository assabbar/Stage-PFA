package ma.chu.CHU_emergency.dto;

import java.util.List;

public class InterconsultationDTO {
    private String ip;
    private String nom;
    private String genre;
    private int age;
    private String medecinDemandeur;
    private String date;
    private String statut;
    private String serviceDemandeur;
    private String serviceDestinataire;
    private int urgent;
    private DemandeDTO demande;
    private List<MessageDTO> messages;

    public InterconsultationDTO() {}

    public InterconsultationDTO(String ip, String nom, String genre, int age,
                                String medecinDemandeur, String date, String statut,
                                String serviceDemandeur, String serviceDestinataire,
                                int urgent, DemandeDTO demande, List<MessageDTO> messages) {
        this.ip = ip;
        this.nom = nom;
        this.genre = genre;
        this.age = age;
        this.medecinDemandeur = medecinDemandeur;
        this.date = date;
        this.statut = statut;
        this.serviceDemandeur = serviceDemandeur;
        this.serviceDestinataire = serviceDestinataire;
        this.urgent = urgent;
        this.demande = demande;
        this.messages = messages;
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

    public String getMedecinDemandeur() { return medecinDemandeur; }
    public void setMedecinDemandeur(String medecinDemandeur) { this.medecinDemandeur = medecinDemandeur; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public String getServiceDemandeur() { return serviceDemandeur; }
    public void setServiceDemandeur(String serviceDemandeur) { this.serviceDemandeur = serviceDemandeur; }

    public String getServiceDestinataire() { return serviceDestinataire; }
    public void setServiceDestinataire(String serviceDestinataire) { this.serviceDestinataire = serviceDestinataire; }

    public int getUrgent() { return urgent; }
    public void setUrgent(int urgent) { this.urgent = urgent; }

    public DemandeDTO getDemande() { return demande; }
    public void setDemande(DemandeDTO demande) { this.demande = demande; }

    public List<MessageDTO> getMessages() { return messages; }
    public void setMessages(List<MessageDTO> messages) { this.messages = messages; }
}
