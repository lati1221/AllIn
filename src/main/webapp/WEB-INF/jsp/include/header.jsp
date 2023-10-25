<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="d-flex align-items-center justify-content-between mt-3">
			
				<h1>ALL IN MALL</h1>
				
				<div class="search d-flex justify-content-center align-items-center">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <div class="input-group-append">
                            <button class="btn text-white" type="button">검색</button>
                        </div>
                    </div>
                </div>
				
				<c:if test="${not empty userId }">
				<div class="d-flex mr-3 text-success align-items-center justify-content-end">${userName }님 <a href="/user/logout">로그아웃</a></div>
				</c:if>
				
				<c:if test="${empty userId }">
				<div class="d-flex mr-3 text-success align-items-center justify-content-end"><a href="/user/login">로그인</a></div>
				</c:if>
				
				
</header>