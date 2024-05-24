package tn.esprit.springproject.services;


import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.springproject.entities.Skieur;

import java.util.List;

public interface ISkieur {
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public List<Skieur> getAllSkieur();
    public Skieur getSkieurByID(Long numSK);
    public void deleteSkieur(Long numSK);
    public Skieur getSkByNom(String nom);
    public Skieur assignSkieurToPiste(long numSk, long numPiste);
    public Skieur assignSkieurToCours(Skieur Sk, long numCours);
}
