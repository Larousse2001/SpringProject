package tn.esprit.springproject.services;

import tn.esprit.springproject.TypeAbonnement;
import tn.esprit.springproject.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> getAllAbonnements();
    Abonnement getAbonnementById(Long numAbon);
    void deleteAbonnement(Long numAbon);
    public List<Abonnement> retrieveByTypeAbonnement(TypeAbonnement typeAbonnement);

}
