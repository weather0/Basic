<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
  <h4>사원수정</h4>
  <c:set var="path" value="${pageContext.request.contextPath }" />
  <!-- action="empInsert"은 지워도 됨. form 기본값이 자기 페이지 -->
  <form action="${pageContext.request.contextPath }/empUpdate" method="post"> <!-- ../empUpdate해도 됨 -->
    <div>사원번호
      <input name="employeeId" value="${emp.employeeId }" readonly="readonly">
    </div>
    <div>이름
      <input name="firstName" placeholder="이름" value="${emp.firstName }">
    </div>
    <div>성
      <input name="lastName" placeholder="성" value="${emp.lastName }">
    </div>
    <div>이메일
      <input name="email" placeholder="이메일" value="${emp.email }">
    </div>
    <div>입사일
      <input name="hireDate" placeholder="입사일" type="date" 
        value='<fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd" />'>
    </div>
    <div>직무ID
      <input name="jobId" placeholder="직무ID" value="${emp.jobId }">
    </div>
    <button>수정</button>
    <button type="button" id="btnDelete">삭제</button>
  </form>
  
<script>
	btnDelete.addEventListener("click", function(){
		location.href="${path}/empDelete?employeeId=${emp.employeeId}";
	})
</script>
</body>
</html>