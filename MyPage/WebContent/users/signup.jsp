<%@page import="test.usersdao.UsersDao"%>
<%@page import="test.usersdto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	
	UsersDto dto=new UsersDto(id,pwd,email,null);
	
	boolean isSuccess=UsersDao.getInstance().insert(dto);

	request.setAttribute("isSuccess", isSuccess);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess }">
		<p> 
			<strong>${param.id }</strong> 회원님 가입 되었습니다.
			<a href="loginform.jsp">로그인 하러 가기</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			회원 가입 실패!
			<a href="signup_form.jsp">다시 가입하러 가기</a>
		</p>
	</c:otherwise>
</c:choose>
</body>
</html>