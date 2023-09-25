package com.example.form_login.controller;

import com.example.form_login.dto.UserDto;
import com.example.form_login.model.User;
import com.example.form_login.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("")
    public String create(@Valid @ModelAttribute UserDto userDto,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.addUser(user);
        model.addAttribute("mess", "Login Success");
        return "result";
    }
}
