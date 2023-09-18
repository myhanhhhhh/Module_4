<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/16/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Mail Box</title>
    <style>
        table{
            border-collapse: collapse;
            border: 1px solid black;
        }
        tr,th,td{
            border: 1px solid black;
        }
        .mess {
            color: green;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${languages}" var="language">
        <tr>
            <td>${language.name}</td>
            <td>${language.size}</td>
            <td>${language.filter}</td>
            <td>${language.signature}</td>
            <td><a role="button" href="/language/edit?id=${language.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<span class="mess">${message}</span>
</body>
</html>