package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.TypeAbonnement;
import tn.esprit.springproject.entities.Cours;
import tn.esprit.springproject.entities.Inscription;
import tn.esprit.springproject.entities.Piste;
import tn.esprit.springproject.entities.Skieur;
import tn.esprit.springproject.repositories.CoursRepository;
import tn.esprit.springproject.repositories.InscriptionRepository;
import tn.esprit.springproject.repositories.PisteRepository;
import tn.esprit.springproject.repositories.SkieurRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SkieurServiceIMP implements ISkieur{
    private SkieurRepository skieurRepository;
    private PisteRepository pisteRepository;
    private CoursRepository coursRepository;
    private InscriptionRepository inscriptionRepository;
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> getAllSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur getSkieurByID(Long numSK) {
        return skieurRepository.findById(numSK).orElse(null);
    }

    @Override
    public void deleteSkieur(Long numSK) {
        skieurRepository.deleteById(numSK);
    }

    @Override
    public Skieur getSkByNom(String nom) {
        return skieurRepository.findByNomSK(nom);
    }

    @Override
    public Skieur assignSkieurToPiste(long numSk, long numPiste) {
        Skieur sk = skieurRepository.findById(numSk).orElse(null);
        Piste p = pisteRepository.findById(numPiste).orElse(null);
        try {
            sk.getPisteSet().add(p);
        }
        catch(NullPointerException e) {
            Set <Piste> pisteSet = new HashSet<>();
            pisteSet.add(p);
            sk.setPisteSet(pisteSet);
        }
        return skieurRepository.save(sk);
    }

    @Override
    public Skieur assignSkieurToCours(Skieur Sk, long numCours) {
        Skieur savedSkieur = skieurRepository.save(Sk);
        Cours c = coursRepository.findById(numCours).orElse(null);
        Set<Inscription> inscriptionSet = savedSkieur.getInscriptionSet();
        for(Inscription inscription: inscriptionSet) {
            inscription.setSkieur(savedSkieur);
            inscription.setCours(c);
            inscriptionRepository.save(inscription);
        }
        return skieurRepository.save(Sk);
    }

    @Override
    public List<Skieur> retrieveSkieurBytypeAbonnement(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbonnement(typeAbonnement);
    }
}
