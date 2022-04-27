package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.entities.Customer;
import com.example.WebSiteCoursework.entities.Role;
import com.example.WebSiteCoursework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public String registration() {
        return "registration.html";
    }

    @PostMapping
    public String addCustomer(Customer customer, Model model) {

        Customer customerByUsername = customerService.findCustomerByUsername(customer.getUsername());

        if (customer.getUsername().isEmpty() || customer.getPassword().isEmpty()) {
            model.addAttribute("msg", "Пожалуйста, введите имя пользователя и пароль!");
            return "registration";
        }

        if (customerByUsername != null) {
            model.addAttribute("msg", "Пользователь с таким именем уже существует!");
            return "registration";
        }

        customer.setFirst_name("");
        customer.setLast_name("");
        customer.setEmail("");
        customer.setPostal_address("");
        customer.setActive(true);
        customer.setRoles(Collections.singleton(Role.CUSTOMER));

        customerService.addCustomer(customer);

        return "redirect:/login";
    }
}
