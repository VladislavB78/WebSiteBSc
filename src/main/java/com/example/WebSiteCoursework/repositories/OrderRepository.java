package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MainOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<MainOrder, Integer> {
}
