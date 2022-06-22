package org.example.onetomany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clients")
public class Client {
    @Id
    private Integer id;

    private String firstName;
    private String lastName;

    //@OneToMany (mappedBy = "client")
    @JoinColumn(name = "client_id")
    private List<Order> orders;
}
