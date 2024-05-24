package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Inscription;

import java.util.List;

public interface IInscription {
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    List<Inscription> getAllInscriptions();
    Inscription getInscriptionById(Long numInscrit);
    void deleteInscription(Long numInscrit);
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSk);
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, long numCours);
}
