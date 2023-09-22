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
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("blog")
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

    @GetMapping("blog/create")
    public String createForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", new Blog());
        return "create";
    }

//    @PostMapping("blog/create")
//    public String createBlog(Model model, Blog blog) {
//        blogService.save(blog);
//        model.addAttribute("mess", "Blog was created");
//        return "create";
//    }

//    @GetMapping("blog/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("blog", new Blog());
//        return "create";
//    }
//
    @PostMapping("blog/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Blog was created");
        return "redirect:/blog";
    }
    @GetMapping("blog/update")
    public String editForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("blog/update")
    public String editBlog(Model model, Blog blog) {
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

//    @GetMapping("blog/delete/{id}")
//    public String deleteForm(Model model, @PathVariable int id) {
//        Blog blog = blogService.findById(id);
//        model.addAttribute("blog", blog);
//        return "delete";
//    }
//
//    @PostMapping("delete")
//    public String deleteBlog(Model model, Blog blog) {
//        blogService.deleteById(blog.getId());
//        model.addAttribute("message", "Blog was deleted");
//        return "redirect:/blog";
//    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }


    @GetMapping("category")
    public ModelAndView categoryList() {
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category/list", "categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("category/create")
    public String createFormCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("category/create")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Category was created");
        return "redirect:/category/create";
    }

    @GetMapping("/updateCategory")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            model.addAttribute("mess", "Category don't exist");
        } else {
            model.addAttribute("category", category);
        }
        return "category/update";
    }

    @PostMapping("/updateCategory")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.edit(category);
        redirectAttributes.addFlashAttribute("mess", "Category was updated");
        return "redirect:/category/update";
    }

    @GetMapping("/deleteCategory")
    public String showFormDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(id);
        if (category == null) {
            redirectAttributes.addFlashAttribute("mess", "Category don't exist");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Category was deleted");
            blogService.deleteById(id);
        }
        return "redirect:/category/delete";
    }
}
