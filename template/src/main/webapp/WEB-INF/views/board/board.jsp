<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board단건조회</title>
</head>
<body>
<!-- 결과테스트: http://localhost/mvc/board?bno=100 -->
  <h3>board단건조회</h3>
  <ul>
    <li>${board.bno }
    <li>${board.title }
    <li>${board.content }
    <li>${board.writer }
    <li>${board.regDate }
    <li>${board.updateDate }
  </ul>
</body>
</html>