package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Cours;
import tn.esprit.springproject.entities.Moniteur;
import tn.esprit.springproject.repositories.CoursRepository;
import tn.esprit.springproject.repositories.MoniteurRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class MoniteurService implements IMoniteur {
    private final MoniteurRepository moniteurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public List<Moniteur> getAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur getMoniteurById(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public void deleteMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }

    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, long numCour) {
        Cours cours = coursRepository.findById(numCour).orElse(null);
        Set<Cours> coursSet = new HashSet<>();
        coursSet.add(cours);
        moniteur.setCoursSet(coursSet);
        return moniteurRepository.save(moniteur);
    }
}
