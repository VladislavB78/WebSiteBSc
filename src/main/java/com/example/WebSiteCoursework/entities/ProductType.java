package com.example.WebSiteCoursework.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_id")
    private Integer id;

    private String typeName;


    @OneToMany(mappedBy = "type" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public void addMainProduct(Product product) {
        this.products.add(product);
        product.setType(this);
    }
    public void removeMainProduct(Product product) {
        this.products.remove(product);
        product.setType(null);
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

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
