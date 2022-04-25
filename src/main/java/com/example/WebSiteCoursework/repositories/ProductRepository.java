package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByType_Id(Integer id);

    @Query("select p from Product p inner join p.myOrders myOrders where myOrders.customer.id = ?1")
    List<Product> findByMyOrders_Customer_Id(Integer id);


//    @Query("select p from Product p inner join p.myOrders myOrders where myOrders.customer.id = ?1")
//    List<Product> findByOrders_Customer_Id(Integer id);

//    @Query("select m from Product m inner join m.myOrders myOrders where myOrders.customer.id = ?1")
//    List<Product> findByOrders_Customer_Id(Integer id);


}
