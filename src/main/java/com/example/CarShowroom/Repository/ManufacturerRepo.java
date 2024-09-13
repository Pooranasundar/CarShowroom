package com.example.CarShowroom.Repository;

import com.example.CarShowroom.Model.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturers, Integer>
{
    @Query("SELECT m FROM Manufacturers m JOIN Cars c ON m.brand = c.brand WHERE c.brand = :brand")
    Manufacturers findByManufacturerBrand(@Param("brand") String Brand);

    @Query("SELECT m FROM Manufacturers m WHERE m.location = :location")
    List<Manufacturers> findManufacturersByLocation(@Param("location") String location);
}
