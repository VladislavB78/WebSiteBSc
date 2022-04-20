package com.example.WebSiteCoursework.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer id;

    private String status_name;

    @OneToMany(mappedBy = "order_status" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainOrder> mainOrders = new ArrayList<>();


    /* Constructors */
    public OrderStatus() {}

    public OrderStatus(Integer id, String status_name, List<MainOrder> mainOrders) {
        this.id = id;
        this.status_name = status_name;
        this.mainOrders = mainOrders;
    }


    /* Getters and Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public List<MainOrder> getOrders() {
        return mainOrders;
    }

    public void setOrders(List<MainOrder> mainOrders) {
        this.mainOrders = mainOrders;
    }
}
