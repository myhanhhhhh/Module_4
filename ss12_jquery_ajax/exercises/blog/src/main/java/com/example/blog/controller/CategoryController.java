package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "blog/category/list";
    }

    @GetMapping("/createCategory")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/blog/category/create";
    }

    @PostMapping("/createCategory")
    public String createCategory(Model model, Category category) {
        categoryService.save(category);
        model.addAttribute("message", "Created Successfully");
        return "/blog/category/create";
    }

    @GetMapping("/editCategory/{idCategory}")
    public String showFormEdit(Model model, @PathVariable int idCategory) {
        Category category = categoryService.findById(idCategory);
        model.addAttribute("category", category);
        return "/blog/category/edit";
    }

}
