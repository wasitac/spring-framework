
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./url.jsp"%>
<footer class="py-3 text-bg-dark mt-auto">
	<ul class="nav justify-content-center pb-3 mb-3">
		<li><a href="${context}" class="nav-link px-2 text-secondary">Home</a></li>
		<li><a href="${context}store/items" class="nav-link px-2 text-white">상품 목록</a></li>
		<li><a href="${context}store/items/add" class="nav-link px-2 text-white">상품 등록</a></li>
	</ul>
	<p class="text-center text-white">&copy; 2023 Company, Inc</p>
</footer>