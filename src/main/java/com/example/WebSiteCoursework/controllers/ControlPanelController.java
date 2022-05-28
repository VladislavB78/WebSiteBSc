package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/control-panel")
@PreAuthorize("hasAuthority('ADMIN')")
public class ControlPanelController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String openControlPanel(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "/control-panel";
    }

//    @PostMapping
//    public String changeAlbum(@RequestParam(value = "btnRadio") String btnRadio, Model model) {
//
//        switch (btnRadio) {
//            case "r1":
//                model.addAttribute("product", productService.getAllProducts()); break;
//            case "r2":
//                model.addAttribute("product", productService.getProductsByType(1)); break;
//            case "r3":
//                model.addAttribute("product", productService.getProductsByType(2)); break;
//        }
//
//        return "/control-panel";
//    }
}
