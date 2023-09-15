package com.example.caculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
//    package com.example.caculator;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//import java.util.Objects;
//
//@Controller
//@RequestMapping("calculator")
//public class CalculatorController {
//    @GetMapping("")
//    public String showCal() {
//        return "calculator";
//    }
//    @PostMapping("calculate")
//    public String calculate(RedirectAttributes attributes, @RequestParam("cal")String cal, @RequestParam double num1
//            ,@RequestParam double num2) {
//            if (Objects.equals(cal, "Addition(+)")) {
//                attributes.addFlashAttribute("result", num1 + num2);
//            }
//            if (Objects.equals(cal, "Subtraction(-)")) {
//                attributes.addFlashAttribute("result", num1 - num2);
//            }
//            if (Objects.equals(cal, "Multiplication(X)")) {
//                attributes.addFlashAttribute("result", num1 * num2);
//            }
//            if (Objects.equals(cal, "Division(/)")) {
//                if (num2 == 0){
//                    attributes.addFlashAttribute("result1","Can't divide by 0");
//                }else {
//                    attributes.addFlashAttribute("result", num1 / num2);
//                }
//            }
//        return "redirect:/calculator";
//    }



//}<%--
//  Created by IntelliJ IDEA.
//  User: ADMIN
//  Date: 8/15/2023
//  Time: 1:42 PM
//  To change this template use File | Settings | File Templates.
//--%>
//<%@ page contentType="text/html;charset=UTF-8" language="java" %>
//<html>
//<head>
//    <title>Calculator</title>
//    <style>
//        .result{
//            color: green;
//        }
//        .result1{
//            color: red;
//        }
//    </style>
//</head>
//<body>
//<form action="calculator/calculate" method="post">
//    <fieldset>
//        <legend>Calculator</legend>
//    <label for="n1">Number 1</label>
//    <input type="number" name="num1" id="n1">
//    <label for="n2">Number 2</label>
//    <input type="number" name="num2" id="n2">
//    <input type="submit" name="cal" value="Addition(+)">
//    <input type="submit" name="cal" value="Subtraction(-)">
//    <input type="submit" name="cal" value="Multiplication(X)">
//    <input type="submit" name="cal" value="Division(/)">
//        <hr>
//        Result : <span class="result">${result}</span> <span class="result1">${result1}</span>
//    </fieldset>
//</form>
//</body>
//</html>
}