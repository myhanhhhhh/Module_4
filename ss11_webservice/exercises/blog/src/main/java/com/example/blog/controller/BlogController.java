package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           @RequestParam(required = false, defaultValue = "") String id,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("name").descending());
        Page<Blog> blogPage;
        if (Objects.equals(id, "")) {
            blogPage = blogService.searchByName(pageable, searchName);
        } else {
            blogPage = blogService.searchByName(pageable, searchName, Integer.parseInt(id));
        }
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("categories", categoryService.findAll());
        return "/blog/list";
    }

    @GetMapping("/create")
    public String ShowFormCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }
    @PostMapping("/create")
    public String createBlog(Model model, Blog blog) {
        blogService.save(blog);
        model.addAttribute("message", "Created Successfully");
        return "/blog/create";
    }

    @GetMapping("/edit/{id}")
    public String ShowFormEdit(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Model model, Blog blog) {
        blogService.edit(blog, blog.getId());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("message", "Edited Successfully");
        return "/blog/edit";
    }
    @GetMapping("/delete/{id}")
    public String ShowFormDelete(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Model model, Blog blog) {
        blogService.deleteById(blog.getId());
        model.addAttribute("message", "Deleted Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }


}
