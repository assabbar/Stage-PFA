package ma.chu.CHU_emergency.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ma.chu.CHU_emergency.enums.Genre;


import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPatient")
    private Long idPatient;


    @Column(name = "nom", nullable = false)
    private String nom;


    @Column(name = "age", nullable = false)
    private int age;


    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interconsultation> interconsultations;
}