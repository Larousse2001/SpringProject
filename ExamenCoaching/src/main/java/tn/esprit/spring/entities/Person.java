package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entities.Enum.Role;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long personID;
    String name;

    @Enumerated(EnumType.STRING)
    Role role;
    Integer nbrMonthsTraining;
    LocalDate dateOfBirth;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "person")
    List<Course> courses;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "personList")
    List<Course> courseList;
}
