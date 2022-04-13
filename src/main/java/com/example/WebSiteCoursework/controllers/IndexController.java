package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.TablesForSale;
import com.example.WebSiteCoursework.repositories.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World")
//                                       String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
    @Autowired
    private MainRepository mainRepository;
    
    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title", "Главная страница");

        Iterable<TablesForSale> tablesForSale = mainRepository.findAll();
        model.addAttribute("tablesForSale", tablesForSale);

        return "index";
    }

    @GetMapping("/kitchen-tables")
    public String kitchenTables (Model model) {
        model.addAttribute("title", "Кухонные столы");

        Iterable<TablesForSale> tablesForSale = mainRepository.findByType(1);
        model.addAttribute("tablesForSale", tablesForSale);

        return "kitchen-tables";
    }

    @GetMapping("/writing-tables")
    public String writingTables (Model model) {
        model.addAttribute("title", "Письменные столы");

        Iterable<TablesForSale> tablesForSale = mainRepository.findByType(2);
        model.addAttribute("tablesForSale", tablesForSale);

        return "writing-tables";
    }

    @GetMapping("/cart")
    public String cart (Model model) {
        model.addAttribute("title", "Корзина");
        return "cart";
    }

    @GetMapping("/about")
    public String about (Model model) {
        model.addAttribute("title", "О компании");
        return "about";
    }

}
