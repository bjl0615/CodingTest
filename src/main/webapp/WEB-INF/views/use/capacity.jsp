<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <input type="hidden" id="username" value="${principal.user.username}" />
        <div class="container">
            <div class="row mt-5">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">파일 업로드</h5>
                            <form id="uploadForm">
                                <div class="form-group">
                                    <label for="fileInput">파일 선택</label>
                                    <input type="file" class="form-control-file" id="fileInput" required>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <button id="use-storage" class="btn btn-primary">업로드</button>
</div>
<script src="/js/user.js"></script>