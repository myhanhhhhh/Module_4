package com.example.book_lib.controller;

import com.example.book_lib.model.Book;
import com.example.book_lib.model.RentDetail;
import com.example.book_lib.service.IBookService;
import com.example.book_lib.service.IRentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        String code = book.RandomCode();
        model.addAttribute("code", code);
        model.addAttribute("rentDetail", rentDetail);
        return "rent";
    }

    @PostMapping("/rent")
    public String rentBook(RedirectAttributes redirectAttributes, RentDetail rentDetail, @RequestParam int code) {
        Book book = bookService.rentBook(rentDetail.getBook().getId());
        if (book != null) {
            String code1 = book.RandomCode();
            rentDetail.setCode(Integer.parseInt(code1));
            rentDetailService.add(book.getId(), code, rentDetail.getCustomerName());
            bookService.update(book, book.getId());
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

    @PostMapping("/payBack")
    public String payBack(@RequestParam int code, RedirectAttributes redirectAttributes, Model model) {
        RentDetail rentDetail = rentDetailService.findByCode(code);
        if (rentDetail != null) {
            int id = rentDetail.getId();
            rentDetailService.delete(id);
            bookService.payBook(rentDetail.getId());
            redirectAttributes.addFlashAttribute("mess", "Paid successfully");
            return "redirect:/book";
        } else {
            model.addAttribute("mess",  "Not found: " + code);
            return "payBack";
        }
    }
}
