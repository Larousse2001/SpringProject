package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Moniteur;
import tn.esprit.springproject.entities.Skieur;
import tn.esprit.springproject.services.IMoniteur;

import java.util.List;

@RestController
@AllArgsConstructor
public class MoniteurRestController {
    private final IMoniteur moniteurService;

    @PostMapping("/addMoniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/updateMoniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @GetMapping("/getAllMoniteurs")
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.getAllMoniteurs();
    }

    @GetMapping("/getMoniteurById/{numMoniteur}")
    public Moniteur getMoniteurById(@PathVariable Long numMoniteur) {
        return moniteurService.getMoniteurById(numMoniteur);
    }

    @DeleteMapping("/deleteMoniteur/{numMoniteur}")
    public void deleteMoniteur(@PathVariable Long numMoniteur) {
        moniteurService.deleteMoniteur(numMoniteur);
    }

    @PostMapping("/addMoniteurAndAssignToCours/{numCour}")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur, @PathVariable long numCour) {
        return moniteurService.addMoniteurAndAssignToCours(moniteur, numCour);
    }
}
