package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.TypeAbonnement;
import tn.esprit.springproject.entities.Abonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    public List<Abonnement> findByTypeAbonnement(TypeAbonnement typeAbonnement);
    public List<Abonnement> findByDateDebBetween(LocalDate date1, LocalDate date2);
}
