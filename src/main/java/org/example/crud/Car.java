package org.example.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String modelName;

    private String producer;

    private Double engineVolume;

    public Car(String modelName, String producer, Double engineVolume) {
        this.modelName = modelName;
        this.producer = producer;
        this.engineVolume = engineVolume;
    }

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<Wheel> wheels;
}
