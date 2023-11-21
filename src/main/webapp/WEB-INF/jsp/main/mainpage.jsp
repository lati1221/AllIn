<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

<div id="wrap">
    <c:import url="/WEB-INF/jsp/include/header.jsp" />

    <nav class="sub-menu mt-4">
        <ul class="nav d-flex align-items-center justify-content-between bg-warning">
          <li class="nav-item"><a href="/mainmenu/product" class="nav-link small-link" style="color:blueviolet">제품등록</a></li>
          <li class="nav-item"><a href="/mainmenu/productList" class="nav-link small-link" style="color:blueviolet">인기상품</a></li>
          <li class="nav-item"><a href="/user/join" class="nav-link small-link" style="color:blueviolet">회원가입</a></li>
          <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">고객센터</a></li>
          <li class="nav-item"><a href="#" class="nav-link small-link" style="color:blueviolet">장바구니</a></li>
      </ul>  
    </nav>


    <div id="searchResults" class="main-contents col-10 d-flex flex-wrap py-4">
        
    </div>

    <c:import url="/WEB-INF/jsp/include/footer.jsp" />
</div>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $("#searchForm").on("submit", function(e) {
            e.preventDefault();
            let keyword = $("#searchInput").val();

            if (keyword.trim() === "") {
                alert("검색어를 입력하세요");
                return;
            }

            $.ajax({
                url: "/search", 
                method: "GET",
                data: { "keyword": keyword },
                success: function(response) {
                    $("#searchResults").html(response);
                },
                error: function() {
                    alert("검색 오류");
                }
            });
        });
    });
</script>

</body>
</html>