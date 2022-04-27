package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select c from Customer c where c.username = ?1")
    Customer findByUsername(String username);
}
