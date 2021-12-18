package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MOVIE_TABLE")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;
    private String type;
    private Integer time;

    @OneToOne(mappedBy = "movie")
    private  Reviewer reviewer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Autor autor;

    @ManyToMany
    private List<Actor> actors;

    public String toString() {
        return "Movie(id=" + this.getId() + ", title=" + this.getTitle() + ", productionYear=" + this.getProductionYear() + ", type=" + this.getType() + ", time=" + this.getTime() + ")";
    }
}
