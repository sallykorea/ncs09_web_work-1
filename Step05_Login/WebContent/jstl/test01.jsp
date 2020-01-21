<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	core libaray를 접두어 'c'로 불러오기 prefix는 마음대로 정할 수 있으나 
	통상 'c'로 한다.
--%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSTL (Java Standard Tag Libarary 사용하기)</h3>
<c:forEach var="i" begin="1" end="5">
	<p>${i }</p>
</c:forEach>

<%-- true 일때 출력 --%>
<c:if test="${sessionScope.id==null }">
	<p>로그인이 안된 상태입니다.</p>
</c:if>

<c:if test="${empty sessionScope.id }">
	<p>로그인이 안된 상태입니다.</p>
</c:if>

<c:if test="${sessionScope.id!=null }">
	<p><strong>${sessionScope.id }</strong> 로 로그인된 상태입니다.</p>
</c:if>

<c:if test="${not empty sessionScope.id }">
	<p><strong>${sessionScope.id }</strong> 로 로그인된 상태입니다.</p>
</c:if>
</body>
</html>