package com.example.WebSiteCoursework.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_id")
    private Integer id;

    private String typeName;


    @OneToMany(mappedBy = "type" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainProduct> mainProducts = new ArrayList<>();

    public void addMainProduct(MainProduct mainProduct) {
        this.mainProducts.add(mainProduct);
        mainProduct.setType(this);
    }
    public void removeMainProduct(MainProduct mainProduct) {
        this.mainProducts.remove(mainProduct);
        mainProduct.setType(null);
    }


    /* Constructors */
    public ProductType() {}

    public ProductType(String typeName) {
        this.typeName = typeName;
    }


    /* Getters and Setters */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return typeName;
    }
    public void setType(String typeName) {
        this.typeName = typeName;
    }

    public List<MainProduct> getMainProducts() {
        return mainProducts;
    }
    public void setMainProduct(List<MainProduct> mainProduct) {
        this.mainProducts = mainProduct;
    }
}
