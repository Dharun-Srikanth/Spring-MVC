<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>Home</h1>
<c:forEach var="user" items="${users}">
    <li>${user.id}</li>
    <li>${user.name}</li>
</c:forEach>
</body>
</html>