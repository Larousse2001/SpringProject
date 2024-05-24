package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Piste;

import java.util.List;

public interface IPiste {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    List<Piste> getAllPistes();
    Piste getPisteById(Long numPiste);
    void deletePiste(Long numPiste);
}
