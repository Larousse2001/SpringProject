package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Enum.Level;
import tn.esprit.spring.entities.Exercise;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
   List<Course> findByLevelAndDateBeforeAndPersonNameLike(Level level, LocalDate date , String name);

  Course findByNum(Integer numSeance);

   @Query("SELECT c.exerciseList FROM Course c JOIN c.exerciseList e WHERE e.breakTime >= 2 AND c.level =:niveau and (c.date BETWEEN :sDate AND :eDate)")
  List<Exercise> recupererExerciceDiff(@Param("niveau") Level niveau, @Param("sDate") LocalDate startDate, @Param("eDate") LocalDate endDate);
}
