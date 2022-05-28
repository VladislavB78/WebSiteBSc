package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product-edit/{id}")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductEditController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String openProductEdit(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product-edit";
    }

    @PostMapping(params = "edit")
    public String editProduct(@PathVariable(value = "id") Integer p_id,
                              @RequestParam(value = "img_address") String img_address, @RequestParam(value = "name") String name,
                              @RequestParam(value = "price") String price, @RequestParam(value = "text_about") String text_about) {

        productService.addProduct(p_id, img_address, name, price, text_about);

        return "redirect:http://localhost:8080/product-edit/" + p_id.toString();
    }

    @PostMapping(params = "del")
    public String deleteProduct(@PathVariable(value = "id") Integer p_id) {

        productService.deleteProduct(p_id);

        return "redirect:http://localhost:8080/";
    }
}
