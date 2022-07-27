<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여조회</title>

</head>
<body>
  <h3>도서별 대여매출현황</h3>

  <table border="1" style="width:100%">
    <tr>
      <th>도서번호</th>
      <th>도서명</th>
      <th>대여총계</th>
      <th>대여횟수</th>
    </tr>
    <c:forEach var="item" items="${rents }">
      <tr>
        <td>${item.bookNo }</td>
        <td>${item.bookName }</td>
        <td>${item.rentsum }</td>
        <td>${item.rentcnt }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>