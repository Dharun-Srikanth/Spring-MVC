<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous" defer></script>

<body>
<div class="container d-flex flex-column justify-content-center align-items-center min-vh-100 px-5">
<h1>Register Page</h1>
<form:form action="registerUser" method="POST" modelAttribute="user">
    <div class="container w-75 pt-4">
        <h2 class="text-center d-flex justify-content-center">Register</h2>
        <div class="mb-3">
            <label for="name" class="form-label">First Name</label>
            <form:input type="text" class="form-control" id="name" path="name" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input type="email" class="form-control" id="email" path="email" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input type="text" class="form-control" id="password" path="password" />
        </div>
        <div class="mb-3">
            <label for="cPassword" class="form-label">Confirm Password</label>
            <form:input type="text" class="form-control" id="cPassword" path="confirmPassword" />
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            Male <form:radiobutton path="gender" value="Male" />
            Female <form:radiobutton path="gender" value="Female" />
        </div>
        <div class="mb-3">
            <label for="languages" class="form-label">Language</label>
            Tamil <form:checkbox path="languages" value="Tamil" />
            English <form:checkbox path="languages" value="English" />
            Hindi <form:checkbox path="languages" value="Hindi" />
            Telugu <form:checkbox path="languages" value="Telugu" />
        </div>
        <div class="mb-3">
            <label for="country" class="form-label">Country  </label>
            <form:select path="userCountry">
            <form:option value=" " label="--Select--" />
                <form:option value="India" label="India" />
                <form:option value="Canada" label="Canada" />
                <form:option value="USA" label="USA" />
                <form:option value="Japan" label="Japan" />
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button><span><a href="/Spring-MVC">Login Here</a></span>
    </div>
</form:form>

</div>
</body>
</html>
