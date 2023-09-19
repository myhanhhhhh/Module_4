package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    // binding kết quả trả về của một method
    @ModelAttribute("classList")
    public String[] getClassList(){
        System.out.println("getClassList run");
        return new String[]{"C04","C05"};
    }
    @GetMapping("")
    public ModelAndView showList() {
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView =
                new ModelAndView("list", "studentList", studentList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes) {
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","Created Success");
        return "redirect:/student";
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam(name = "id",
                                       required = false,
                                       defaultValue = "-1") int detailId ,
                          Model model){
        Student student = studentService.findById(detailId);
        model.addAttribute("student", student);
        return "detail";
    }
    @GetMapping("/detail/{id}")
//    @GetMapping("/detail/{id:[2-3]}")
    public String detail2(@PathVariable int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }

}
