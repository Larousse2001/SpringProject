package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Skieur;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    // Create a Keyword = Select * from Skieur where NomSk = Name
    public Skieur findByNomSK(String name);
}
