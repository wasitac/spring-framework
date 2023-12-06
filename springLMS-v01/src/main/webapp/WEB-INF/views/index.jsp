<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>index.jsp</h1>
	<form action="/login" method="get">
	<div>
		<label>학번 : </label>
		<input type="text">
	</div>
	<div>
		<label>비밀번호 :</label>
		<input type="password" placeholder="초기 비밀번호는 전화번호 입니다.">
	</div>
		<input type="submit" value="로그인">
	</form>
</body>
</html>