package com.example.WebSiteCoursework.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductType {

    public ProductType() {
    }

    public ProductType(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
