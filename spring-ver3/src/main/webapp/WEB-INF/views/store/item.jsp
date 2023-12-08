<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/cover.css" rel="stylesheet">

</head>
<body>
	<!-- START : header -->
	<jsp:include page="../common/header.jsp"/>

	<!-- START : container -->
	<div class="container" style="max-width: 600px">
		<div class="py-5 text-center">
			<h2>상품 상세</h2>
		</div>
		<form action="/store/edit" method="post">
			<div class="pb-3">
				<label>상품 ID</label> 
				<input class="form-control" type="text" value="1" readonly>
				<label>상품명</label> 
				<input class="form-control" type="text" value="허쉬" readonly>
				<label>가격</label> 
				<input class="form-control" type="text" value="10000" readonly>
				<label>수량</label> 
				<input class="form-control" type="text" value="10" readonly>
			</div>
			<hr>
			<div class="container row">
				<div class="col d-grid gap-2" >
					<button type="submit" class="btn btn-light">상품 수정</button>
				</div>
				<div class="col d-grid gap-2" >
					<button type="button" class="btn btn-secondary" onclick="location.href='${context}/store/items'">목록으로</button>
				</div>
			</div>
		</form>
	</div>

	<!-- START : footer -->
<jsp:include page="../common/footer.jsp"/>
</html>