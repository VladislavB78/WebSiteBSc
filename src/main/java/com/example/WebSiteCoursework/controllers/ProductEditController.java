package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.Product;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product-edit/{id}")
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

        Product product = productService.getProduct(p_id).get(0);
        product.setImg_address(img_address);
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setText_about(text_about);

        return "redirect:http://localhost:8080/product-edit";
    }

    @PostMapping(params = "del")
    public String deleteProduct(@PathVariable(value = "id") Integer p_id) {

        productService.deleteProduct(p_id);

        return "redirect:http://localhost:8080/";
    }
}
