package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.CustomerService;
import com.example.WebSiteCoursework.services.MyOrderService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MyOrderService myOrderService;

    @GetMapping("/cart")
    public String addToCart(Model model) {

        model.addAttribute("customer", customerService.getCustomer(1));
        model.addAttribute("product", productService.getProductsByCustomer(1));

        return "cart.html";
    }

    @PostMapping("/cart")
    public String deleteFromCart(@RequestParam(value = "o_id") String o_id) {
        myOrderService.deleteMyOrder(Integer.parseInt(o_id));
        return "redirect:http://localhost:8080/cart";
    }
}
