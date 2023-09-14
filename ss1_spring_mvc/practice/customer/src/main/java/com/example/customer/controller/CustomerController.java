package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customer/list")
    public String showList(Model model){
        List<Customer> customerList =customerService.showList();
        model.addAttribute("customerList" , customerList);
        return "list";
    }
}
