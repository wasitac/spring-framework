<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<% 
// 	String context = request.getContextPath();
// 	System.out.println("context : " + context);
	%>
	<h1>회원 가입</h1>
	<!-- [과제] context 변수를 action 속성의 값에 사용 -->
	<form action="${pageContext.request.contextPath}/member/new" method="POST">
<!-- 	<form action="" method="POST"> -->
		<label for="name">이름 : </label>
		<input type="text" name="name" id="name" placeholder="이름을 입력하세요...">
		<input type="submit" value="입력 완료">
	</form>
</body>
</html>