package com.example.WebSiteCoursework.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MainProduct {

    public MainProduct() {
    }

    public MainProduct(String name, double price, int type, String text_about, String img_address) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.text_about = text_about;
        this.img_address = img_address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private double price;
    private int type;
    private String text_about;
    private String img_address;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getText_about() {
        return text_about;
    }
    public void setText_about(String text_about) {
        this.text_about = text_about;
    }

    public String getImg_address() {
        return img_address;
    }
    public void setImg_address(String text_about) {
        this.img_address = img_address;
    }
}
