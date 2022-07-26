<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

<script>
	$(function() {
// 		$('#myTable').DataTable();

		function goPage(num){
			searchFrm.pageNum.value = num;
			searchFrm.submit();
			
// 			location.href="boardList?pageNum=" + num
		}
		
	});
</script>

<!-- 검색기능 -->
<form name="searchFrm">
  <input type="hidden" name="pageNum" value="1">
  <select name="type">
    <option value="title">제목
    <option value="content">내용
    <option value="writer">작성자
  </select>
  <input name="keyowrd">
  <button>검색</button>
</form>

<!-- 부트스트랩5: https://getbootstrap.com/docs/5.2/content/tables/ -->
<table id="myTable" class="table table-dark table-striped table-hover">
  <thead>
    <tr>
      <th>bno</th>
      <th>제목</th>
      <th>작성자</th>
      <th>등록일</th>
      <th>수정일</th>
    </tr>
  </thead>
  <c:forEach var="item" items="${boards }">
    <tr>
      <td><a href="boardUpdate/${item.bno}">${item.bno }</a></td>
      <td>${item.title }</td>
      <td>${item.writer }</td>
      <td><fmt:formatDate value="${item.regDate }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate></td>
      <td><fmt:formatDate value="${item.updateDate }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate></td>
    </tr>
  </c:forEach>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination">
  
    <c:if test="${pageMaker.prev }">
      <li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.startPage }-1)">Previous</a></li>
    </c:if>
    
    <c:forEach var="i" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
      <li class="page-item"><a class="page-link" href="#" onclick="goPage(${i})">${i }</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
      <li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.endPage }+1)">Next</a></li>
    </c:if>
    
  </ul>
</nav>