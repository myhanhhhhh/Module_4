package com.example.email_box;

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

//<span class="mess">${message}</span>
//</body>
//<%@ page contentType="text/html;charset=UTF-8" language="java" %>
//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
//<html>
//<head>
//    <title>email box</title>
//</head>
//<body>
//<h1>Settings</h1>
//<form:form modelAttribute="mailBox" action="/mail/update" method="post">
//    <table>
//        <tr>
//            <td>Language</td>
//            <td>
//                <form:select path="language">
//                    <form:option value="English">English</form:option>
//                    <form:option value="Vietnamese">Vietnamese</form:option>
//                    <form:option value="Japanese">Japanese</form:option>
//                    <form:option value="Chinese">Chinese</form:option>
//                </form:select>
//            </td>
//        </tr>
//        <tr>
//            <td>Page Size:</td>
//            <td>Show
//                <form:select path="pageSize">
//                    <form:option value="5">5</form:option>
//                    <form:option value="10">10</form:option>
//                    <form:option value="15">15</form:option>
//                    <form:option value="25">25</form:option>
//                    <form:option value="50">50</form:option>
//                    <form:option value="100">100</form:option>
//                </form:select>
//                emails per page
//            </td>
//        </tr>
//        <tr>
//            <td>Spam Filter:</td>
//            <td>
//                <form:checkbox path="spamsFilter" value="Enable spams filter"/> Enable spams filter
//            </td>
//        </tr>
//        <tr>
//            <td>Signature</td>
//            <td>
//                <form:textarea path="signature" />
//            </td>
//        </tr>
//        <tr>
//            <td></td>
//            <td><form:button>Update</form:button></td>
//        </tr>
//    </table>
//</form:form>
//<br>
//<div>Language:${mailBox.language}</div>
//<div>Page Size:${mailBox.pageSize}</div>
//<div>Spams filter:${mailBox.spamsFilter}</div>
//<div>Signature:${mailBox.signature}</div>
//</body>
//</html>

}