package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.Customer;
import com.example.WebSiteCoursework.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomer(Integer id) {
        Optional<Customer> customers = customerRepository.findById(id);
        ArrayList<Customer> res = new ArrayList<>();
        customers.ifPresent(res::add);
        return res;
    }
}
