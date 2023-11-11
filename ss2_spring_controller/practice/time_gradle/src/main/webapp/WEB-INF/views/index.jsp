<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 15/09/2023
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Current Local Time Arround the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="world-clock" method="post">
  <select name="city" onchange="document.getElementById('locale').submit()">
    <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
    <option value="Asia/Ho_Chi_Minh" >Ho Chi Minh</option>
  </select>

</form>
</body>
</html>
