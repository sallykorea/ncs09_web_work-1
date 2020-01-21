<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL 테스트 중...</h3>
<%
	//request에 "myName"이라는 키값으로 담긴 string type 읽어오기
	String myName=(String)request.getAttribute("myName");
%>
<p>myName: <strong><%=myName %></strong></p>

<p>myName: <strong>${requestScope.myName }</strong></p>
</body>
</html>