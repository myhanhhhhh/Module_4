package com.example.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/calculator")
public class CaculatorController {
    @GetMapping("")
    public String showList() {
        return "calculator";
    }

    @PostMapping("calculate")
    public String calculate(RedirectAttributes redirectAttributes, @RequestParam("calculate") String calculate,
                             @RequestParam double number1, @RequestParam double number2) {
        if (Objects.equals(calculate, "Addition(+)")) {
            redirectAttributes.addFlashAttribute("result", number1 + number2);
        }
        if (Objects.equals(calculate, "Subtraction(-)")) {
            redirectAttributes.addFlashAttribute("result", number1 - number2);
        }
        if (Objects.equals(calculate, "Mutiplication(*)")) {
            redirectAttributes.addFlashAttribute("result", number1 * number2);
        }
        if (Objects.equals(calculate, "Division(/)")) {
            if (number2 == 0) {
                redirectAttributes.addFlashAttribute("result1", "Can't divide by 0");
            } else {
                redirectAttributes.addFlashAttribute("result", number1 / number2);
            }
        }
        return "redirect:/calculator";
    }
}
