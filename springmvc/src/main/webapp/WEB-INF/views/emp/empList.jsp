<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
</head>
<body>
<h3>사원목록</h3>


<table border="1px">
  <c:forEach items="${emps }" var="emps">
    <tr>
      <td><a href="empUpdate/${emps.employeeId}">${emps.employeeId }</a></td>
      <td>${emps.lastName }</td>
      <td><fmt:formatDate value="${emps.hireDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
      <td>${emps.salary }</td>
      <td>${emps.jobId }</td>
    </tr>
  </c:forEach>
</table>



<br><br><hr>

<form>
  사번<input name="employeeId">
  <br>
  부서<input type="checkbox" name="depts" value="10">10
      <input type="checkbox" name="depts" value="20">20
      <input type="checkbox" name="depts" value="30">30
  <br>
  직무<select name="jobId">
        <option value="">선택
        <option value="IT_PROG">IT_PROG
        <option value="ST_CLERK">ST_CLERK
        <option value="ST_MAN">ST_MAN
      </select>
  <br>
  입사일자 <input type="date" name="sdt">~<input type="date" name="edt">
  <button>검색</button>
</form>



</body>
</html>