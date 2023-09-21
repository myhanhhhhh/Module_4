package com.example.blog1.controller;

import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list", "blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("mess", "Blog was created");
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String showformUpdate(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            model.addAttribute("mess", "Blog don't exist");
        } else {
            model.addAttribute("blog", blog);
        }
        return "update";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Blog was updated");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String showFormDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("mess", "Blog don't exist");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Blog was deleted");
            blogService.delete(id);
        }
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
