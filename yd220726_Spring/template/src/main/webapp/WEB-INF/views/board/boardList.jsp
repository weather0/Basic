<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

<script>
	$(function() {
// 		$('#myTable').DataTable();

		// 검색기능 방법1
// 		$('[name="type"]').val('${cri.type}')

		// 검색기능 방법2: html부분에 if 추가
		// <c:if test="${cri.type=='title' }">selected</c:if>
		
		
		
		// 수정, 삭제 메시지 출력
		var result1 = '${result1}'
		var result2 = '${param.result2}'
		
		if(result1 != ''){
		  const myModal = new bootstrap.Modal('#staticBackdrop', {})
		  const modal = document.getElementById("staticBackdrop");
		  $("#msg").html(result1);
		  myModal.show(modal);
		}
		
	});
	
	function goPage(num){
		searchFrm.pageNum.value = num;
		searchFrm.submit();
			
// 			location.href="boardList?pageNum=" + num
	}
		

</script>
<!-- https://getbootstrap.com/docs/5.2/components/card/ -->
<div class="card">
  <div class="card-header">
    <!-- 검색기능 -->
    <form name="searchFrm">
      <input type="hidden" name="pageNum" value="1"> <select name="type">
        <option value="title" <c:if test="${cri.type=='title' }">selected</c:if>>제목
        <option value="content" <c:if test="${cri.type=='title' }">selected</c:if>>내용
        <option value="writer" <c:if test="${cri.type=='title' }">selected</c:if>>작성자
      </select> <input name="keyowrd" value="${cri.keyword }">
      <button>검색</button>
    </form>
  </div>
  
  <div class="card-body">
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
    
  </div>
</div>


<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="msg"></div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>