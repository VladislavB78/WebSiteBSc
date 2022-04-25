package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {
}
