package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Cours;

import java.util.List;

public interface ICours {
    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    List<Cours> getAllCours();
    Cours getCoursById(Long numCours);
    void deleteCours(Long numCours);
}
