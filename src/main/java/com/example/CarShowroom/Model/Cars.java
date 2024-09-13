package com.example.CarShowroom.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cars
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;
    private String brand;
    private String model;
    private int price;
    private int modelYear;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    //@JsonManagedReference
    @JsonIgnoreProperties("cars")
    private Manufacturers manufacturer;
}
