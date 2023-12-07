<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userLogin</title>
</head>
<body>
	<form action="user/login" method="post">
		<div>
			<label>아이디 : </label>
			<input type="text" name="id"/>
		</div>
		<div>
			<label>비밀번호 : </label>
			<input type="password" name="name"/>
		</div>
		<input type="submit" value="로그인"/>
	</form>
	<a href="user/join">회원가입</a>
</body>
</html>