package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Piste;
import tn.esprit.springproject.services.IPiste;

import java.util.List;

@RestController
@AllArgsConstructor
public class PisteRestController {
    private final IPiste pisteService;

    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/getAllPistes")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    @GetMapping("/getPisteById/{numPiste}")
    public Piste getPisteById(@PathVariable Long numPiste) {
        return pisteService.getPisteById(numPiste);
    }

    @DeleteMapping("/deletePiste/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.deletePiste(numPiste);
    }
}
