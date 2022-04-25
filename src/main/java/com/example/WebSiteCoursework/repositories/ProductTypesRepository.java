package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypesRepository extends CrudRepository<ProductType, Integer> {
}
