package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
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
    public String save(RedirectAttributes redirectAttributes, @RequestParam(name = "condiment", required = false,
            defaultValue = "0") String[] condiment) {
        redirectAttributes.addFlashAttribute("message", Arrays.toString(condiment));
        return "redirect:/condiments";
    }
}
