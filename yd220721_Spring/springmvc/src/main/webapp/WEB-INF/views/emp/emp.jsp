<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 결과테스트: http://localhost/mvc/emp?employee_id=100 -->
  <h3>사원정보</h3>
  <ul>
    <li>${emp.employeeId }
    <li>${emp.firstName }
    <li>${emp.lastName }
  </ul>
</body>
</html>