<%--
  Created by IntelliJ IDEA.
  User: kirya
  Date: 07.12.2020
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список книг</title>
</head>
<body>
<h1>Список книг</h1>
<ol>
    <c:forEach var="book" items="${listBooks}">
        <li>"${book.name}". ${book.author}. ${book.publishedYear}</li>
    </c:forEach>
</ol>
</body>
</html>