<%@page import="com.sh.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	// 스크립틀릿 <%자바 코드 %.>
    	// 표현식 <%= 자바변수 또는 값 %.>
    	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
				
			</tr>
		</thead>
	<tbody>
		<%	for(BankBookDTO bankBookDTO : ar){ %>
			<tr>
				<td><a href="./detail?bookNum=<%=bankBookDTO.getBooknum()%>"><%=bankBookDTO.getBookname() %></a> </td>
				<td><%=bankBookDTO.getBookrate() %></td>
				
			</tr>
		<%}%>
	</tbody>
	</table>
	
	
	
	
	<a href = "./detail">detail </a>
	
	
</body>
</html>