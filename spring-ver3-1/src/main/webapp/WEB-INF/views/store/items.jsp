<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<%@ include file="../common/url.jsp"%>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- START : header -->
	<jsp:include page="../common/header.jsp"/>

	<!-- START : container -->
	<div class="container" style="max-width: 600px">
		<div class="py-5 text-center">
			<h2>상품 목록</h2>
		</div>
		<hr>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>상품명</th>
					<th>가격</th>
					<th>수량</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<c:forEach var="item" items="${items}">
				<tr>
					<td>
						<a href="/ver3/store/items/${item.itemId}">${item.itemId}</a>
					</td>
					<td>
						<a href="/ver3/store/items/${item.itemId}">${item.name}</a>
					</td>
					<td>${item.price}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div>
			<div class="d-grid gap-2">
				<button type="button" class="btn btn-secondary" onclick="location.href='${context}store/items/add'">상품 등록</button>
			</div>
		</div>
	</div>

	<!-- START : footer -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>