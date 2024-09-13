package com.example.CarShowroom.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesId;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    private String customerName;
    private int customerId;
    private String customerLocation;


}
