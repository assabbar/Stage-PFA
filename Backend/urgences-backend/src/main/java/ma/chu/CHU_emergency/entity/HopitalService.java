package ma.chu.CHU_emergency.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "services")
public class HopitalService {


    @Id
    @Column(name = "codeService")
    private String codeService; // Clé primaire logique


    @Column(name = "idService", unique = true, insertable = false, updatable = false)
    private Long idService; // auto-incrémenté par SQL Server


    @Column(name = "nomService", nullable = false)
    private String nomService;


    @OneToMany(mappedBy = "serviceDemandeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medecin> medecins;


    @OneToMany(mappedBy = "serviceDestinataire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interconsultation> interconsultations;
}