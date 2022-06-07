<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>안녕하세요</h1>
<h3>${name} : ${id} : ${pw}</h3> <!-- jsp의 el표현식 --> <!-- mybatis에서는 #{} -->
<c:forEach items="${students }" var="s">
${s.studentId } : ${s.name } : ${s.address }<br>

</c:forEach>


</body>
</html>