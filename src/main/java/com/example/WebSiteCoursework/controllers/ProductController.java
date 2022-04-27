package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.CustomerService;
import com.example.WebSiteCoursework.services.MyOrderService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/{id}")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MyOrderService myOrderService;
    @Autowired
    private CustomerService customerService;


    @GetMapping
    public String productDetails(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

    @PostMapping
    public String addProductToOrder(@PathVariable(value = "id") Integer id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        int c_id;
        if (currentPrincipalName.compareTo("anonymousUser") == 0) {
            c_id = 2;
        } else {
            c_id = customerService.findCustomerByUsername(currentPrincipalName).getId();
        }

        myOrderService.addMyOrder(c_id, id, 1);
        return "redirect:http://localhost:8080/product/" + id.toString();
    }
}
