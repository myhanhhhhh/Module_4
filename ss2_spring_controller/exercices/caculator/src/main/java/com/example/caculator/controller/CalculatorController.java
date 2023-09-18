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
public class CalculatorController {
    @GetMapping("")
    public String showCalulate() {
        return "calculator";
    }

    @PostMapping("calculate")
    public String calculate(RedirectAttributes redirectAttributes, @RequestParam("calculate") String calculate,
                            @RequestParam double number1, @RequestParam double number2) {
        if (calculate.equals("Addition(+)")) {
            redirectAttributes.addFlashAttribute("result", number1 + number2);
        }
        if (calculate.equals("Subtraction(-)")) {
            redirectAttributes.addFlashAttribute("result", number1 - number2);
        }
        if (calculate.equals("Mutiplication(*)")) {
            redirectAttributes.addFlashAttribute("result", number1 * number2);
        }
        if (calculate.equals("Division(/)")) {
            if (number2 == 0) {
                redirectAttributes.addFlashAttribute("error", "Can't divide by 0");
            } else {
                redirectAttributes.addFlashAttribute("result", number1 / number2);
            }
        }
        return "redirect:/calculator";
    }
}
