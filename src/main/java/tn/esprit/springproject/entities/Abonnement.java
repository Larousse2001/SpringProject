package tn.esprit.springproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import tn.esprit.springproject.TypeAbonnement;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Abonnement implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long numAbon;
    private LocalDate dateDeb;
    private LocalDate dateFin;
    private float prix;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;
}
