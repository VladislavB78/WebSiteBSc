package com.example.WebSiteCoursework.entities;

import javax.persistence.*;

@Entity
public class MainOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_product")
    private MainProduct main_product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status")
    private OrderStatus order_status;


    /* Constructors */
    public MainOrder() {}

    public MainOrder(Integer id, Customer customer, MainProduct main_product, OrderStatus order_status) {
        this.id = id;
        this.customer = customer;
        this.main_product = main_product;
        this.order_status = order_status;
    }


    /* Getters and Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MainProduct getMain_product() {
        return main_product;
    }

    public void setMain_product(MainProduct main_product) {
        this.main_product = main_product;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }
}
