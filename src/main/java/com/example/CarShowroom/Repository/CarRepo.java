package com.example.CarShowroom.Repository;

import com.example.CarShowroom.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Cars, Integer>
{
    @Query("SELECT c FROM Cars c")
    List<Cars> findAllCars();

    @Query("SELECT c FROM Cars c WHERE c.id = :id")
    Optional<Cars> findByCarId(@Param("id") int id);

    @Query("SELECT c FROM Cars c WHERE c.model = :model")
    List<Cars> findCarsByModels(@Param("model") String models);

    @Query("SELECT c FROM Cars c WHERE c.price = :price")
    List<Cars> findCarsByPrice(@Param("price") int price);

    @Query("SELECT c FROM Cars c WHERE c.brand = :brand")
    List<Cars> findCarsByBrand(@Param("brand") String brand);

    @Query("SELECT c FROM Cars c WHERE c.modelYear = :modelYear")
    List<Cars> findCarsByModelYears(@Param("modelYear") int modelYear);

    @Query("SELECT c FROM Cars c WHERE c.price = (SELECT MAX(c2.price) FROM Cars c2)")
    Cars findCarsByMaxPrice();

    @Query("SELECT c FROM Cars c WHERE c.price = (SELECT MIN(c2.price) FROM Cars c2)")
    Cars findCarsByMinPrice();

    @Query("SELECT c FROM Cars c WHERE c.price BETWEEN :sPrice AND :ePrice")
    List<Cars> findCarsBetween(@Param("sPrice") int sPrice, @Param("ePrice") int ePrice);

    @Query("SELECT c FROM Cars c WHERE c.price > :price")
    List<Cars> findCarsGreaterThanPrice(@Param("price") int price);

    @Query("SELECT c FROM Cars c WHERE c.price < :price")
    List<Cars> findCarsLesserThanPrice(@Param("price") int price);

}
