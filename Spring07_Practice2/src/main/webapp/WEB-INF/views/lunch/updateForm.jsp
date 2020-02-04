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
	<h1>Alert</h1>
	<form action="update.nhn" method="post">
		<input type="hidden" name="num" value="${dto.num }" />
		<div>
			<label for="num">번호</label>
			<input type="text" id="num" name="num" value="${dto.num }" disabled="disabled"/>
		</div>
		<div>
			<label for="menu">메뉴</label>
			<input type="text" id="num" name="num" value="${dto.menu }" />
		</div>
		<div>
			<label for="regdate">작성일</label>
			<input type="text" id="regdate" name="regdate" value="${dto.regdate }" />
		</div>
		<button type="submit">수정</button>
	</form>
</div>
</body>
</html>