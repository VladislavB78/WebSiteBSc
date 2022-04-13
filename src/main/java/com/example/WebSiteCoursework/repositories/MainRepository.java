package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.TablesForSale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MainRepository extends CrudRepository<TablesForSale, Integer> {

    List<TablesForSale> findByType (int type);
}
