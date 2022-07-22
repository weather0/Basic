<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트용</title>
<!-- 단순테스트(컨트롤러 안거치고)하려면 그냥 webapp에 바로 jsp생성하고 웹주소창에 /parameter.jsp -->
<!-- views폴더에 넣은 경우라면 컨트롤러.java에 @RequestMapping("parameter") 메서드 추가 -->
</head>
<body>
  <form action="req1">
    <input name="id">
    <button>스트링</button>
  </form>
  
  <hr>
  
  <form action="req2">
    <input name="ids" type="checkbox" value="100">100번
    <input name="ids" type="checkbox" value="101">101번
    <input name="ids" type="checkbox" value="102">102번
    <button>스트링배열</button>
  </form>

  <hr>
  
  <form action="req3">
    <input name="id">
    <input name="ids" type="checkbox" value="100">100번
    <input name="ids" type="checkbox" value="101">101번
    <input name="ids" type="checkbox" value="102">102번
    <button>맵</button>
  </form>

  <hr>
  
  <form action="req4">
    <input name="id">
    <input name="ids" type="checkbox" value="100">100번
    <input name="ids" type="checkbox" value="101">101번
    <input name="ids" type="checkbox" value="102">102번
    <button>VO</button>
  </form>

  <hr>
  
  <form action="req5">
    <div>
      <input name="list[0].id">
      <input name="list[0].ids" type="checkbox" value="100">100번
      <input name="list[0].ids" type="checkbox" value="101">101번
      <input name="list[0].ids" type="checkbox" value="102">102번
    </div>
    <div>
      <input name="list[1].id">
      <input name="list[1].ids" type="checkbox" value="100">100번
      <input name="list[1].ids" type="checkbox" value="101">101번
      <input name="list[1].ids" type="checkbox" value="102">102번
    </div>
    <div>
      <input name="list[2].id">
      <input name="list[2].ids" type="checkbox" value="100">100번
      <input name="list[2].ids" type="checkbox" value="101">101번
      <input name="list[2].ids" type="checkbox" value="102">102번
    </div>
      <button>List&lt;VO&gt;</button>
  </form>
  
  <hr>
  
  <form action="req6" method="post" enctype="multipart/form-data">
    <input name="id">
    <input name="ids" type="checkbox" value="100">100번
    <input name="ids" type="checkbox" value="101">101번
    <input name="ids" type="checkbox" value="102">102번
    <input type="file" name="pic" multiple="multiple">
    <button>첨부</button>
  </form>
  
  <hr>
  
  <a href="req7/choi/20">pathvariable</a>

</body>
</html>