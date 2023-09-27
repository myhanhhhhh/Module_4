package com.example.book_lib.controller;

import com.example.book_lib.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }
}
