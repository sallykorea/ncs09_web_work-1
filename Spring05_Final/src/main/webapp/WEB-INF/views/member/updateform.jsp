<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>회원정보 수정 페이지</h1>
	<form action="update.do">
		<input type="hidden" name="num" value="${dto.num }" />
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" id="num" value="${dto.num }" disabled/>
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value="${dto.name }" />
		</div>
		<div>
			<label for="addr">주소</label>
			<input type="text" name="addr" id="addr" value="${dto.addr }" />
		</div>
		<button type="submit">수정</button>
	</form>
</div>
</body>
</html>