package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/condiments")
public class CondimentsController {
    @GetMapping("")
    public String showList() {
        return "list";
    }

    @PostMapping("/save")
    public String save(@RequestParam ("condiment") String [] condiment, Model model) {
        model.addAttribute("condiment", Arrays.toString(condiment));
        return "list";
    }
}
