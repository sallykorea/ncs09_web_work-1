<%@page import="test.users.dto.UsersDto"%>
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
	UsersDto dto=(UsersDto)request.getAttribute("dto");
%>
<p>
	아이디 : <strong><%=dto.getId() %></strong>
	이메일 : <strong><%=dto.getEmail() %></strong>
</p>

<%-- 위의 코드를 EL을 이용하면 아래와 같다 --%>
<%-- requestScope KeyWord 생략 가능 --%>
<p>
	아이디: <strong>${dto.id }</strong> 
	이메일: <strong>${dto.email }</strong>
</p>
<%-- 'dto.필드명' 으로 작성하면 알아서 getter 메소드를 불러와서 출력해 준다. --%>
<p>
	아이디: <strong>${requestScope.dto.id }</strong> 
	이메일: <strong>${requestScope.dto.email }</strong>
</p>
<%-- el을 사용하면 출력할 데이터가 없는 경우(null 값)은 찍지 않고 비워 놓는다. --%>
<p>
	아이디: <strong>${requestScope.dto.id }</strong> 
	이메일: <strong>${requestScope.dto.email }</strong>
	등록일: <strong>${requestScope.dto.regdate }</strong>
</p>
</body>
</html>