package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
@PreAuthorize("hasAuthority('ADMIN')" + "|| hasAuthority('CUSTOMER')")
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String openProfile(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int c_id = customerService.findCustomerByUsername(currentPrincipalName).getId();

        model.addAttribute("customer", customerService.getCustomer(c_id));

        return "profile";
    }

    @PostMapping
    public String editeProfileData(Model model, @RequestParam(value = "first_name") String first_name,
                                   @RequestParam(value = "last_name") String last_name, @RequestParam(value = "email") String email,
                                   @RequestParam(value = "postal_address") String postal_address) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int c_id = customerService.findCustomerByUsername(currentPrincipalName).getId();

        customerService.editeProfileData(c_id, first_name, last_name, email, postal_address);

        return "redirect:/profile";
    }
}
