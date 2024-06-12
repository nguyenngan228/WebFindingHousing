<%-- 
    Document   : header
    Created on : Jun 5, 2024, 9:39:06 PM
    Author     : thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Finding Housing</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Trang chu</a>
                </li>
                

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name !=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login"/>">Dang nhap</a>
                        </li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </div>
</nav>