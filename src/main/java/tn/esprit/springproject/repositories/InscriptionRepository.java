package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.Support;
import tn.esprit.springproject.entities.Inscription;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    @Query("Select i.numSemaine from Inscription i " +
           "JOIN Moniteur m " +
           "ON i.cours member of m.coursSet " +
           "WHERE m.numMoniteur =:numMoniteur And i.cours.support =:support")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numMoniteur") Long numMoniteur,
                                                             @Param("support") Support support);
}
