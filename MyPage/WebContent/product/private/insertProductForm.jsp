<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateProductForm.jsp</title>
<jsp:include page="../../include/resource.jsp"></jsp:include>
<style>
	/* 프로필 이미지가 가로 세로 50px 인 원형으로 표시 될수 있도록  */
	.productLink{
		height: 90px;
		width: auto;
		background-color: blue;
		margin: 20px;
	}
</style>
</head>
<body>
<div class="container">
		
	<div id="productLink">
		<img src="" alt="" />
	</div>
	
	<form action="imageUpload.jsp" method="post" enctype="multipart/form-data" id="productPic">
		<div>
			<label for="photo">사진</label>
			<input type="file" id="photo1" name="photo" accept=".jpg, .jpeg, .png, .JPG, .JPEG" />
		</div>
	</form>
	
	<form action="insertProduct.jsp" method="post">
		<input type="hidden" name="photo" id="photo2" />
		<div>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" />
		</div>
		<div>
			<label for="price">가격</label>
			<input type="text" id="price" name="price" />
		</div>
		<div>
			<label for="quantity">재고수량</label>
			<input type="text" id="quantity" name="quantity" />
		</div>
		<div>
			<label for="content">상품 설명</label>
			<input type="text" id="content" name="content" />
		</div>
	<button type="submit">저장</button>
	<a href="../index.jsp">취소</a>
	</form>
</div>
<%-- jquery form  플러그인 javascript 로딩 --%>
<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>
<script>
	//input type="file" 에 파일이 선택되면 
	$("#photo1").on("change", function(){
		//폼을 강제 제출하고 
		$("#productPic").submit();
	});

	//jquery form 플러그인의 동작을 이용해서 폼이 ajax 로 제출되도록 한다. 
	$("#productPic").ajaxForm(function(responseData){
		//responseData 는 plain object 이다.
		//{savedPath:"/upload/저장된이미지파일명"}
		//savedPath 라는 방에 저장된 이미지의 경로가 들어 있다.
		var src="${pageContext.request.contextPath }"+responseData.savedPath;
		// img 의 src 속성에 반영함으로써 이미지가 업데이트 되도록 한다.
		$("#productLink img").attr("src", src);
		
		$("#photo2").val(responseData.savedPath);
	});
</script>
</body>
</html>