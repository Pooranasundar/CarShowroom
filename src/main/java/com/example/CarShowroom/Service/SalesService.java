package com.example.CarShowroom.Service;

import com.example.CarShowroom.Model.Sales;
import com.example.CarShowroom.Repository.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService
{

    @Autowired
    private SalesRepo repo;

    public List<Sales> getAllSales()
    {
        return repo.findAll();
    }

    public Sales getSalesByIds(int sId)
    {
        return repo.findById(sId).orElseThrow(() -> new RuntimeException("Sales Id Not Found"));
    }

    public List<Sales> getSalesByBrand(String brand)
    {
        return repo.findSalesByBrand(brand);
    }

    public List<Sales> getSalesByLocation(String location)
    {
        return repo.findSalesByCustomerLocation(location);
    }

    public List<Sales> getSalesByCustomerId(int customerId)
    {
        return repo.findSalesByCustomerId(customerId);
    }

    public void addSales(Sales sales)
    {
        repo.save(sales);
    }

    public void updateSales(int sId, Sales sales)
    {
        Sales sale = repo.findById(sId).orElseThrow(() -> new RuntimeException("Sales Id is Not Found"));
        sale.setCar(sales.getCar());
        sale.setCustomerName(sales.getCustomerName());
        sale.setCustomerId(sales.getCustomerId());
        sale.setCustomerLocation(sales.getCustomerLocation());
        repo.save(sale);
    }

    public void deleteSales(int sId)
    {
        repo.deleteById(sId);
    }

}
