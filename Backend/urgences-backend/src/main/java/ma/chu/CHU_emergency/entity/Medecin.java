package ma.chu.CHU_emergency.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "medecins")
public class Medecin {

    @Id
    @Column(name = "codeMedecin")
    private String codeMedecin; // PK logique (String)

    @Column(name = "idMedecin", unique = true, insertable = false, updatable = false)
    private Long idMedecin; // auto-incrémenté par SQL Server

    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "Service", referencedColumnName = "codeService")
    private HopitalService serviceDemandeur;


    @OneToMany(mappedBy = "medecinDemandeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interconsultation> interconsultations;
}