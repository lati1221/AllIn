<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<header>
			<div id="title" class="text-center"><h1>ALL IN MALL</h1></div>
			<nav class="sub-menu col-4 d-flex align-items-end justify-content-end">
                    <ul class="nav">
                        <li class="nav-item"><a href="#" class="nav-link small-link">로그인</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link">회원가입</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link">고객센터</a></li>
                        <li class="nav-item"><a href="#" class="nav-link small-link">장바구니</a></li>
                    </ul>                        
                </nav>
		</header>
		<section class="contents d-flex justify-content-center">
			<div class="input-box my-5">
				
							<form id="loginForm">
							<input type="text" placeholder="아이디" class="form-control mt-4" id="loginIdInput">
							<input type="password" placeholder="비밀번호" class="form-control mt-2" id="passwordInput">
							<button type="submit" class="btn btn-block mt-3 text-white" id="loginBtn">로그인</button>
						</form>
				<div class="text-center mt-3">
					<a href="/user/join">회원가입</a>
				</div>
			</div>
		</section>
		<footer></footer>
	</div>
</body>
</html>