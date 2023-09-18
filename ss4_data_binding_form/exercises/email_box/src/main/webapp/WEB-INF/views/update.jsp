<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
<h3>Setting</h3>
<form:form modelAttribute="language" action="/language/edit" method="post">
    <form:hidden path="id"></form:hidden>
    Languages:
    <form:select path="name">
        <form:option value="NONE"> --SELECT--</form:option>
        <form:options items="${listName}"></form:options>
    </form:select>
    <br>
    Page Size: Show
    <form:select path="size">
        <form:option value="0"> --SELECT--</form:option>
        <form:options items="${listSize}"></form:options>
    </form:select>
    emails per page
    <br>
    Spam filter:
    <form:checkbox path="filter" value="Enable spams filter"/>
    Enable spams filter
    <br>
    Signature:
    <form:textarea path="signature"></form:textarea>
    <br>
    <form:button>Submit</form:button>
    <a role="button" href="/language">Cancel</a>
</form:form>
</body>
</html>
