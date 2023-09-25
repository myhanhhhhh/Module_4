package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String blogList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           @RequestParam(required = false, defaultValue = "0") int id, Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("time").descending());
        Page<Blog> blogPage = blogService.searchByName(pageable, searchName, id);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("categories", categoryService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Blog was created");
        return "redirect:/blog";
    }

    @GetMapping("update")
    public String editForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("update")
    public String update(Model model, Blog blog) {
        blogService.edit(blog);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("mess", "Blog ");
        return "update";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("mess", "Blog don't exist");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Blog was deleted");
            blogService.deleteById(id);
        }
        return "redirect:/blog";
    }
}
