<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.phone.model.dto.Phone"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 화면</h1>
	
	<%
	Phone phone = (Phone) request.getAttribute("phone");
	%>
	
	<form action="/simple_phone/phone" method = "POST">
	<input type="hidden" name="act" value = "update">
	<input type="hidden" name="serial_number" value = "<%=phone.getSerialNumber()%>">
		<!-- 모델 -->
		<label><input type = "text" name="model" value = "<%=phone.getModel()%>"> 모델 </label>
		<br>
		<!-- 가격 -->
		<label><input type = "number" name="price" value = "<%=phone.getPrice()%>"> 가격 </label>
		<br>
		<!-- 설명 -->
		<label><textarea name="description"><%=phone.getDescription()%></textarea></label>
		<input type="submit" value="수정">
	</form>
</body>
</html>