package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Skieur;
import tn.esprit.springproject.services.ISkieur;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkieurRestControlleur {
    private ISkieur iSkieur;

    @PostMapping("/addSK")
    public Skieur addSK(@RequestBody Skieur skieur){
        return iSkieur.addSkieur(skieur);
    }
    @PutMapping("/updateSK")
    public Skieur updateSK (@RequestBody Skieur skieur){
        return iSkieur.updateSkieur(skieur);
    }
    @GetMapping("/getAllSkieur")
    public List<Skieur> getAllSkieur(){
        return iSkieur.getAllSkieur();
    }
    @GetMapping("/getSkieurByID/{numSK}")
    public Skieur getSkieurByID(@PathVariable Long numSK){
        return iSkieur.getSkieurByID(numSK);

    }
    @DeleteMapping("/deleteSK/{numSK}")
    public void delete(@PathVariable Long numSK){
        iSkieur.deleteSkieur((numSK));

    }

    @GetMapping("/getSkByNom/{nom}")
    public Skieur getSkieurByNom(@PathVariable String nom) {
        return iSkieur.getSkByNom(nom);
    }

    @PostMapping("/assignSkieurToPiste/{numSk}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable long numSk, @PathVariable long numPiste) {
        return iSkieur.assignSkieurToPiste(numSk, numPiste);
    }

    @PostMapping("/assignSkieurToCours/{numCours}")
    public Skieur assignSkieurToCours(@RequestBody Skieur Sk, @PathVariable long numCours) {
        return iSkieur.assignSkieurToCours(Sk, numCours);
    }
}