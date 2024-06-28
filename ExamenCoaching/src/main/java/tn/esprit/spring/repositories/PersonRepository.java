package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Enum.Role;
import tn.esprit.spring.entities.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByPersonIDAndRole(long idPersonne, Role roleP);

  //  List<Person> findByNameLike(String prenom);

    //List<Person> findBySeanceListExerciceListTitleLike(String nom);

    @Query("SELECT p FROM Person p JOIN p.courseList c JOIN c.exerciseList e  WHERE e.title = :title AND YEAR(CURRENT_DATE) - YEAR(p.dateOfBirth) < 20")
    List<Person> recupererAthlete(@Param("title") String title);
}
