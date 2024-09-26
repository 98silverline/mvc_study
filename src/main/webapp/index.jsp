<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.phone.model.dto.Member"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h1>메인 화면</h1>
	
	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<a href="${root }/phone?act=mvLogin">로그인</a>		
		</c:when>
		<c:otherwise>
			<a href="${root}/phone?act=logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	<a href="${root }/phone?act=list">휴대폰 목록</a>
</body>
</html>