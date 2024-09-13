package com.example.CarShowroom.Repository;

import com.example.CarShowroom.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer>
{

    @Query("SELECT s FROM Sales s JOIN s.car c WHERE c.brand = :brand")
    List<Sales> findSalesByBrand(@Param("brand") String brand);

    @Query("SELECT s FROM Sales s WHERE s.customerLocation = :location")
    List<Sales> findSalesByCustomerLocation(@Param("location") String location);

    @Query("SELECT s FROM Sales s WHERE s.customerId = :customerId")
    List<Sales> findSalesByCustomerId(@Param("customerId") int customerId);

}
