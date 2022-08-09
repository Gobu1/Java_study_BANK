<%@page import="com.sh.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Detail</h1>
	<!-- /bankbook/detail -->
	<table border="1">
		<tr>
				<th>Booknum</th><th>Name</th><th>Rate</th>
		</tr>
	<tbody>
			<tr>
				<td><%=bankBookDTO.getBooknum() %></td>
				<td><%=bankBookDTO.getBookname() %> </td>
				<td><%=bankBookDTO.getBookrate() %></td>
			</tr>
			<%if(bankBookDTO.getBooksale()==1){ %>
			<h3> 판매중</h3>
			<%}else{   %>
			<h3> 재고없음</h3>
			<%} %>
	</tbody>
	</table>
	
	
	
	<a href="/Study/member/login">login</a>
	<a href="../member/join">join</a>
</body>
</html>