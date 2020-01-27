<%@page import="test.productDto.productDto"%>
<%@page import="java.util.List"%>
<%@page import="test.productDao.productDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%
	List<productDto> list=productDao.getInstance().getList();
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop/list.jsp</title>
<style>
	img{
		width: 60px;
		height: auto;	
	}
</style>
</head>
<body>
<a href="../index.jsp">홈으로 가기</a>
<div class="container">
<h1>상품 목록</h1>
	<table>
		<thead>
			<tr>
				<th>상품ID</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.num }</td>
					<td>
						<img src="${pageContext.request.contextPath }/${tmp.photo }" alt="" />
					</td>
					<td>
						${tmp.title }
						<div>
							<a href="${pageContext.request.contextPath }/product/private/updateProductForm.jsp?num=${tmp.num }">상품수정</a>
						</div>
					</td>
					<td>
						${tmp.price }
					</td>
					<td>${tmp.content }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>