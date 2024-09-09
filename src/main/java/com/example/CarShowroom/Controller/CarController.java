package com.example.CarShowroom.Controller;

import com.example.CarShowroom.Model.Cars;
import com.example.CarShowroom.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController
{

    @Autowired
    private CarService service;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Customer";
    }

    @GetMapping("/all/cars")
    public List<Cars> getAllCars()
    {
        return service.getALlCar();
    }

    @GetMapping("/car/{id}")
    public Cars getCarsById(@PathVariable int id)
    {
        return service.getCarsByIds(id);
    }

    @GetMapping("/car/model/{model}")
    public List<Cars> getCarsByModel(@PathVariable String model)
    {
        return service.getCarsByModels(model);
    }

    @GetMapping("/car/price/{price}")
    public List<Cars> getCarsByPrice(@PathVariable int price)
    {
        return service.getCarsByPrice(price);
    }

    @GetMapping("/car/brand/{brand}")
    public List<Cars> getCarsByBrand(@PathVariable String brand)
    {
        return service.getCarsByBrands(brand);
    }

    @GetMapping("/car/modelyear/{myear}")
    public List<Cars> getCarsByModelYear(@PathVariable int myear)
    {
        return service.getCarsByModelYears(myear);
    }

    @PostMapping("/add/cars")
    public void addCars(@RequestBody Cars cars)
    {
        service.addCars(cars);
    }

    @PutMapping("/update/cars/{id}")
    public void updateCars(@PathVariable int id,@RequestBody Cars cars)
    {
        service.updateCars(id, cars);
    }

    @DeleteMapping("/delete/cars/{id}")
    public void deleteCarsByIds(@PathVariable int id)
    {
        service.deleteCarsByIds(id);
    }


}
