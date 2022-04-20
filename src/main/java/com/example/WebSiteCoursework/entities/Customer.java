package com.example.WebSiteCoursework.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    private String first_name, last_name, email, postal_address;
    private String login, password;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainOrder> mainOrders = new ArrayList<>();


    /* Constructors */
    public Customer() {}

    public Customer(Integer id, String first_name, String last_name, String email, String postal_address, String login, String password, List<MainOrder> mainOrders) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.postal_address = postal_address;
        this.login = login;
        this.password = password;
        this.mainOrders = mainOrders;
    }


    /* Getters and Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MainOrder> getOrders() {
        return mainOrders;
    }

    public void setOrders(List<MainOrder> mainOrders) {
        this.mainOrders = mainOrders;
    }
}
