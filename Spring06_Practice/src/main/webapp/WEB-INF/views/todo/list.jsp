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
	<h1>할일 목록</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>할일</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.content }</td>
					<td>${tmp.regdate }</td>
					<td><a href="updateform.hello?num=${tmp.num }">수정</a></td>
					<td><a href="delete.hello?num=${tmp.num }">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="insertform.hello">할일 추가하기</a>
</div>
</body>
</html>