package com.example.product_management_orm.controller;

import com.example.product_management_orm.model.Product;
import com.example.product_management_orm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Product> productList = productService.display();
        ModelAndView modelAndView = new ModelAndView("list", "productList", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Product was created");
        return "redirect:/product";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("mess", "Product don't exist");
        } else {
            model.addAttribute("product", product);
        }
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes, @RequestParam int id) {
        productService.update(id, product);
        redirectAttributes.addFlashAttribute("mess", "Product was updated");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String showFormDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Product was deleted ");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        Product product = productService.findByName(name);
        if (product == null) {
            model.addAttribute("mess", "Product don't exist");
        } else {
            model.addAttribute("product", product);
        }
        return "detail";
    }
}
