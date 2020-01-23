<%@page import="test.productDao.productDao"%>
<%@page import="test.productDto.productDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	//photo title price quantity content
	String photo=request.getParameter("photo");
	String title=request.getParameter("title");
	String price=request.getParameter("price");
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	String content=request.getParameter("content");
	
	productDto dto=new productDto(0,photo,title,price,quantity,content,null);
	boolean isSuccess=productDao.getInstance().insert(dto);
	
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
			<strong>${param.title }</strong> 상품을 등록하였습니다!
		</p>
		<a href="../product/list.jsp">확인하기</a>
	</c:when>
	<c:otherwise>
		<p>
			상품 등록에 실패하였습니다.
		</p>
		
	</c:otherwise>
</c:choose>
<a href="updateProductForm.jsp">재등록하기</a>
<a href="../index.jsp">취소</a>
</body>
</html>