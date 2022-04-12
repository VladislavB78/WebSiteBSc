//package com.example.WebSiteCoursework.controllers;
//
//import com.example.WebSiteCoursework.entities.MyTable;
//import com.example.WebSiteCoursework.repositories.MainRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KitchenTablesController {
//
//    @Autowired
//    private MainRepository mainRepository;
//
//    @GetMapping("/kitchen-tables")
//    public String kitchenTables (Model model) {
//        model.addAttribute("title", "Кухонные столы");
//        Iterable<MyTable> myTables = mainRepository.findAll();
//        return "kitchen-tables";
//    }
//}
