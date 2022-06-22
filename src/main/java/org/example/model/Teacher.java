package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @EmbeddedId // klucz złożony
    private TeacherId teacherId;

    @Embedded // osadzenie kolumn firstName i lastName w encji za pomocą pola klasy Person
    private Person person;
}