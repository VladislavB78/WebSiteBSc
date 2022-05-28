package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.Customer;
import com.example.WebSiteCoursework.entities.Role;
import com.example.WebSiteCoursework.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomerService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customer.setFirst_name("");
        customer.setLast_name("");
        customer.setEmail("");
        customer.setPostal_address("");

//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setActive(true);
        customer.setRoles(Collections.singleton(Role.CUSTOMER));

        customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id) {
        Optional<Customer> customers = customerRepository.findById(id);
        ArrayList<Customer> res = new ArrayList<>();
        customers.ifPresent(res::add);
        return res.get(0);
    }

    public Customer findCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public void editeProfileData(int c_id, String first_name, String last_name, String email, String postal_address) {
        Customer customer = getCustomer(c_id);

        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setEmail(email);
        customer.setPostal_address(postal_address);

        customerRepository.save(customer);
    }
}
