package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Enum.Level;
import tn.esprit.spring.entities.Exercise;
import tn.esprit.spring.entities.Person;
import tn.esprit.spring.interfaces.IExamenService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/examen")
@Slf4j
public class ExamenRestController {
    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return examenService.addPerson(person);
    }

    @PostMapping("/addCourseAssignCoach/{personID}")
    public Course addCourseAssignCoach(@RequestBody Course course, @PathVariable("personID") Long personID) {
        return examenService.addCourseAssignCoach(course, personID);
    }

    @GetMapping("/retrieveCourse/{level}/{name}")
    public List<Course> retrieveCourse(@PathVariable("level") Level level,
                                       @PathVariable("name") String name) {
        return examenService.retrieveCourse(level, name);
    }

    @PutMapping("/assignAthleteCourse/{personID}/{num}")
    public Course assignAthleteCourse(@PathVariable("personID") Long personID,
                                      @PathVariable("num") Integer num) {
        return examenService.assignAthleteCourse(personID, num);
    }

    @GetMapping("/retrieveAthlete/{title}")
    public List<Person> retrieveAthlete(@PathVariable("title") String title) {
        return examenService.retrieveAthlete(title);
    }


    @PutMapping("/updateNbReptE")
    public void updateNbReptE() {
        examenService.updateNbReptE();
    }

    IExamenService examenService;

    @GetMapping("/recupererExDifficile/{startDate}/{endDate}")
    public List<Exercise> retrieveRigidEx(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                          @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        {
            return examenService.retrieveRigidEx(startDate, endDate);
        }
    }
}


