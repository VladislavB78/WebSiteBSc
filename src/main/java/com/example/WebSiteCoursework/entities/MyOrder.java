package com.example.WebSiteCoursework.entities;

import javax.persistence.*;

@Entity
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderStatus")
    private OrderStatus orderStatus;

    @Column(name = "orderNumber")
    private String orderNumber;


    /* Constructors */
    public MyOrder() {}

    public MyOrder(Customer customer, Product product, OrderStatus orderStatus) {
        this.customer = customer;
        this.product = product;
        this.orderStatus = orderStatus;
    }

    public MyOrder(Customer customer, Product product, OrderStatus orderStatus, String orderNumber) {
        this.customer = customer;
        this.product = product;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
