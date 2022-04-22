package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.Product;
import com.example.WebSiteCoursework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByType(Integer id) {
        return productRepository.findByType_Id(id);
    }

    public List<Product> getProductsByCustomer(Integer id){return productRepository.findByMyOrders_Customer_Id(id);}
}
