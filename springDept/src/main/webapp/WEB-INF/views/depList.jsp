<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>부서목록</h3>

<table border="1px">
  <tr>
    <th>department_id
    <th>departement_name
    <th>manager_id
    <th>location_id
  </tr>
  
  <c:forEach items="${deps }" var="deps">
    <tr>
      <td>${deps.department_id }
      <td>${deps.department_name }
      <td>${deps.manager_id }
      <td>${deps.location_id }
    </tr>
  </c:forEach>
</table>

</body>
</html>