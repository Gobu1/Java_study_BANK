<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	
<%-- 	<c:forEach begin="0" end="10" var="i" step="2">
		<h3>${pageScope.1}</h3>
		</c:forEach> 
 --%>		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.userName}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			
			
			
			</tr>
		</c:forEach>
		
		<%-- <% for(BankMembersDTO bankMembersDTO : ar){ %>
			<tr>
				<td><%=bankMembersDTO.getUserName() %></td>
				<td><%=bankMembersDTO.getName() %></td>
				<td><%=bankMembersDTO.getEmail() %></td>
				<td><%=bankMembersDTO.getPhone() %></td>
		<%} %> --%>

	</tbody>
	</table>
	
</body>
</html>