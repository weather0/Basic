<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>${message }</h1></div> <!-- request로 넘어 옴 -->
	<div>${id } : ${name }</div> <!-- session 정보 -->
	<div>이엘yedam.studentId -> ${yedam.studentId}</div> <!-- session 정보 -->
</div>

</body>
</html>