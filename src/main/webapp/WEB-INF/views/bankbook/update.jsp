<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Update Page</h1>
	
	<form action="./update.sh" name="update" method="post">
		<input type="hidden" name="bookNum"  value="${update.bookNum }">
		<div>
			Name : <input type="text" name="bookName" value="${update.bookName}">
		</div>
		<div>
			Rate : <input type="text" name="bookRate" value="${update.bookRate}">
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	
	</form>
</body>
</html>