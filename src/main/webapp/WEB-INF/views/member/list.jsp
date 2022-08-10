<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sh.start.BankMembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Model model; %>
    <% ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankMember List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>UserName</th><th>name</th><th>email</th><th>phone</th>
			</tr>
		</thead>
	<tbody>
		<% for(BankMembersDTO bankMembersDTO : ar){ %>
			<tr>
				<td><%=bankMembersDTO.getUsername() %></td>
				<td><%=bankMembersDTO.getName() %></td>
				<td><%=bankMembersDTO.getEmail() %></td>
				<td><%=bankMembersDTO.getPhone() %></td>
		<%} %>

	</tbody>
	
	</table>
</body>
</html>