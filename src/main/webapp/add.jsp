<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>추가 화면</h1>
	
	<form action="/simple_phone/phone" method = "POST">
	<input type="hidden" name="act" value = "add">
		<!-- 모델 -->
		<label><input type = "text" name="model"> 모델 </label>
		<br>
		<!-- 가격 -->
		<label><input type = "number" name="price"> 가격 </label>
		<br>
		<!-- 설명 -->
		<label><textarea name="description"></textarea></label>
		<input type="submit" value="추가">
		
	</form>
</body>
</html>