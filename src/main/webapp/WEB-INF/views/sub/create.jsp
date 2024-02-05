<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
    <form>
        <input type="hidden" id="username" value="${principal.user.username}" />
        <div class="form-group">
            <label for="numberOfUsers">인원 수</label>
              <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="numberOfUsers" id="numberOfUsers">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
        </div>
        <div class="form-group">
            <label for="serviceType">서비스 형태</label>
              <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="serviceType" id="serviceType">
                <option value="Basic">Basic(1TB)</option>
                <option value="Standard">Standard(2TB)</option>
                <option value="Premium">Premium(3TB)</option>
              </select>
        </div>
        <div class="form-group">
            <label for="subscriptionPeriod">구독기간</label>
              <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="subscriptionPeriod" id="subscriptionPeriod">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
              </select>
        </div>
        <div class="form-group">
            <label for="companyName">회사이름</label>
              <input type="text" class="form-control" placeholder="회사이름을 입력해주세요" id="companyName">
        </div>
        <div class="form-group">
            <label for="phoneNumber">전화번호</label>
             <input type="text" class="form-control" placeholder="전화번호를 입력해주세요" id="phoneNumber">
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" class="form-control" placeholder="이메일을 입력해주세요" id="email">
        </div>
        <div class="form-group">
            <label for="address">주소</label>
              <input type="address" class="form-control" placeholder="주소를 입력해주세요" id="address">
        </div>
    </form>
    <button id="sub-create" class="btn btn-primary">구독 신청</button>

</div>
<script src="/js/user.js"></script>
