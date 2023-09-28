package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        return new ModelAndView("cart", "cart", cartDto);
    }

}
