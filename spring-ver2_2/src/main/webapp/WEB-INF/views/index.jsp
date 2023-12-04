<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행복한 마켓</title>
</head>
<body>
	<h1>행복한 마켓</h1>
	<div>회원 관리</div>
	<div>
		<a href="member/new">회원 가입</a>
		<a href="member/list">회원 목록</a>
	</div>
	<form action="member/search" method="get">
		<fieldset>
			<legend>[검색하기]</legend>
			<div>
				<label>아이디로 검색 : </label>
				<input type="text" name="id" placeholder="아이디를 입력하세요...">
			</div>
			<div>
				<label>이름으로 검색 : </label>
				<input type="text" name="name" placeholder="이름을 입력하세요...">
			</div>			
			<input type="submit" value="검색">
		</fieldset>
	</form>
</body>
</html>