<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.phone.model.dto.Phone,java.util.List"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 목록 페이지 </h1>
<a href="/simple_phone/phone?act=mvAdd">휴대폰 정보 추가</a>
<table>
	<tr>
		<th>시리얼넘버</th>
		<th>모델</th>
		<th>가격</th>
	</tr>
	<c:forEach var="phone" items="${list}">
		<tr>
			<td>${phone.serialNumber}</td>
			<td><a href="/simple_phone/phone?act=detail&serial_number=${phone.serialNumber}">${phone.model}</a></td>
			<td>${phone.price}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>