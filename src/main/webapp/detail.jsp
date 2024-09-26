<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 상세 페이지 </h1>
<a href="/simple_phone/phone?act=list">목록으로</a>
<table>
	<tr>
		<th>시리얼넘버</th>
		<th>모델</th>
		<th>가격</th>
		<th>설명</th>
	</tr>
	<tr>
		<td>${phone.serialNumber}</td>
		<td>${phone.model}</td>
		<td>${phone.price}</td>
		<td>${phone.description}</td>
	</tr>
</table>
<a href="/simple_phone/phone?act=delete&serial_number=${phone.serialNumber}">삭제</a>
<a href="/simple_phone/phone?act=mvUpdate&serial_number=${phone.serialNumber}">수정</a>
</body>
</html>