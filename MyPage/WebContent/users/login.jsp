<%@page import="java.net.URLEncoder"%>
<%@page import="test.usersdao.UsersDao"%>
<%@page import="test.usersdto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	String url=request.getParameter("url");
	if(url==null){
		url=request.getContextPath()+"/index.jsp";
	}
	//목적지 정보를 미리 인코딩 해 놓는다.
	String encodedUrl=URLEncoder.encode(url);	

	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	
	boolean isValid=UsersDao.getInstance().isValid(dto);
	if(isValid){
		session.setAttribute("id", id);
	}
	
	request.setAttribute("url", url);
	request.setAttribute("isValid", isValid);
	request.setAttribute("encodedUrl", encodedUrl);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${isValid }">
		<p>
			${param.id } 님 환영합니다!
			<a href="${url }">확인</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			로그인에 실패하였습니다! 비밀번호 혹은 아이디를 확인해주세요
			<a href="${encodedUrl }">재시도하기</a>
			<a href="../index.jsp">취소</a>
		</p>
	</c:otherwise>
</c:choose>
</body>
</html>