package com.example.CarShowroom.Service;

import com.example.CarShowroom.Model.Cars;
import com.example.CarShowroom.Model.Manufacturers;
import com.example.CarShowroom.Repository.CarRepo;
import com.example.CarShowroom.Repository.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService
{

    @Autowired
    private CarRepo repo;

    @Autowired
    private ManufacturerRepo manRepo;

    public List<Cars> getALlCar()
    {
        return repo.findAllCars();
    }

    public Cars getCarsByIds(int id)
    {
        return repo.findByCarId(id).orElseThrow(() -> new RuntimeException("ID Not Found"));
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

    public Cars getCarsByMaxPrice()
    {
        return repo.findCarsByMaxPrice();
    }

    public Cars getCarsByMinPrice()
    {
        return repo.findCarsByMinPrice();
    }

    public List<Cars> getCarsByBetweenPrice(int sPrice, int ePricee)
    {
        return repo.findCarsBetween(sPrice, ePricee);
    }

    public List<Cars> getCarsByGreaterThanPrice(int gPrice)
    {
        return repo.findCarsGreaterThanPrice(gPrice);
    }

    public List<Cars> getCarsByLesserThanPrice(int lPrice)
    {
        return repo.findCarsLesserThanPrice(lPrice);
    }

    public void addCars(Cars cars)
    {
        Manufacturers manu = manRepo.findById(cars.getManufacturer().getManufacturerId())
                        .orElseThrow(() -> new RuntimeException("Manufacturer not found with id: "
                                + cars.getManufacturer().getManufacturerId()));
        cars.setManufacturer(manu);
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
