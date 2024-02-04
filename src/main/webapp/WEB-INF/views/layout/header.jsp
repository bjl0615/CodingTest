<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
    <c:choose>
        <c:when test="${empty principal}">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
                <li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
                <c:choose>
                    <c:when test="${principal.user.role eq 'ADMIN'}">
                        <li class="nav-item"><a class="nav-link" href="/select">구독자 현황</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="/sub/${principal.user.username}">구독 현황</a></li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
            </ul>
        </c:otherwise>
    </c:choose>
</nav>
<br>

