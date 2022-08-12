<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>List Page</h2>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${dto.nums}</td>
				<td><a href="./detail.sh?nums=${dto.nums}">${dto.title}</a></td>
				<td>${dto.writter}</td>
				<td>${dto.date}</td>
				<td>${dto.hit}</td>	
		
		</c:forEach>
	
	</tbody>
	</table>


</body>
</html>