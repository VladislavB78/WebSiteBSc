package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.MyOrder;
import com.example.WebSiteCoursework.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {

    @Autowired
    private MyOrderRepository myOrderRepository;

    public void addMyOrder(MyOrder myOrder) {
        myOrderRepository.save(myOrder);
    }

    public void deleteMyOrder() {

    }
}
