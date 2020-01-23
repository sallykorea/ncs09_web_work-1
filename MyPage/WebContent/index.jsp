<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String id=(String)session.getAttribute("id");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homepage</title>
<style>
	body{
		background: 
	}
</style>
</head>
<body>
    <div class="container_hom_nav">
        <ul class="hom_nav_menu">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="product/insertProductForm.jsp">상품등록하기</a></li>
            <li><a href="product/list.jsp">상품목록보기</a></li>
            <li><a href="board/review.jsp">Review</a></li>
            <li><a href="board/notice.jsp">공지사항</a></li>
        </ul>

        <c:choose>
				<c:when test="${empty sessionScope.id }">
					<div>
						<a href="${pageContext.request.contextPath }/users/loginform.jsp">로그인</a>
						<a href="${pageContext.request.contextPath }/users/signupform.jsp">회원가입</a>
					</div>
				</c:when>
				<c:otherwise>
					<p>
						<strong><a href="${pageContext.request.contextPath }/users/private/info.jsp">${sessionScope.id }</a></strong>
						<a href="${pageContext.request.contextPath }/users/logout.jsp">로그아웃</a> 
					</p>
				</c:otherwise>
			</c:choose>
    </div>
</body>
</html>