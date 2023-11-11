package com.example.demo.controller;

import com.example.demo.dto.NewsDto;
import com.example.demo.model.Category;
import com.example.demo.model.News;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.INewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;

    @ModelAttribute("typeEdit")
    List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<News> newsPage = newsService.findAll(pageable, searchName);
        model.addAttribute("newsPage", newsPage);
        model.addAttribute("searchName", searchName);
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newsDto", new NewsDto());
        return "/add";
    }

    @PostMapping("/add")
    public String add(@Validated NewsDto newsDto, BindingResult bindingResult, Model model, RedirectAttributes redirect) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("newsDto", newsDto);
//            return "/add";
//        } else {
            News news = new News();
            BeanUtils.copyProperties(newsDto, news);
            newsService.add(news);
            redirect.addFlashAttribute("mess", "Created successfully");
            return "redirect:/news";

    }

    @GetMapping("/delete")
    String delete(@RequestParam int id, RedirectAttributes redirect) {
        redirect.addFlashAttribute("mess", "deleted successfully!");
        newsService.delete(id);
        return "redirect:/news";
    }

    @GetMapping("/detail/{newsId}")
    public String studentDetail(@PathVariable(name = "newsId") int newsId, Model model){
        News news = this.newsService.findbyId(newsId);
        model.addAttribute("news",news);
        return "/detail";
    }


}
