package org.example.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "wheels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wheel {

    @Id
    @GeneratedValue
    private Long id;

    private Integer diameter;

    private String producer;

    private Long ageInDays;
}
