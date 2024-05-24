package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.TypeAbonnement;
import tn.esprit.springproject.entities.Abonnement;
import tn.esprit.springproject.repositories.AbonnementRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AbonnementService implements IAbonnementService {
    private final AbonnementRepository abonnementRepository;

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement getAbonnementById(Long numAbon) {
        return abonnementRepository.findById(numAbon).orElse(null);
    }

    @Override
    public void deleteAbonnement(Long numAbon) {
        abonnementRepository.deleteById(numAbon);
    }

    @Override
    public List<Abonnement> retrieveByTypeAbonnement(TypeAbonnement typeAbonnement) {
        return abonnementRepository.findByTypeAbonnement(typeAbonnement);
    }
}
