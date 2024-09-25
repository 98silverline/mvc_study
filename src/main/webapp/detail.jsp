<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.phone.model.dto.Phone,java.util.List"%>
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
	<%
		Phone phone = (Phone) request.getAttribute("phone");
	%>
	<tr>
		<td><%=phone.getSerialNumber() %></td>
		<td><%=phone.getModel() %></td>
		<td><%=phone.getPrice() %></td>
		<td><%=phone.getDescription() %></td>
	</tr>
</table>
<a href="/simple_phone/phone?act=delete&serial_number=<%=phone.getSerialNumber()%>">삭제</a>
<a href="/simple_phone/phone?act=mvUpdate&serial_number=<%=phone.getSerialNumber()%>">수정</a>
</body>
</html>