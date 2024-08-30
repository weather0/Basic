<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book전체조회</title>

</head>
<body>
  <h3>도서 조회/수정</h3>

  <table border="1" style="width:100%">
    <tr>
      <th>도서번호</th>
      <th>도서명</th>
      <th>표지</th>
      <th>출판일자</th>
      <th>금액</th>
      <th>출판사</th>
      <th>도서소개</th>
    </tr>
    <c:forEach var="item" items="${books }">
      <tr>
        <td>${item.bookNo }</td>
        <td>${item.bookName }</td>
        <td><img src="resources/images/${item.bookCoverimg }" alt="${item.bookCoverimg }" width="100"></td>
        <td><fmt:formatDate value="${item.bookDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
        <td><fmt:formatNumber value="${item.bookPrice }" pattern="0,000"></fmt:formatNumber></td>
        <td>${item.bookPublisher }</td>
        <td>${item.bookInfo }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>