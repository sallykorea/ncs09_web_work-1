<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	//1. 폼 전송되는 회원 가입 정보를 읽어온다.
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	//2. DB 에 저장하고
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setEmail(email);
	boolean isSuccess=UsersDao.getInstance().insert(dto);
	//3. 응답하기 
	
	request.setAttribute("isSuccess", isSuccess);
	request.setAttribute("dto", dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<div class="container">
	<h1>Alert</h1>
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
	
</div>
</body>
</html>





