package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MyOrder;
import org.springframework.data.repository.CrudRepository;

public interface MyOrderRepository extends CrudRepository<MyOrder, Integer> {
}
