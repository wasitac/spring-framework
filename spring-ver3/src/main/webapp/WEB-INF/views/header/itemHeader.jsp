<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ include file="../url.jsp"%> --%>
<header class="p-3 text-bg-dark">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li><a href="${context}" class="nav-link px-2 text-secondary">Home</a></li>
				<li><a href="${context}store/items" class="nav-link px-2 text-white">상품 목록</a></li>
				<li><a href="${context}store/items/add" class="nav-link px-2 text-white">상품 등록</a></li>
			</ul>
			<form action="${context}store/items/search" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
				<div class="row">
					<input type="search" name="search" class="col form-control form-control-dark me-2" placeholder="상품명 입력..." aria-label="Search">
					<button type="submit" class="col-4 btn btn-warning">조회</button>
				</div>
			</form>
		</div>
	</div>
</header>