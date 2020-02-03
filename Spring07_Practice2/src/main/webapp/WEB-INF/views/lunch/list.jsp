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
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>메뉴</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<tb>${tmp.num }</tb>
					<tb>${tmp.menu }</tb>
					<tb>${tmp.regdate }</tb>
					<tb><a href="updateForm.nhn?num=${tmp.num }">수정</a></tb>
					<tb><a href="delete.nhn?num=${tmp.num }">삭제</a></tb>
				</tr>
			</c:forEach>
		</tbody>
		<a href="insertForm.nhn">점심 메뉴 추가하기</a>
	</table>
</div>
</body>
</html>