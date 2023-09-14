package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String showFrom() {
        return "searchForm";
    }

    @PostMapping("/dictionary")
    public String search(@RequestParam String eng, Model model) {
        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("black", "đen");
        stringMap.put("white", "trắng");
        stringMap.put("red", "đỏ");
        stringMap.put("pink", "hồng");
        stringMap.put("orange", "cam");
        if (stringMap.containsKey(eng)) {
            model.addAttribute("vn", stringMap.get(eng));
            return "searchForm";
        } else {
            model.addAttribute("message", "Not found!!");
            return "searchForm";
        }
    }
}
