package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {


}
