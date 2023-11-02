<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap" class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="d-flex main-section">
			<div class="product-layout my-5">
				<div class="d-flex justify-content-center">
				<h1 class="text-center">제품 등록</h1>
				</div>
				
				<section class="d-flex main-section">
					<section class="left-section col-6 bg-warning w-600 h-600">
                    	content
                    	<input type="file" class="mt-2" id="fileInput">
                	</section>
                	 <section class="right-section col-6 bg-danger w-600 h-600">
                	 <article class="bg-primary w-200 h-200">
					<input type="text" class="form-control" id="productNameInput">
					 </article>
					 <article class="bg-primary w-200 h-200">
					 <textarea class="form-control mt-2" rows="4" id="contentInput"></textarea>
					 </article>
					 <article class="bg-primary w-200 h-200">
					 <textarea class="form-control mt-2" rows="1" id="priceInput"></textarea>
					 </article>
					 </section>
			</section>
			</div>
		</section>
		<div class="d-flex justify-content-between mt-2">
					<a href="/mainmenu/mainpage-view" class="btn btn-secondary">목록으로</a>
					<button type="button" class="btn btn-secondary" id="saveBtn">저장</button>
				</div>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function() {
			$("#saveBtn").on("click", function() {
				let productName = $("#productNameInput").val();
				let content = $("#contentInput").val();
				let price = $("#priceInput").val();
 				let file = $("#fileInput")[0]; 
				
				if(productName == "") {
					alert("제목을 입력하세요");
					return ;
				}
				
				if(content == "") {
					alert("내용을 입력하세요");
					return ;
				}
				
				if(price == "") {
					alert("가격을 입력하세요");
					return ;
				}
				
				let formData = new FormData();
				formData.append("productName", productName);
				formData.append("content", content);
				formData.append("price", price);
				formData.append("imageFile", file.files[0]);
				
				$.ajax({
					type:"post"
					, url:"/product/create"
					, data:formData
					, enctype:"multipart/form-data"  
					, processData:false  
					, contentType:false   
					, success:function(data) {
						if(data.result == "success") {
							location.href = "/mainpage-view";
						} else {
							alert("제품등록 실패");
						}
						
					}
					, error:function() {
						alert("제품 등록 에러");
					}
				});
				
			});
			
			
		});
	
	</script>
</body>
</html>