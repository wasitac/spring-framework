<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
	<%
// 	String name = request.getParameter("name");
// 	int id = Integer.parseInt(request.getParameter("id"));
	%>
<!-- 	<h1>join.jsp</h1> -->
<%-- 	<div><%= name %>님, 가입을 환영합니다.</div> --%>
<%-- 	<div>id : <%= id %></div> --%>
	<hr>
	<h2>[el] 방법1</h2>
	<div>${param.name}님, 가입을 환영합니다.</div>
	<div>id : ${param.id}</div>
	<hr>
<!-- 	원래 되는건데 왜 안되지? -->
	<h2>[el] 방법2</h2>
	<div>${name}님, 가입을 환영합니다.</div>
	<div>id : ${id}</div>
	
</body>
</html>