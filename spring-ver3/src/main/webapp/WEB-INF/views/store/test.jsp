<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/url.jsp"%>
<meta charset="UTF-8">
<title>test</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.col {
	background-color: #ff0;
}
</style>
</head>
<body>
	<h1>test.jsp</h1>
	<h2>${name}</h2>
	<div class="container text=center">
		<div class="row">
			<div class="col">1</div>
			<div class="col">2</div>
			<div class="col">3</div>
			<div class="col">4</div>
			<div class="col">5</div>
			<div class="col">6</div>
			<div class="col">7</div>
			<div class="col">8</div>
			<div class="col">9</div>
			<div class="col">10</div>
			<div class="col">11</div>
			<div class="col">12</div>
		</div>
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md-2">2</div>
			<div class="col">3</div>
		</div>
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md-auto">Hi</div>
			<div class="col">3</div>
		</div>
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md-auto">Hello~Hello~Hello~</div>
			<div class="col">3</div>
		</div>
		<div class="row">
			<div class="col col-2">1</div>
			<div class="col col-4">2</div>
			<div class="col col-6">3</div>
		</div>
	</div>
</body>
</html>