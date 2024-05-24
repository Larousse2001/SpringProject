package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Support;
import tn.esprit.springproject.entities.Cours;
import tn.esprit.springproject.entities.Inscription;
import tn.esprit.springproject.entities.Skieur;
import tn.esprit.springproject.repositories.CoursRepository;
import tn.esprit.springproject.repositories.InscriptionRepository;
import tn.esprit.springproject.repositories.SkieurRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InscriptionService implements IInscription {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscriptionById(Long numInscrit) {
        return inscriptionRepository.findById(numInscrit).orElse(null);
    }

    @Override
    public void deleteInscription(Long numInscrit) {
        inscriptionRepository.deleteById(numInscrit);
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSk) {
        Skieur skieur = skieurRepository.findById(numSk).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, long numCours) {
        Cours cours = coursRepository.findById(numCours).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numMoniteur, Support support) {
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur, support);
    }
}
