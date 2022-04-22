package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "index.html";
    }

    @GetMapping("/kitchen-tables")
    public String kitchenTables (Model model) {
        model.addAttribute("product", productService.getProductsByType(1));
        return "kitchen-tables.html";
    }

    @GetMapping("/writing-tables")
    public String writingTables (Model model) {
        model.addAttribute("product", productService.getProductsByType(2));
        return "writing-tables.html";
    }

    @GetMapping("/about")
    public String about () {
        return "about.html";
    }
}
