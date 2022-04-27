package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MyOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyOrderRepository extends CrudRepository<MyOrder, Integer> {

    @Query("select m from MyOrder m where m.customer.id = ?1")
    List<MyOrder> findByCustomer_Id(Integer id);


}
