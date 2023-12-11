<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<%@ include file="../common/url.jsp"%>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- START : header -->
	<jsp:include page="../common/header.jsp"/>

	<!-- START : container -->
	<div id="container" class="container" style="max-width: 600px">
		<div class="py-5 text-center">
			<h2>상품 수정 폼</h2>
		</div>
		<form action="${context}store/items/${item.itemId}/edit" method="post">
			<div class="pb-3">
				<label>상품 ID</label> 
				<input class="form-control" type="text" name="itemId" id="itemId" value="${item.itemId}" readonly>
				<label>상품명</label> 
				<input class="form-control" type="text" name="name" id="name" value="${item.name}" >
				<label>가격</label> 
				<input class="form-control" type="text" name="price" id="price" value="${item.price}" >
				<label>수량</label> 
				<input class="form-control" type="text" name="count" id="count" value="${item.count}"  >
			</div>
			<hr>
			<div class="container row">
				<div class="col d-grid gap-2" >
					<button type="button" class="btn btn-light" onclick="location.href='${context}store/items/${itemId}'">취소</button>
				</div>
				<div class="col d-grid gap-2" >
					<button type="submit" class="btn btn-secondary">저장</button>
				</div>
			</div>
		</form>
	</div>

	<!-- START : footer -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>