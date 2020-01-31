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
	<h1>수정 폼입니다.</h1>
	<form action="update.hello" method="post">
		<input type="hidden" name="num" value="${dto.num }" />
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" value="${dto.num }" disabled/>
		</div>
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" value="${dto.content }" />
		</div>
		<div>
			<label for="regdate">작성일</label>
			<input type="text" name="regdate" value="${dto.regdate }" disabled/>
		</div>
		<button type="submit">수정</button>
	</form>
</div>
</body>
</html>