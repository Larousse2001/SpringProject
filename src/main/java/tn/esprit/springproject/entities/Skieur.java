package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Skieur implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long numSK;
    private String nomSK;
    private String prenomSK;
    private LocalDate dateNaissance;
    private String ville;

    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;

    @OneToMany(mappedBy = "skieur")
    private Set<Inscription> inscriptionSet;

    @ManyToMany
    @JsonIgnore
    private Set<Piste>pisteSet;
}
