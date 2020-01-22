<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateProductForm.jsp</title>
</head>
<body>
<div class="container">
	<form action="updateproduct.jsp">
		<div>
			<label for="photo">사진</label>
			<input type="file" id="photo" name="photo" />
		</div>
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
</body>
</html>