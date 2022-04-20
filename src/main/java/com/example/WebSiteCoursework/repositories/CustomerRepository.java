package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer, Integer> {
}
