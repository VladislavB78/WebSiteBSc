package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.MainProduct;
import com.example.WebSiteCoursework.repositories.MainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private MainProductRepository mainProductRepository;


    @GetMapping("/product/{id}")
    public String productDetails (@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("title", "Детальнее");

        Optional<MainProduct> mainProduct = mainProductRepository.findById(id);
        ArrayList<MainProduct> res = new ArrayList<>();
        mainProduct.ifPresent(res::add);
        model.addAttribute("mainProduct", res);

        return "product.html";
    }
}
