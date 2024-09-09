package com.example.CarShowroom.Service;

import com.example.CarShowroom.Model.Cars;
import com.example.CarShowroom.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService
{

    @Autowired
    private CarRepo repo;

    public List<Cars> getALlCar()
    {
        return repo.findAllCars();
    }

    public Cars getCarsByIds(int id)
    {
        return repo.findByCarId(id).orElseThrow();
    }

    public List<Cars> getCarsByModels(String model)
    {
        return repo.findCarsByModels(model);
    }

    public List<Cars> getCarsByPrice(int price)
    {
        return repo.findCarsByPrice(price);
    }

    public List<Cars> getCarsByBrands(String brand)
    {
        return repo.findCarsByBrand(brand);
    }

    public List<Cars> getCarsByModelYears(int myear)
    {
        return repo.findCarsByModelYears(myear);
    }

    public void addCars(Cars cars)
    {
        repo.save(cars);
    }

    public void updateCars(int id, Cars cars)
    {
        Cars updateCars = repo.findByCarId(id).orElseThrow(() -> new RuntimeException("Car not found"));
        updateCars.setModel(cars.getModel());
        updateCars.setPrice(cars.getPrice());
        updateCars.setBrand(cars.getBrand());
        updateCars.setModelYear(cars.getModelYear());
        repo.save(updateCars);
    }

    public void deleteCarsByIds(int id)
    {
        repo.deleteById(id);
    }
}
