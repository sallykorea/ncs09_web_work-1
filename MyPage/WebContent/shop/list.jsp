<%@page import="test.productDto.productDto"%>
<%@page import="java.util.List"%>
<%@page import="test.productDao.productDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	List<productDto> list=productDao.getInstance().getList();
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<ul>
		<c:forEach>
			<li><a href="">${ }</a></li>
		</c:forEach>
	</ul>
</div>
<a href="">구매하기</a>
</body>
</html>