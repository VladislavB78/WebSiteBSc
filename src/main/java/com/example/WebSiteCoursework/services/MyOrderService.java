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

import java.util.List;
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

    public void deleteMyOrder(Integer o_id) {
        myOrderRepository.deleteById(o_id);
    }

    public List<MyOrder> getMyOrderByCustomer(Integer c_id) { return myOrderRepository.findByCustomer_Id(c_id);}

    public List<MyOrder> getMyOrdersByOrderNumber(String orderNumber) {
        return myOrderRepository.findByOrderNumber(orderNumber);
    }

    public List<MyOrder> getOrderNumbers(Integer s_id) {
        return myOrderRepository.findByOrderStatus_Id(s_id);
    }

    public void setOrderStatus_AwaitingShipment(Integer c_id, String orderNumber) {
        myOrderRepository.updateOrderStatusIdAndOrderNumberByCustomer_Id(2,orderNumber, c_id);

    }

    public void setOrderStatus_Shipment(String orderNumber) {
        myOrderRepository.updateOrderStatusIdByOrderNumber(3, orderNumber);
    }
}
