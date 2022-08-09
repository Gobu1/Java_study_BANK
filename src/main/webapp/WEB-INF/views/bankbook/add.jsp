<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product add</title>
</head>
<body>
	<h2>Product add</h2>
	<form action="./add" name="add" method="post">
		<div>
			bookname<input type="text" name="bookname"><br>
			bookrate<input type="number" step="0.01" name="bookrate"><br>
			booksale<input type="number" min=0 max=1 name="booksale"><br>
			<input type="submit" name="add">
		
		</div>
	</form>

</body>
</html>