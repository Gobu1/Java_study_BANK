<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	<form action="./login" name="id" method="post">
        <div class="container">
            ID<input type="text">
            PW<input type="password">
            <input type="submit" value="로그인">
        </div>
        <div>
            <input type="button" value="아이디, 비밀번호 찾기">
            <input type="checkbox">아이디 기억하기
        </div>
    </form>
    <a href="../home">home Page</a><br>

</body>
</html>