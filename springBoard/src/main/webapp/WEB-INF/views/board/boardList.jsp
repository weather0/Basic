<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board전체조회</title>
</head>
<body>
<h3>board목록</h3>

<table border="1">
  <tr>
    <th>no</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>수정일</th>
  </tr>
  <c:forEach var="item" items="${boards }">
    <tr>
      <td><a href="boardUpdate/${item.bno}">${item.bno }</a></td>
      <td>${item.title }</td>
      <td>${item.content }</td>
      <td>${item.writer }</td>
      <td><fmt:formatDate value="${item.regDate }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate></td>
      <td><fmt:formatDate value="${item.updateDate }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>