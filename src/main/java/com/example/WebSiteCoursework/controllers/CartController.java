package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.CustomerService;
import com.example.WebSiteCoursework.services.MyOrderService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MyOrderService myOrderService;


    @GetMapping("/cart")
    public String openCart(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        int c_id;
        if (currentPrincipalName.compareTo("anonymousUser") == 0) {
            c_id = 2;
        } else {
            c_id = customerService.findCustomerByUsername(currentPrincipalName).getId();
        }

        model.addAttribute("customer", customerService.getCustomer(c_id));
        model.addAttribute("product", productService.getProductsByCustomer(c_id));
        model.addAttribute("order", myOrderService.getMyOrderByCustomer(c_id));

        return "cart";
    }

    @PostMapping("/conformation-order")
    public String conformationOrder(Model model, @RequestParam(value = "first_name") String first_name,
                                    @RequestParam(value = "last_name") String last_name, @RequestParam(value = "email") String email,
                                    @RequestParam(value = "postal_address") String postal_address) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int c_id = customerService.findCustomerByUsername(currentPrincipalName).getId();

        customerService.editeProfileData(c_id, first_name, last_name, email, postal_address);
        myOrderService.setOrderStatus_AwaitingShipment(c_id);

        model.addAttribute("product", productService.getProductsByCustomer(c_id));
        model.addAttribute("order", myOrderService.getMyOrderByCustomer(c_id));
        model.addAttribute("order_code", c_id + "-" + System.currentTimeMillis()/1000L);

        return "conformation-order";
    }

    @PostMapping("/cart-del")
    public String deleteFromCart(@RequestParam(value = "o_id") String o_id) {
        myOrderService.deleteMyOrder(Integer.parseInt(o_id));
        return "redirect:http://localhost:8080/cart";
    }
}
