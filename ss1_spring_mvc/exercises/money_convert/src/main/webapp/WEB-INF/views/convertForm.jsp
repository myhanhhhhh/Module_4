<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/14/2023
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <style>
    table{
      border: 1px solid black;
      border-collapse: collapse;
    }
    th,tr,td{
      border: 1px solid black;
      text-align: center;
    }
    .usd{
      width: 150px;
    }
    h2{
      margin-left: 90px;
    }
  </style>
</head>
<body>
<form action="/convert" method="post">
      <h2>Convert Money</h2>
    <table>
      <tr>
        <th>VND</th>
        <th>USD</th>
      </tr>
      <tr>
        <td><input type="number" name="vnd"></td>
        <td class="usd">${usd}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"></td>
      </tr>
    </table>
</form>
</body>
</html>