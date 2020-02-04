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
	<form action="update.do" method="post">
		<input type="hidden" name="num" id="num" value="${dto.num }"/>
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" id="num" value="${dto.num }" disabled/>
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value="${dto.name }" />
		</div>
		<div>
			<label for="phone">전화번호</label>
			<input type="text" name="phone" id="phone" value="${dto.phone }" />
		</div>
		<button type="submit">저장</button>
	</form>
</div>
</body>
</html>