package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.MyTable;
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
        return "index";
    }

    @GetMapping("/kitchen-tables")
    public String kitchenTables (Model model) {
        model.addAttribute("title", "Кухонные столы");
        Iterable<MyTable> myTables = mainRepository.findAll();
        return "kitchen-tables";
    }

    @GetMapping("/writing-tables")
    public String writingTables (Model model) {
        model.addAttribute("title", "Письменные столы");
        return "writing-tables";
    }


}
