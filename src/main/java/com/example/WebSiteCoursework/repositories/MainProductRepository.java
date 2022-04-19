package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MainProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MainProductRepository extends CrudRepository<MainProduct, Integer> {

    List<MainProduct> findByType (int type);
}
