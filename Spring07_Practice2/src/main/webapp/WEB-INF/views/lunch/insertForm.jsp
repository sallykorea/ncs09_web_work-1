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
	<h1>점심 메뉴 추가하기</h1>
	<form action="insert.nhn" method="post">
		<label for="menu">메뉴</label>
		<input type="text" id="menu" name="menu" />
		<button type="submit">저장</button>
	</form>
</div>
</body>
</html>