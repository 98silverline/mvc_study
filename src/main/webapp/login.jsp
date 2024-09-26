<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<%
		String userId = "";
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("userId")) {
				userId = cookie.getValue();
				break;
			}
		}
		System.out.println("쿠키에 저장한 아이디 : "+userId);
	%>
	
	
	
	<form action="/simple_phone/phone">
		<input type="hidden" name="act" value="login"> 
		<label><input type="text" name="id" value="${cookie.userId.value}"> 아이디</label>
		<label>아이디 저장 <input type="checkbox" name="saveid" ${empty cookie.userId?"":"checked"}></label>
		<br>
		<label><input type="password" name="password"> 비밀번호</label>
		<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>