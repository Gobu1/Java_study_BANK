<%@page import="com.sh.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% %>--
    <%--	// 스크립틀릿 <%자바 코드 %.>
    	// 표현식 <%= 자바변수 또는 값 %.>
    --%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
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
		<c:forEach items="${requestScope.list}" var="dto">
		<tr>
			<td><a href="./detail.sh?bookNum=${pageScope.dto.bookNum}">${dto.bookName}</a></td>
			<td>${pageScope.dto.bookRate}</td>
		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<form action="./list.sh" method="post">
		<div>
		<input type="number" name="bookNum">
		<input type="submit" value="검색">
		</div>
	
	</form>
	
	
	
	<a href = "./detail.sh">detail </a>
	<a href = "./delete.sh">삭제</a>
	
	
</body>
</html>