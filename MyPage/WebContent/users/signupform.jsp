<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<div class="container">
	<form action="signup.jsp" method="post">
		<div>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="text" id="pwd" name="pwd" />
		</div>
		<div>
			<label for="email">이메일</label>
			<input type="text" id="email" name="email" />
		</div>
		<button type="submit">회원가입</button>
		<a href="../index.jsp">취소</a>
	</form>
</div>
</body>
</html>