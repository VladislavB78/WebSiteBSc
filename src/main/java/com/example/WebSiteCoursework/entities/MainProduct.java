package com.example.WebSiteCoursework.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MainProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mp_id")
    private Integer id;

    private String name;
    private double price;
    private String text_about;
    private String img_address;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private ProductType type;

    @OneToMany(mappedBy = "main_product" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainOrder> mainOrders = new ArrayList<>();


    /* Constructors */
    public MainProduct() {}

    public MainProduct(String name, double price, String text_about, String img_address) {
        this.name = name;
        this.price = price;
        this.text_about = text_about;
        this.img_address = img_address;
    }


    /* Getters and Setters */
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

    public void setPrice(double price) {
        this.price = price;
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

    public void setImg_address(String img_address) {
        this.img_address = img_address;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public List<MainOrder> getOrders() {
        return mainOrders;
    }

    public void setOrders(List<MainOrder> mainOrders) {
        this.mainOrders = mainOrders;
    }
}
