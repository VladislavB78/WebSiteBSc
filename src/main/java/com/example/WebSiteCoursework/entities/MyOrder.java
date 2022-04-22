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
    @JoinColumn(name = "order_status")
    private OrderStatus order_status;


    /* Constructors */
    public MyOrder() {}

    public MyOrder(Customer customer, Product product, OrderStatus order_status) {
        this.customer = customer;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }
}
