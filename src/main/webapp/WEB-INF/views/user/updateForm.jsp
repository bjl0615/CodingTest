<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly>
        </div>
        <div class="form-group">
            <label for="password">비밀번호를 입력해주세요</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password1">
        </div>
        <div class="form-group">
            <label for="password">비밀번호를 다시 한 번 입력해주세요</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password2">
        </div>
        <div class="form-group">
            <label for="email">이메일을 입력해주세요</label>
            <input type="email" value="${principal.user.email}" class="form-control" id="email">
        </div>
    </form>
    <button id="btn-update" class="btn btn-primary">회원 수정</button>
</div>
<script src="/js/user.js"></script>
