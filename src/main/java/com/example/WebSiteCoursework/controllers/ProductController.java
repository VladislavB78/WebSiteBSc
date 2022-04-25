package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.MyOrderService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MyOrderService myOrderService;

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product.html";
    }

    @PostMapping("/product/{id}")
    public String addProductToOrder(@PathVariable(value = "id") Integer id) {
        myOrderService.addMyOrder(1, id, 1);
        return "redirect:http://localhost:8080/product/" + id.toString();
    }
}
