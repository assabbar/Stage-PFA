

package ma.chu.CHU_emergency.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ma.chu.CHU_emergency.enums.StatutInterconsultation;


import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "interconsultations")
public class Interconsultation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInterconsultation")
    private Long idInterconsultation;


    @Column(name = "demande", columnDefinition = "TEXT")
    private String demande;


    @Column(name = "dateDemande")
    private String dateDemande;


    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutInterconsultation statut;


    @Column(name = "urgent")
    private boolean urgent;


    @ManyToOne
    @JoinColumn(name = "ServiceDestinataire", referencedColumnName = "codeService")
    private HopitalService serviceDestinataire;


    @ManyToOne
    @JoinColumn(name = "MedecinDemandeur", referencedColumnName = "codeMedecin")
    private Medecin medecinDemandeur;


    @ManyToOne
    @JoinColumn(name = "IP", referencedColumnName = "idPatient")
    private Patient patient;


    @OneToMany(mappedBy = "interconsultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
}