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
tr, td, th {
	border: 2px solid black;
}
</style>
<title>회원 목록</title>
</head>
<body>
 	<% 
 	List<Member> members = (List<Member>)request.getAttribute("members");
 	System.out.println("members : " + members);
 	System.out.println("members.size() : " + members.size());
 	%>	
	<h1>회원 목록</h1>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
			</tr>
		</thead>
		<tbody>
				<% for(Member member : members) { %>
				<tr>
					<td><%= member.getId() %></td>
					<td><%= member.getName() %></td>
				</tr>
				<% } %>
		</tbody>
	</table>
</body>
</html>