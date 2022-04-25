package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.Customer;
import com.example.WebSiteCoursework.entities.MyOrder;
import com.example.WebSiteCoursework.entities.OrderStatus;
import com.example.WebSiteCoursework.entities.Product;
import com.example.WebSiteCoursework.repositories.CustomerRepository;
import com.example.WebSiteCoursework.repositories.MyOrderRepository;
import com.example.WebSiteCoursework.repositories.OrderStatusRepository;
import com.example.WebSiteCoursework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyOrderService {

    @Autowired
    private MyOrderRepository myOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;


    public void addMyOrder(Integer c_id, Integer p_id, Integer s_id) {
        Optional<Customer> c = customerRepository.findById(c_id);
        Optional<Product> p = productRepository.findById(p_id);
        Optional<OrderStatus> os = orderStatusRepository.findById(s_id);

        myOrderRepository.save(new MyOrder(c.get(), p.get(), os.get()));
    }

    public void deleteMyOrder(Integer id) {
        myOrderRepository.deleteById(id);
    }
}
