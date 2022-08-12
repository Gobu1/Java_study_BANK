<%@page import="com.sh.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("delete");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Delete page</h1>
	
	<form action="./delete.sh" name="delete" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
			</tr>
		</thead>
	<tbody>
		<%	for(BankBookDTO bankBookDTO : ar){ %>
			<tr>
				<td><button type="submit" name="bookNum"><%=bankBookDTO.getBookNum() %></button></td>
				<td><%=bankBookDTO.getBookName() %> </td>
				<td><%=bankBookDTO.getBookRate() %></td>
				<td><%=bankBookDTO.getBookSale() %>
			</tr>
		<%}%>
	</tbody>
	</table>	
	</form>

</body>
</html>