<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <div class="container">
        <h2>유저구독 상세 정보</h2>
        <table class="table">
        <c:forEach var="list" items="${list}">
                <tr>
                    <th>ID : </th>
                    <td>${list.username}</td>
                </tr>
                <tr>
                    <th>서비스 형태</th>
                    <td>${list.serviceType}</td>
                </tr>
                <tr>
                    <th>사용인원</th>
                    <td>${list.numberOfUsers} 명</td>
                </tr>
                <tr>
                    <th>사용량 / 남은 용량 / 스토리지 용량</th>
                    <td>${list.useStorageCapacity}MB / ${list.remainStorageCapacity}MB / ${list.storageCapacity}MB</td>
                </tr>
                <tr>
                    <th>구독기간</th>
                    <td>${list.subscriptionPeriod} 개월</td>
                </tr>
        </c:forEach>
        </table>
    </div>
</div>