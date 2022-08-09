<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./member/login">login</a>
<a href="./member/join">join</a><br>
<a href="./bankbook/add">product add </a>
<a href="./bankbook/list">list</a>
<a href="./bankbook/detai">detail</a>
</body>
</html>
