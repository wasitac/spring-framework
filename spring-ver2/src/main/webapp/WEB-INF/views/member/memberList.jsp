<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="himedia.project.ver2.dto.Member, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
}
td {
	border: 2px solid black;
}
</style>
<title>회원 목록</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
			</tr>
		</thead>
		<tbody>
			<!-- [jsp] -->
			<%-- 
			<% List<Member> members = (List<Member>)request.getAttribute("members"); %>
			<% for (Member m : members) { %>
			<tr>
				<td><%=m.getId() %></td>
				<td><%=m.getName() %></td>
			</tr>
			<% } %> --%>
			<!-- [jstl] -->
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.getId()}</td>
					<td>${member.getName()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>