<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/joinProc" method = "post">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" placeholder="Enter username" id="username">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" placeholder="Enter email" id="email">
      </div>
      <div class="form-group">
         <label for="pwd1">Password</label>
         <input type="password" class="form-control" placeholder="Enter password" id="pwd1">
      </div>
      <div class="form-group">
           <label for="pwd2">Password</label>
           <input type="password" class="form-control" placeholder="Enter password" id="pwd2">
        </div>
      <div class="form-group form-check">
        <label class="form-check-label">
          <input class="form-check-input" type="checkbox"> Remember me
        </label>
      </div>

    </form>
    <button id="btn-save" class="btn btn-primary">회원가입</button>
</div>


<script src="/js/user.js"></script>
