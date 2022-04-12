package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MyTable;
import org.springframework.data.repository.CrudRepository;

public interface MainRepository extends CrudRepository<MyTable, Integer> {
}
