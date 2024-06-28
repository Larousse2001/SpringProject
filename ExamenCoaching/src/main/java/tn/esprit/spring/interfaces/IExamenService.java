package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Enum.Level;
import tn.esprit.spring.entities.Exercise;
import tn.esprit.spring.entities.Person;

import java.time.LocalDate;
import java.util.List;

public interface IExamenService {
    public Person addPerson(Person person);
    public Course addCourseAssignCoach(Course course, Long personID) ;
    public List<Course> retrieveCourse(Level level , String name) ;
    public Course assignAthleteCourse(Long personID, Integer num) ;

    public List<Person> retrieveAthlete(String title) ;
    public List<Exercise> retrieveRigidEx(LocalDate startDate, LocalDate endDate);
    public void updateNbReptE() ;



}
