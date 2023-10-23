<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<title>메인 페이지</title>
</head>
<body>

<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<nav class="sub-menu mt-4">
                    <ul class="nav d-flex align-items-center justify-content-between bg-warning">
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">로그인</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">회원가입</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">고객센터</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">장바구니</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">장바구니</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">장바구니</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">장바구니</a></li>
                    </ul>                        
                </nav>
                <section class="contents bg-primary">
                <div class="text-white">잘 나오나?</div>
                </section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>
</html>