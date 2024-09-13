package com.example.CarShowroom.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturers
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private int manufacturerId;

    private String brand;
    private String location;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    //@JsonBackReference
    @JsonIgnoreProperties("manufacturer")
    private List<Cars> cars;
}
