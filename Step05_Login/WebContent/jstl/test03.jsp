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
<h3>forTokens 사용하기</h3>
<%
	String hobby="piano/game/reading";
	request.setAttribute("hobby", hobby);
%>
<ul>
	<%-- String hobby="piano/game/reading"; 에 있는 문자열을 하나씩 빼서 출력하고 싶을때 사용한다. --%>
	<c:forTokens var="tmp" items="${hobby }" delims="/">
		<li>${tmp }</li>
	</c:forTokens>
</ul>

<h3>choose 문을 이용해서 if~else 문 구조 만들기</h3>
<%
	request.setAttribute("num", 999);
%>
<c:choose>
	<%-- 짝수를 구하기 : num을 2로 나눈 나머지가 0인 경우 --%>
	<c:when test="${requestScope.num%2 eq 0 }">
		<p>${num } 은 짝수 입니다.</p>
	</c:when>
	
	<c:otherwise>
		<p>${num } 은 홀수 입니다.</p>
	</c:otherwise>
</c:choose>

<h3>choose 문을 이용해서 다중 if문 구성하기</h3>
<%
	request.setAttribute("jumsu", 75);
%>
<p>
	획득한 점수는 <strong>${jumsu }</strong>이고
	성적은
	<c:choose>
		<c:when test="${jumsu>=90 }">
			<strong>A</strong>		
		</c:when>
		<c:when test="${jumsu>=80 }">
			<strong>B</strong>		
		</c:when>
		<c:when test="${jumsu ge 70 }">
			<strong>C</strong>		
		</c:when>
		<c:when test="${jumsu ge 60 }">
			<strong>D</strong>		
		</c:when>
		<c:when test="">
			<strong>F</strong>		
		</c:when>
	</c:choose>
	입니다.
</p>
</body>
</html>