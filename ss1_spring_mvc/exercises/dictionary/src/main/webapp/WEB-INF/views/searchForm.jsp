<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 14/09/2023
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary is Limited</h2>
<form action="/dictionary" method="post">
    <label for="eng">English</label>
    <input id="eng" name="eng">
    <button type="submit">Translate</button>
    <c:if test="${vn != null}">
        <p>Result: ${vn}</p>
    </c:if>
    <c:if test="${message != null}">
        <p>${message}</p>
    </c:if>
</form>
</body>
</html>
