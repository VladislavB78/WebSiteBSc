package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.CustomerService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/cart")
    public String addToCart (Model model) {

//        MainOrder mo = new MainOrder(customerRepository.findById(1).get(), mainProductRepository.findById(1).get(), orderStatusRepository.findById(1).get());
//        mainOrderRepository.save(mo);

        model.addAttribute("customer", customerService.getCustomer(1));
        model.addAttribute("product", productService.getProductsByCustomer(1));

        return "cart.html";
    }
}
