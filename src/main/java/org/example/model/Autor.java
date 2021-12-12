package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MOVIE_AUTOR")

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private String surname;
   private Integer age;
   private String nationality;

}
