<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product add</h2>
	<form action="./add.sh" name="add" method="post">
		<div>
			USERNAME<input type="text" name="USERNAME" value="${dto.userName}">
			BOOKNUM<input type="text" name="BOOKNUM" value="${dto.bookNum}">
		
		</div>
	</form>

</body>
</html>