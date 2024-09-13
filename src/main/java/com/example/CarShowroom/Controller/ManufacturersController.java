package com.example.CarShowroom.Controller;

import com.example.CarShowroom.Model.Manufacturers;
import com.example.CarShowroom.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturersController
{

    @Autowired
    private ManufacturerService service;

    @GetMapping("/hello/manufacture")
    public String hello()
    {
        return "Hello Manufacturer";
    }

    @GetMapping("/get/all/manufactures")
    public List<Manufacturers> getAllManufactures()
    {
        return service.getAllManufactures();
    }

    @GetMapping("/get/manufacture/{mId}")
    public Manufacturers getManufactureById(@PathVariable int mId)
    {
        return service.getManufacturesById(mId);
    }

    @GetMapping("/get/manufacture/brand/{brand}")
    public Manufacturers getManufacturesByBrand(@PathVariable String brand)
    {
        return service.getManufacturesByBrand(brand);
    }

    @GetMapping("/get/manufacture/location/{mLocation}")
    public List<Manufacturers> getManufacturesByLocation(@PathVariable String mLocation)
    {
        return service.getManufacturersByLocation(mLocation);
    }

    @PostMapping("/add/manufacture")
    public ResponseEntity<String> addManufacture(@RequestBody Manufacturers manufacturer)
    {
        service.addManufactures(manufacturer);
        return ResponseEntity.ok("Manufacturer added successfully");
    }

    @PutMapping("/update/manufacture/{mId}")
    public ResponseEntity<String> updateManufacture(@PathVariable int mId, @RequestBody Manufacturers manufacturers)
    {
        service.updateManufacture(mId, manufacturers);
        return ResponseEntity.ok("Manufacturer Updated successfully");
    }

    @DeleteMapping("/delete/manufacture/{mId}")
    public ResponseEntity<String> deleteManufactureById(@PathVariable int mId)
    {
        service.deleteManufactureById(mId);
        return ResponseEntity.ok("Manufacturer Deleted successfully");
    }


}
