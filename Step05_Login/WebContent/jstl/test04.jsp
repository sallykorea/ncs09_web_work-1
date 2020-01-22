<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("size", 123456789);
	request.setAttribute("weight", 1234.56789);
	request.setAttribute("price", 1250000);
%>
<h3>JSTL fmt 테스트</h3>
<%-- formmating 날짜, 시간에 관한 형식을 처리하는 기능 --%>
<p>size : <strong>${size }</strong>byte</p>
<p>size : <strong><fmt:formatNumber value="${size }"/></strong>byte</p>
<p>weight : <strong>${weight }</strong>kg</p>
<p>weight : <strong><fmt:formatNumber value="${weight }"/></strong>kg</p> //defalut : 소수점 4번째 자리에서 반올림
<p>weight : <strong><fmt:formatNumber value="${weight }" pattern="#,###.##"/></strong>kg</p>
<p>노트북 price : <strong>${price }</strong></p>
<p>노트북 price : <strong><fmt:formatNumber value="${price }" type="currency" currencySymbol="$" /></strong></p>
</body>
</html>