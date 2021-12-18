package org.example.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer yearsOfExperience;
    @Enumerated(value = EnumType.STRING)
    private Rating rating;
    @Email
    private String email;

    @PESEL(message = "Wprowadz poprawną wartość")
    private Integer pesel;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;




}
