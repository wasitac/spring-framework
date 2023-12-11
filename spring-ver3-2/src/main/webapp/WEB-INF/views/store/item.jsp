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
<body class="d-flex flex-column min-vh-100">
	<!-- START : header -->
	<jsp:include page="../common/header.jsp"/>

	<!-- START : container -->
	<div id="container" class="container" style="max-width: 600px">
		<div class="py-5 text-center">
			<h2>상품 상세</h2>
		</div>
		<form action="${context}store/items/${item.id}/edit">
			<div class="row my-2">
				<div class="col-2">
					<label for="id" class="form-label fw-bolder">상품 ID</label> 
				</div>
				<div class="col">
					<input class="form-control" type="text" name="id" id="id" value="${item.id}" readonly disabled>
				</div>
			</div>
			<div class="row my-2">
				<div class="col-2">
					<label for="name" class="form-label fw-bolder">상품명</label> 
				</div>
				<div class="col">
					<input class="form-control" type="text" name="name" id="name" value="${item.name}" readonly disabled>
				</div>
			</div>
			<div class="row my-2">
				<div class="col-2">
					<label for="price" class="form-label fw-bolder">가격</label> 
				</div>
				<div class="col">
					<input class="form-control" type="text" name="price" id="price" value="${item.price}" readonly disabled>
				</div>
			</div>
			<div class="row my-2">
				<div class="col-2">
					<label for="quantity" class="form-label fw-bolder">수량</label> 
				</div>
				<div class="col">
					<input class="form-control" type="text" name="quantity" id="quantity" value="${item.quantity}" readonly disabled>
				</div>
			</div>
			<hr class="my-4">
			<div class="row my-2">
				<div class="col" >
					<button type="submit" class="btn btn-outline-dark btn-lg w-100">상품 수정</button>
				</div>
				<div class="col" >
					<button type="button" class="btn btn-secondary btn-lg w-100" onclick="location.href='${context}store/items'">목록으로</button>
				</div>
			</div>
		</form>
	</div>

	<!-- START : footer -->
<jsp:include page="../common/footer.jsp"/>
</html>