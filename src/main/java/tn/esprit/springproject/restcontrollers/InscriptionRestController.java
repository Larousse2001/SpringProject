package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Inscription;
import tn.esprit.springproject.entities.Skieur;
import tn.esprit.springproject.services.IInscription;

import java.util.List;

@RestController
@AllArgsConstructor
public class InscriptionRestController {
    private final IInscription inscriptionService;

    @PostMapping("/addInscription")
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }

    @PutMapping("/updateInscription")
    public Inscription updateInscription(@RequestBody Inscription inscription) {
        return inscriptionService.updateInscription(inscription);
    }

    @GetMapping("/getAllInscriptions")
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/getInscriptionById/{numInscrit}")
    public Inscription getInscriptionById(@PathVariable Long numInscrit) {
        return inscriptionService.getInscriptionById(numInscrit);
    }

    @DeleteMapping("/deleteInscription/{numInscrit}")
    public void deleteInscription(@PathVariable Long numInscrit) {
        inscriptionService.deleteInscription(numInscrit);
    }

    @PostMapping("/addInscriptionAndAssignToSkieur/{numSk}")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable long numSk) {
        return inscriptionService.addInscriptionAndAssignToSkieur(inscription, numSk);
    }

    @PostMapping("/addInscriptionAndAssignToCours/{numCours}")
    public Inscription addInscriptionAndAssignToCours(@RequestBody Inscription inscription, @PathVariable long numCours) {
        return inscriptionService.addInscriptionAndAssignToCours(inscription, numCours);
    }
}
