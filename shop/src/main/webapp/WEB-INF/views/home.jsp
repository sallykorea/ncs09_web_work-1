<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/resource.jsp" />
</head>
<body>
<jsp:include page="include/navbar.jsp">
	<jsp:param value="home" name="category"/>
</jsp:include>
<div class="container">
	<h1>홈페이지 입니다.</h1>
	<h2>Best Products</h2>
	<h3>공지사항</h3>
</div>
<jsp:include page="include/footer.jsp" />
</body>
</html>