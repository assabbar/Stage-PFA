package ma.chu.CHU_emergency.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Long idMessage;


    @Column(name = "message", columnDefinition = "TEXT")
    private String message;


    @Column(name = "dateMessage")
    private String dateMessage;


    @Column(name = "codeMedecin")
    private String codeMedecin; // Clé logique (non liée à une entité ici, mais stockée)


    @ManyToOne
    @JoinColumn(name = "idInterconsultation", referencedColumnName = "idInterconsultation", nullable = false)
    private Interconsultation interconsultation;
}