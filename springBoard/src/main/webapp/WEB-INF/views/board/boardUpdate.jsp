<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board수정</title>
</head>
<body>
  <h4>board수정</h4>
  <c:set var="path" value="${pageContext.request.contextPath }" />
  <!-- action="boardInsert"은 지워도 됨. form 기본값이 자기 페이지 -->
  <form action="${pageContext.request.contextPath }/boardUpdate" method="post"> <!-- ../boardUpdate해도 됨 -->
    <div>글번호
      <input name="bno" value="${board.bno }" readonly="readonly">
    </div>
    <div>제목
      <input name="title" placeholder="제목" value="${board.title }">
    </div>
    <div>내용
      <input name="content" placeholder="내용" value="${board.content }">
    </div>
    <div>작성자
      <input name="writer" placeholder="작성자" value="${board.writer }" readonly="readonly">
    </div>
    <button>수정</button>
    <button type="button" id="btnDelete">삭제</button>
  </form>
  
<script>
  btnDelete.addEventListener("click", function(){
    location.href="${path}/boardDelete?bno=${board.bno}";
  })
</script>
</body>
</html>