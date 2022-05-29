package com.example.WebSiteCoursework.controllers;

import com.example.WebSiteCoursework.services.MyOrderService;
import com.example.WebSiteCoursework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ControlPanelController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MyOrderService myOrderService;


    @GetMapping("/control-panel")
    public String openControlPanel(Model model) {
        model.addAttribute("orderWS", myOrderService.getOrderNumbers(2));
        model.addAttribute("orderS", myOrderService.getOrderNumbers(3));
        model.addAttribute("product", productService.getAllProducts());
        return "control-panel";
    }

    @GetMapping("/control-panel/order-processing/{orderNumber}")
    public String openOrderProcessing(@PathVariable(value = "orderNumber") String orderNumber, Model model) {
        model.addAttribute("order", myOrderService.getMyOrdersByOrderNumber(orderNumber));
        return "order-processing";
    }

    @PostMapping("/control-panel/order-processing/{orderNumber}")
    public String shippingOrder(@PathVariable(value = "orderNumber") String orderNumber, Model model) {
        myOrderService.setOrderStatus_Shipment(orderNumber);
        model.addAttribute("orderWS", myOrderService.getOrderNumbers(2));
        model.addAttribute("orderS", myOrderService.getOrderNumbers(3));
        model.addAttribute("product", productService.getAllProducts());
        return "order-processing";
    }
}
