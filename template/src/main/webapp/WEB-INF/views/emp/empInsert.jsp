<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert</title>
</head>
<body>
  <h4>사원등록</h4>
  <!-- action="empInsert"은 지워도 됨. form 기본값이 자기 페이지 -->
  <form action="empInsert" method="post">
    <div>
      <input name="firstName" placeholder="이름">
    </div>
    <div>
      <input name="lastName" placeholder="성">
    </div>
    <div>
      <input name="email" placeholder="이메일">
    </div>
    <div>
      <input name="hireDate" placeholder="입사일" type="date">
    </div>
    <div>
      <input name="jobId" placeholder="직무ID">
    </div>
    <button>등록</button>
  </form>

</body>
</html>