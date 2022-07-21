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
<h3>사원목록</h3>

<table border="1px">
  <c:forEach items="${emps }" var="emps">
    <tr>
      <td>${emps.employee_id }
      <td>${emps.last_name }
      <td>${emps.hire_date }
      <td>${emps.salary }
    </tr>
  </c:forEach>
</table>

</body>
</html>