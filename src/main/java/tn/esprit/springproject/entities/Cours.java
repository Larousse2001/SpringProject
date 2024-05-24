package tn.esprit.springproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.springproject.Support;
import tn.esprit.springproject.TypeCours;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cours implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long numCours;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;
    private float prix;
    private int crenaux;

    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptionSet;
}
