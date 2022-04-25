package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MyOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyOrderRepository extends CrudRepository<MyOrder, Integer> {
}
