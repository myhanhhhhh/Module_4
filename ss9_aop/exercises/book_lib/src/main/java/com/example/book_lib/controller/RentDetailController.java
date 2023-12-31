package com.example.book_lib.controller;

import com.example.book_lib.model.Book;
import com.example.book_lib.model.RentDetail;
import com.example.book_lib.service.BookService;
import com.example.book_lib.service.IBookService;
import com.example.book_lib.service.IRentDetailService;
import com.example.book_lib.utils.BookNotFoundException;
import com.example.book_lib.utils.CodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.transaction.Transactional;
import javax.validation.Valid;


@Controller
@RequestMapping("/rent")
public class RentDetailController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRentDetailService rentDetailService;

    @GetMapping("/rent/{id}")
    public String showRentBook(@PathVariable int id, Model model) {
        RentDetail rentDetail = new RentDetail();
        Book book = bookService.finById(id);
        rentDetail.setBook(book);
        String code = BookService.randomCode();
        model.addAttribute("code", code);
        model.addAttribute("rentDetail", rentDetail);
        return "rent";
    }

    @Transactional
    @PostMapping("/rent")
    public String rentBook(@Valid RedirectAttributes redirectAttributes, RentDetail rentDetail, @RequestParam int code,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rent";
        }
        try {
            Book book = bookService.rentBook(rentDetail.getBook().getId());
            if (book != null) {
                String code1 = BookService.randomCode();
                rentDetail.setCode(Integer.parseInt(code1));
                rentDetailService.add(book.getId(), code, rentDetail.getCustomerName());
                bookService.update(book, book.getId());
            } else {
                throw new BookNotFoundException("Rented failed");
            }
        } catch (BookNotFoundException e) {
            redirectAttributes.addFlashAttribute("mess", "Rented fail");
        }
        redirectAttributes.addFlashAttribute("mess", "Rented successfully");
        return "redirect:/book";
    }

    @GetMapping("/history")
    public String historyRent(Model model) {
        model.addAttribute("rentDetail", rentDetailService.findAll());
        return "history";
    }

    @GetMapping("/payBack")
    public String showPayBack() {
        return "payBack";
    }

    @Transactional
    @PostMapping("/payBack")
    public String payBack(@Valid @RequestParam int code, RedirectAttributes redirectAttributes, Model model,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "payBack";
        }
        RentDetail rentDetail = rentDetailService.findByCode(code);
        try {
            if (rentDetail != null) {
                rentDetail.setStatus(1);
                bookService.payBook(rentDetail.getBook().getId());
                bookService.update(rentDetail.getBook(), rentDetail.getBook().getId());
                redirectAttributes.addFlashAttribute("mess", "Paid successfully");
                return "redirect:/book";
            } else {
                throw new CodeNotFoundException("Code not found");
            }
        } catch (CodeNotFoundException e) {
            model.addAttribute("mess", "Not found: " + code);
        }
        return "payBack";
    }
}
