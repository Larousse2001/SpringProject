package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entities.Enum.Level;

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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long courseID;
    Integer num;
    LocalDate date;
    Integer duration;

    @Enumerated(EnumType.STRING)
    Level level;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    List<Exercise> exerciseList;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    List<Person> personList ;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    Person person;
}

