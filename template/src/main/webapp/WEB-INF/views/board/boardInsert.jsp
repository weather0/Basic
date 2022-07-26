<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board등록</title>
</head>
<body>
  <h4>board등록</h4>
  <!-- action="boardInsert"은 지워도 됨. form 기본값이 자기 페이지 -->
  <form action="boardInsert" method="post">
    <div>
      <input name="title" placeholder="제목">
    </div>
    <div>
      <input name="content" placeholder="내용">
    </div>
    <div>
      <input name="writer" placeholder="작성자">
    </div>
    <button>등록</button>
  </form>

</body>
</html>