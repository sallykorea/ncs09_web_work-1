<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<%
	//Model(data)
	List<String> names=new ArrayList<>();
	names.add("김구라");
	names.add("해골");
	names.add("원숭이");
	
	request.setAttribute("names", names);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach 활용</title>
</head>
<body>
<h3>ForEach 활용</h3>
<h4>친구 목록입니다.</h4>
<ul>
	<c:forEach var="tmp" items="${requestScope.names }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
<h4>친구 목록입니다.</h4>
<ul>
	<c:forEach var="tmp" items="${requestScope.names }" varStatus="status">
		<li>
			<%-- index 값을 알 수 있다. --%>
			status.index : <strong>${status.index }</strong>
			<%-- 순서 혹은 갯수를 알고 싶은 경우 --%>
			status.count : <strong>${status.count}</strong>
			<%-- 배열의 가장 첫번째 값을 알고 싶은 경우 --%>
			status.first : <strong>${status.first }</strong>
			<%-- 배열의 가장 마지막번째 값을 알고 싶은 경우 --%>
			status.last : <strong>${status.last }</strong>
			${tmp }
		</li>
	</c:forEach>
</ul>
</body>
</html>