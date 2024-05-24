package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Moniteur;

import java.util.List;

public interface IMoniteur {
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur(Moniteur moniteur);
    List<Moniteur> getAllMoniteurs();
    Moniteur getMoniteurById(Long numMoniteur);
    void deleteMoniteur(Long numMoniteur);

    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, long numCour);
}
