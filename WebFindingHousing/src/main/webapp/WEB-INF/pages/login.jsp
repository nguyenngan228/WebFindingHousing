<%-- 
    Document   : login
    Created on : Jun 6, 2024, 11:40:44 AM
    Author     : thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/login" var="action"/>
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="name" placeholder="Enter email" name="username">
        <label for="email">Email</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="text" class="form-control" id="pwd" placeholder="Enter password" name="password">
        <label for="pwd">Password</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Login" class="btn btn-danger"/>
    </div>
</form>