package tn.esprit.spring.services;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Enum.Level;
import tn.esprit.spring.entities.Enum.Role;
import tn.esprit.spring.entities.Exercise;
import tn.esprit.spring.entities.Person;
import tn.esprit.spring.interfaces.IExamenService;
import tn.esprit.spring.repositories.CourseRepository;
import tn.esprit.spring.repositories.ExerciseRepository;
import tn.esprit.spring.repositories.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamenServiceIMPL implements IExamenService {
    PersonRepository personRepository;
    CourseRepository courseRepository;
    ExerciseRepository exerciseRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Course addCourseAssignCoach(Course course, Long personID) {
        Person person = personRepository.findByPersonIDAndRole(personID, Role.COACH);
        if (null != person) {
            course.setPerson(person);
            courseRepository.save(course);
        }
        return course;
    }

    @Override
    @Transactional
    public List<Course> retrieveCourse(Level level, String name) {
        return courseRepository.findByLevelAndDateBeforeAndPersonNameLike(level, LocalDate.now(), name);

    }

    @Override
    @Transactional
    public Course assignAthleteCourse(Long personID, Integer num) {
        Course course = courseRepository.findByNum(num);
        Person person = personRepository.findById(personID).orElse(null);

        if (course.getDate().isAfter(LocalDate.now())) {
            if ((course.getLevel() == Level.BEGINNER)
                    ||
                    (
                            (((person != null) && person.getNbrMonthsTraining()  > 12)
                                    && (course.getLevel() == Level.ADVANCED)))) {
                course.getPersonList().add(person);
            }


        }
        return course;
    }

    @Override
    public List<Person> retrieveAthlete(String title) {
        return personRepository.recupererAthlete(title);
    }

    @Override
    public List<Exercise> retrieveRigidEx(LocalDate startDate, LocalDate endDate) {

        return courseRepository.recupererExerciceDiff(Level.ADVANCED, startDate, endDate);

    }

    @Scheduled(cron = "*/10 * * * * *")
    @Override
    public void updateNbReptE() {
        log.info("updateNbReptE");
        for (Course course : courseRepository.findAll()) {
            int sommeExercice = 0;
            for (Exercise exercise : course.getExerciseList()) {
                sommeExercice += (exercise.getDuration() + exercise.getBreakTime()) *
                        exercise.getNbrOfRepetitions();
            }
            course.setDuration(sommeExercice);
            courseRepository.saveAll(courseRepository.findAll());
        }

    }
}
