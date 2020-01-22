<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url=request.getParameter("url");
	if(url==null){//만일 없으면 
		//로그인 성공후에 index.jsp 페이지로 보낼수 있도록 구성한다. 
		url=request.getContextPath()+"/index.jsp";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="login.jsp" method="post">
	<input type="hidden" name="url" value="${param.url }" />
		<div>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="text" id="pwd" name="pwd" />
		</div>
		<button type="submit">로그인</button>
		<a href="../index.jsp">취소</a>
	</form>
</div>
</body>
</html>