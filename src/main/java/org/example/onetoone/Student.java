package org.example.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "book_id")
    private StudentBook studentBook;
}
