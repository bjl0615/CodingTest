<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <div class="container">
            <h2>구독 상세 정보</h2>
            <c:if test="${not empty subscription}">
                <table class="table">
                    <tr>
                        <th>ID : </th>
                        <td>${subscription.username}</td>
                    </tr>
                    <tr>
                        <th>서비스 형태</th>
                        <td>${subscription.serviceType}</td>
                    </tr>
                    <tr>
                        <th>사용인원</th>
                        <td>${subscription.numberOfUsers} 명</td>
                    </tr>
                    <tr>
                        <th>사용량 / 남은 용량 / 스토리지 용량</th>
                        <td>${subscription.useStorageCapacity}MB / ${subscription.remainStorageCapacity}MB / ${subscription.storageCapacity}MB</td>
                    </tr>
                    <tr>
                        <th>구독기간</th>
                        <td>${subscription.subscriptionPeriod} 개월</td>
                    </tr>
                </table>
                <a class="nav-link" href="/sub/update/${subscription.username}">기간 연장</a>
                <a class="nav-link" href="/use">사용하기</a>
            </c:if>
            <c:if test="${empty subscription}">
                <p>해당 ID에 대한 구독 정보가 없습니다.</p>
                <a class="nav-link" href="/create">구독 신청</a>
            </c:if>
        </div>
</div>