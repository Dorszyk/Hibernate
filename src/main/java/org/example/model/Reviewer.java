package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;

    @OneToOne
    private Movie movie;

    public String toString() {
        return "Reviewer(id=" + this.getId() + ", name=" + this.getName() + ", surname=" + this.getSurname() + ", movie=" + this.getMovie() + ")";
    }
}
