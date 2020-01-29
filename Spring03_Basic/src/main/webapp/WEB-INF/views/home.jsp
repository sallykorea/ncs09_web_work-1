<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>인덱스 페이지 입니다.</h1>
<ul>
	<li><a href="todo/list.do">할일 목록 보기</a></li>
	<li><a href="todo/list2.do">할일 목록 보기2</a></li>
	<li><a href="todo/list3.do">할일 목록 보기3</a></li>
</ul>
<h3>공지사항</h3>
<ul>
	<c:forEach var="tmp" items="${notice }">
		<li>${tmp }</li>
	</c:forEach>
</ul>

</body>
</html>