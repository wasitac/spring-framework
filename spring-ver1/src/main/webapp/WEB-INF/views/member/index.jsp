<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<!-- 과제[2]  -->
	<h1>index.jsp</h1>
	<div>member 폴더 내 index.jsp파일입니다.</div>
	<hr>
	<form action="/ver1/member/join">
	<!-- 
	절대 경로(주소) : /member/join
	상대 경로(주소) : member/join
	 -->
		<div>
			<label>id : </label>
			<input type="text" name="id">
		</div>		
		<div>
			<label>name : </label>
			<input type="text" name="name">
		</div>
		<input type="submit" value="가입">
	</form>
</body>
</html>