<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root=request.getContextPath(); 
	System.out.println("root:"+root);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h1>메인 화면</h1>
	
	<a href="<%=root %>/phone?act=list">휴대폰 목록</a>
</body>
</html>