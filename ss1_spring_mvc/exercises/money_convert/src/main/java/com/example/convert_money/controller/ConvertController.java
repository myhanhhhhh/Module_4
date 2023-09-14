package com.example.convert_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String showForm() {
        return "convertForm";
    }

    @PostMapping("/convert")
    public String calculate(@RequestParam double vnd, Model model) {
        model.addAttribute("usd", vnd * 23000);
        return "convertForm";
    }
}
