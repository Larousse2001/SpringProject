package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.TypeAbonnement;
import tn.esprit.springproject.entities.Abonnement;
import tn.esprit.springproject.services.IAbonnementService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AbonnementRestController {
    private final IAbonnementService abonnementService;

    @PostMapping("/addAbonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return abonnementService.addAbonnement(abonnement);
    }

    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement){
        return abonnementService.updateAbonnement(abonnement);
    }

    @GetMapping("/getAllAbonnements")
    public List<Abonnement> getAllAbonnements(){
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/getAbonnementById/{numAbon}")
    public Abonnement getAbonnementById(@PathVariable Long numAbon){
        return abonnementService.getAbonnementById(numAbon);
    }

    @DeleteMapping("/deleteAbonnement/{numAbon}")
    public void deleteAbonnement(@PathVariable Long numAbon){
        abonnementService.deleteAbonnement(numAbon);
    }

    @GetMapping("/retrieveByTypeAbonnement/{typeAbonnement}")
    public List<Abonnement> retrieveByTypeAbonnement(@PathVariable TypeAbonnement typeAbonnement){
        return abonnementService.retrieveByTypeAbonnement(typeAbonnement);
    }
}
