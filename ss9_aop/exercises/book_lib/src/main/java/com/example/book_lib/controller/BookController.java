package com.example.book_lib.controller;

import com.example.book_lib.model.Book;
import com.example.book_lib.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
