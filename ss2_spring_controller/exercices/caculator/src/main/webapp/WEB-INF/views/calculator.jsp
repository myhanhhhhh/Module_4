<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 15/09/2023
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator/calculate" method="post">
    <h2 style="margin-left: 180px">Calculator</h2>
    <label for="number1">Number 1</label>
    <input type="number" id="number1" name="number1">
    <label for="number2">Number 2</label>
    <input type="number" id="number2" name="number2">
    <br><br>
    <input type="submit" name="calculate" value="Addition(+)">
    <input type="submit" name="calculate" value="Subtraction(-)">
    <input type="submit" name="calculate" value="Mutiplication(*)">
    <input type="submit" name="calculate" value="Division(/)">
    <br><br>
    Result: <span style="color: green">${result}</span>
    <span style="color: red">${error}</span>
</form>
</body>
</html>
