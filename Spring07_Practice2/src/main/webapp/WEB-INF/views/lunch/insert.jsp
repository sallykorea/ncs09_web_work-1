<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Alert</h1>
	<c:choose>
		<c:when test="${isSuccess }">
			<p>
				<strong>${menu }</strong> 가 추가 되었습니다.
			</p>
		</c:when>
		<c:otherwise>
			<p>메뉴 추가에 실패하였습니다.</p>
		</c:otherwise>
	</c:choose>
	<p>
		
	</p>
</div>
</body>
</html>