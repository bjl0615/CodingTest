<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" value="${subscription.username}" class="form-control" id="username" readonly>
        </div>
        <div class="form-group">
            <label for="subscriptionPeriod">구독 연장기간</label>
              <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="subscriptionPeriod" id="subscriptionPeriod">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
              </select>
        </div>
        <div class="form-group">
            <label for="username">현제 등급</label>
            <input type="text" value="${subscription.serviceType}" class="form-control" id="username" readonly>
        </div>
        <c:choose>
        <c:when test="${subscription.serviceType eq 'Basic'}">
            <div class="form-group">
                <label for="serviceType">서비스 형태</label>
                  <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="serviceType" id="serviceType">
                    <option value="none">선택안함</option>
                    <option value="Standard">Standard(2TB)</option>
                    <option value="Premium">Premium(3TB)</option>
                  </select>
            </div>
        </c:when>
        <c:when test="${subscription.serviceType eq 'Standard'}">
            <div class="form-group">
                <label for="serviceType">서비스 형태</label>
                  <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="serviceType" id="serviceType">
                    <option value="none">선택안함</option>
                    <option value="Basic">Basic(1TB)</option>
                    <option value="Premium">Premium(3TB)</option>
                  </select>
            </div>
        </c:when>
        <c:when test="${subscription.serviceType eq 'Premium'}">
            <div class="form-group">
                <label for="serviceType">서비스 형태</label>
                  <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="serviceType" id="serviceType">
                    <option value="none">선택안함</option>
                    <option value="Basic">Basic(1TB)</option>
                    <option value="Standard">Standard(2TB)</option>
                  </select>
            </div>
        </c:when>
        </c:choose>
    </form>
    <button id="sub-update" class="btn btn-primary">구독 서비스 수정</button>
</div>
<script src="/js/user.js"></script>