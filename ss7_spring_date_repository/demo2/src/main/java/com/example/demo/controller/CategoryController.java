package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";

    }

    @GetMapping("/create")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("create")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Category was created");
        return "redirect:/categories";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            model.addAttribute("mess", "Category don't exist");
        } else {
            model.addAttribute("category", category);
        }
        return "updateCategory";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.edit(category);
        redirectAttributes.addFlashAttribute("mess", "Category was updated");
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(id);
        if (category == null) {
            redirectAttributes.addFlashAttribute("mess", "Category don't exist");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Category was deleted");
            blogService.deleteById(id);
        }
        return "redirect:/categories";
    }
}
