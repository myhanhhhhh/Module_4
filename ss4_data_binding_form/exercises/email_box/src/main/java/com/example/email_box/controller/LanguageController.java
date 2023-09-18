package com.example.email_box.controller;

import com.example.email_box.model.Language;
import com.example.email_box.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    ILanguageService languageService;

    @GetMapping("")
    public String showForm(Model model) {
        List<Language> languages = languageService.display();
        model.addAttribute("languages", languages);
        return "list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model) {
        Language language = languageService.findID(id);
        List<String> stringList = languageService.displayName();
        List<Integer> integerList = languageService.displaySize();
        model.addAttribute("language", language);
        model.addAttribute("listName", stringList);
        model.addAttribute("listSize", integerList);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Language language, RedirectAttributes redirectAttributes, @RequestParam int id) {
        languageService.update(language, id);
        redirectAttributes.addFlashAttribute("message", "Email was updated");
        return "redirect:/language";
    }
}
