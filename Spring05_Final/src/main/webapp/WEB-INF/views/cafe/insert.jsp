<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/private/insert.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${isSuccess }">
			<script>
				alert("저장 하였습니다.");
				location.href="${pageContext.request.contextPath }/cafe/list.do";
			</script>
		</c:when>
		<c:otherwise>
			<h1>Alert</h1>
			<p class="alert alert-danger">
				글 수정 실패!
				<a class="alert-link" href="updateform.do?num=${dto.num }">다시 시도</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>





