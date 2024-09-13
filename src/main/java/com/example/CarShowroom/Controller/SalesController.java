package com.example.CarShowroom.Controller;

import com.example.CarShowroom.Model.Cars;
import com.example.CarShowroom.Model.Sales;
import com.example.CarShowroom.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController
{

    @Autowired
    private SalesService service;

    @GetMapping("/hello/sales")
    public String hello()
    {
        return "Hello Sales";
    }

    @GetMapping("/get/all/sales")
    public List<Sales> getAllSales()
    {
        return service.getAllSales();
    }

    @GetMapping("/get/sales/{sId}")
    public Sales getSaleById(@PathVariable int sId)
    {
        return service.getSalesByIds(sId);
    }

    @GetMapping("/get/sales/brand/{brand}")
    public List<Sales> getSalesByBrand(@PathVariable String brand)
    {
        return service.getSalesByBrand(brand);
    }

    @GetMapping("/get/sales/location/{location}")
    public List<Sales> getSalesByLocation(@PathVariable String location)
    {
        return service.getSalesByLocation(location);
    }

    @GetMapping("/get/sales/customerid/{cId}")
    public List<Sales> getSalesByCustomerId(@PathVariable int cId)
    {
        return service.getSalesByCustomerId(cId);
    }

    @PostMapping("/add/sales")
    public ResponseEntity<String> addSales(@RequestBody Sales sales)
    {
        service.addSales(sales);
        return ResponseEntity.ok("Sales added");
    }

    @PutMapping("/update/sales/{sId}")
    public ResponseEntity<String> updateSales(@PathVariable int sId, @RequestBody Sales sales)
    {
        service.updateSales(sId, sales);
        return ResponseEntity.ok("Sales Updated");
    }

    @DeleteMapping("/delete/sale/{sId}")
    public ResponseEntity<String> deleteSalesById(@PathVariable int sId)
    {
        service.deleteSales(sId);
        return ResponseEntity.ok("Sales Deleted");
    }


}
