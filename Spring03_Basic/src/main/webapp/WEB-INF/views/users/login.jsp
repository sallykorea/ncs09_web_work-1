<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.getAttribute("isSuccess");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>alert</h1>
<c:choose>
	<c:when test="${isSuccess }">
		<p>
			<strong>${id }</strong> 님 로그인 되었습니다.
			<a href="${pageContext.request.contextPath }/">확인</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			아이디 혹은 비밀번호가 틀렸습니다.
			<a href="${pageContext.request.contextPath }/users/loginform.do">확인</a>
		</p>
	</c:otherwise>
</c:choose>
</body>
</html>