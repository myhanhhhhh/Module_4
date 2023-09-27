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
        String code = book.generateRandomCode();
        model.addAttribute("code", code);
        model.addAttribute("rentDetail", rentDetail);
        return "rent";
    }

//    @PostMapping("/rent")
//    public String rentBook(RedirectAttributes redirectAttributes, @RequestParam String customerName, @RequestParam int code) {
//        RentDetail rentDetail = rentDetailService.findByCode(code);
//        if (rentDetail != null && rentDetail.getBook().getQuantity() > 0) {
//            Book book = rentDetail.getBook();
//            int quantity = book.getQuantity() - 1;
//            book.setQuantity(quantity);
//            bookService.update(book);
//            redirectAttributes.addFlashAttribute("mess", "Rent success");
//        } else {
//            redirectAttributes.addFlashAttribute("mess", "Rent failed. Book not available.");
//        }
//        return "redirect:/book";
//    }


    @PostMapping("/rent")
    public String rentBook(RedirectAttributes redirectAttributes, RentDetail rentDetail, @RequestParam int code) {
        System.out.println(rentDetail.getBook());
        rentDetailService.add(rentDetail.getBook().getId(), code, rentDetail.getCustomerName());
        Book book = rentDetail.getBook();
        int quantity = book.getQuantity() - 1;
        book.setQuantity(quantity);
        bookService.update(book,book.getId());
        redirectAttributes.addFlashAttribute("mess", "Rent success");
        return "redirect:/book";
    }

    @GetMapping("/history")
    public String historyRent(Model model) {
        model.addAttribute("rentDetail", rentDetailService.findAll());
        return "history";
    }

    @GetMapping("/payBack")
    public String showPayBack() {
        return "rollBack";
    }

    @PostMapping("/payBack")
    public String payBack(@RequestParam int code, RedirectAttributes redirectAttributes, Model model) {
        RentDetail rentDetail = rentDetailService.findByCode(code);
        if (rentDetail != null) {
            int id = rentDetail.getId();
            rentDetailService.delete(id);
            int quantity = rentDetail.getBook().getQuantity() + 1;
            rentDetail.getBook().setQuantity(quantity);
            bookService.update(rentDetail.getBook(), rentDetail.getBook().getId());
            redirectAttributes.addFlashAttribute("mess", "Pay back success");
            return "redirect:/book";
        }
        model.addAttribute("code", code);
        return "rollBack";
    }

}
