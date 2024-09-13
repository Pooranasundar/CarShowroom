package com.example.CarShowroom.Service;

import com.example.CarShowroom.Model.Manufacturers;
import com.example.CarShowroom.Repository.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService
{
    @Autowired
    private ManufacturerRepo repo;

    public List<Manufacturers> getAllManufactures()
    {
        return repo.findAll();
    }

    public Manufacturers getManufacturesById(int mId)
    {
        return repo.findById(mId).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
    }

    public Manufacturers getManufacturesByBrand(String mBrand)
    {
        return repo.findByManufacturerBrand(mBrand);
    }

    public List<Manufacturers> getManufacturersByLocation(String mLocation)
    {
        return repo.findManufacturersByLocation(mLocation);
    }

    public void addManufactures(Manufacturers manufacturer)
    {
        repo.save(manufacturer);
    }

    public void updateManufacture(int mId, Manufacturers manufacturers)
    {
        Manufacturers manu = repo.findById(mId).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        manu.setBrand(manufacturers.getBrand());
        manu.setLocation(manufacturers.getLocation());
        repo.save(manu);
    }

    public void deleteManufactureById(int mId)
    {
        repo.deleteById(mId);
    }


}
