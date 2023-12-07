<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newForm</title>
</head>
	<body>
		<form action="${pageContext.request.contextPath}/user/join" method="post">
			<div>
				<label>이름 : </label>
				<input type="text" name="name"/>
			</div>
			<div>
				<label>아이디 : </label>
				<input type="text" name="id"/>
			</div>
			<div>
				<label>비밀번호 : </label>
				<input type="password" name="password"/>				
			</div>
			<input type="submit" value="가입"/>
		</form>
	</body>
</html>