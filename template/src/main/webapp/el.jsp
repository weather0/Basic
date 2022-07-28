<%@page import="java.util.Arrays"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el식 정리</title>
</head>
<body>
  <!--테스트: localhost/app/el.jsp?id=박찬호 -->
  <h3>EL 내장객체</h3>
  <%
  request.setAttribute("name", "리퀘");
  session.setAttribute("name", "쎄션");
  application.setAttribute("name", "앱");
  request.setAttribute("list", Arrays.asList("최", "김", "이"));
  %>
  <ul>
    <li><%=request.getParameter("id")%></li>
    <li>${param.id }</li>
    <li>${param["id"] }</li>

    <li>===== 속성 =====</li>
    <li>${name }</li>
    <li><%=request.getAttribute("name")%></li>
    <li>${requestScope.name }</li>

    <li><%=session.getAttribute("name")%></li>
    <li>${sessionScope.name }</li>

    <li><%=application.getAttribute("name")%></li>
    <li>${applicationScope.name }</li>

    <li>===== 헤더 =====</li>
    <li><%=request.getHeader("User-Agent")%></li>
    <li>${header["User-Agent"] }</li>

    <li>===== 쿠키 =====</li>
    <!-- 개발자도구(F12)-응용프로그램-쿠키에 임의로 이름,값 넣자. 예)openYn:true -->
    <li>${cookie.openYn.value }</li>

    <li>===== 초기화파라미터 =====</li>
    <li><%=application.getInitParameter("contextConfigLocation")%></li>
    <li>${initParam.contextConfigLocation }</li>

    <li>===== EL함수 =====</li>
    <li>리스트크기: ${fn:length(list) }</li>
    <li>시작문자(리퀘): ${fn:startsWith(name, "리") }</li>
    <!-- escapeXml="true"로하면 태그가 문자열 그대로 표시됨 -->
    <li><c:out escapeXml="false" value="<u>태그</u>"></c:out></li>
    <li></li>

  </ul>


</body>
</html>