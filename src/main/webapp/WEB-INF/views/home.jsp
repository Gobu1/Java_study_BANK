<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%-- ${member empty} --%>
<c:if test="${empty sessionScope.member}">
<a href="./member/login.sh">로그인</a>
<a href="./member/join.sh">join</a><br>
</c:if>

<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.name }</h3>
<a href="./member/logout.sh">Logout</a>
<a href="#">Mypage</a>

<a href="./member/search.sh">search</a>
<a href="./bankbook/add.sh">product add </a>
<a href="./bankbook/list.sh">list</a>
</c:if>
</body>
</html>
