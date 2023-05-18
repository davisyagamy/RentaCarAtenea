package com.example.rentacarreto3.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "gama")
public class Gama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST },mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    private List<Car> cars;

}
