package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Cours;
import tn.esprit.springproject.services.ICours;

import java.util.List;

@RestController
@AllArgsConstructor
public class CoursRestController {
    private final ICours coursService;

    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }

    @GetMapping("/getAllCours")
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    @GetMapping("/getCoursById/{numCours}")
    public Cours getCoursById(@PathVariable Long numCours) {
        return coursService.getCoursById(numCours);
    }

    @DeleteMapping("/deleteCours/{numCours}")
    public void deleteCours(@PathVariable Long numCours) {
        coursService.deleteCours(numCours);
    }
}
