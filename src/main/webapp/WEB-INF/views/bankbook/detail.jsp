<%@page import="com.sh.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--
    <%BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %>
    --%>
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
		<%-- ${scope명.속성명.getter의 이름}
			 getter의 이름 : getter 메서드에서 get을 지우고 첫글자를 소문자로 바꾼것--%>
			<tr>
				<td>${requestScope.detail.getBookNum()}
				<td>${requestScope.detail.bookName}
				<td>${detail.bookRate}</td>
			</tr>
			
	</tbody>
	</table>
	
	
	
	<a href="/Study/member/login.sh">login</a>
	<a href="../member/join.sh">join</a>
	
	<a href="./list.sh">list</a>
	<a href="./update.sh?bookNum=${detail.bookNum}">수정</a>
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.sh?bookNum=${detail.bookNum}">계좌등록</a>
	</c:if>
</body>
</html>