<%@page import="test.productDao.productDao"%>
<%@page import="test.productDto.productDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	String photo=request.getParameter("photo");
	String title=request.getParameter("title");
	String price=request.getParameter("price");
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	String content=request.getParameter("content");
	
	productDto dto=new productDto(num,photo,title,price,quantity,content,null);
	boolean isSuccess=productDao.getInstance().update(dto);
	
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
			${param.title } 상품으로 수정되었습니다.
		</p>
		<a href="../list.jsp">상품 목록으로 가기</a>
	</c:when>
	<c:otherwise>
		<p>
			상품 수정에 실패하였습니다.
		</p>
		<a href="updateProductForm.jsp?num=${param.num }">다시 수정하기</a>
		<a href="../index.jsp">홈으로 가기</a>
	</c:otherwise>
</c:choose>
</body>
</html>