<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 15/09/2023
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/condiments/save" method="post">
    <h2 style="margin-left: 40px">Sandwich Condiments</h2>
    <label for="lecttuce">Lecttuce</label>
    <input type="checkbox" id="lecttuce" name="condiment" value="lecttuce">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="tomato" name="condiment" value="tomato">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="mustard" name="condiment" value="mustard">
    <label for="sprouts">Sprouts</label>
    <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
    <br>
    <p style="margin-left: 130px" >${message}</p>
    <input style="margin-left: 130px" type="submit" value="submit">
</form>
</body>
</html>
