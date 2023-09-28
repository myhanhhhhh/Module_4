package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Created successfully");
        return "/redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("products", productService.findById(id));
        return "detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable int id, @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("minus/{id}")
    public String minus(@PathVariable int id,
                        @SessionAttribute(value = "cart",required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.minusProductQuantity(productDto);
        }
        return "redirect:/cart";
    }
}
