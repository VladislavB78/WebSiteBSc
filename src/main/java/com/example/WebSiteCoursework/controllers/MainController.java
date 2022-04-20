package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.MainProduct;
import com.example.WebSiteCoursework.repositories.MainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World")
//                                       String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @Autowired
    private MainProductRepository mainProductRepository;


    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title", "Главная страница");

        Iterable<MainProduct> mainProduct = mainProductRepository.findAll();
        model.addAttribute("mainProduct", mainProduct);

        return "index.html";
    }

    @GetMapping("/kitchen-tables")
    public String kitchenTables (Model model) {
        model.addAttribute("title", "Кухонные столы");

        Iterable<MainProduct> mainProduct = mainProductRepository.findByType_Id(1);
        model.addAttribute("mainProduct", mainProduct);

        return "kitchen-tables.html";
    }

    @GetMapping("/writing-tables")
    public String writingTables (Model model) {
        model.addAttribute("title", "Письменные столы");

        Iterable<MainProduct> mainProduct = mainProductRepository.findByType_Id(2);
        model.addAttribute("mainProduct", mainProduct);

        return "writing-tables.html";
    }

    @GetMapping("/cart")
    public String cart (Model model) {
        model.addAttribute("title", "Корзина");
        return "cart.html";
    }

    @GetMapping("/about")
    public String about (Model model) {
        model.addAttribute("title", "О компании");
        return "about.html";
    }
}
