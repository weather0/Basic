<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr.row:hover {
	background: yellow;
}
</style>


<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">


</head>

<body>



	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>글번호</th>
							<th>작성자</th>
							<th>제목</th>
							<th>작성일자</th>
							<th>조회수</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${notices }" var="notice">
							<%-- ${notices }는 서버에서 request에 담은 변수 --%>
							<tr onclick="noticeSelect(${notice.id})">
								<td align="center">${notice.id }</td>
								<%-- var="notice" → ${notice.vo} --%>
								<td align="center">${notice.writer }</td>
								<td>${notice.title }</td>
								<td align="center">${notice.wdate }</td>
								<td align="center">${notice.hit }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>




	<div>
		<%--상식: id는 js에서, name은 자바에서 사용하는 변수--%>
		<form id="frm" action="noticeSelect.do" method="post">
			<input type="hidden" id="id" name="id">
		</form>
	</div>




	<div>
		<button type="button" onclick="location.href='home.do'">홈가기</button>
	</div>




	<script type="text/javascript">
        function noticeSelect(id) {
          // location.href = "noticeSelect.do?id=" + id; // GET방식
          frm.id.value = id; // POST방식: hidden을 이용. id를 넣고
          frm.submit(); // 폼자체를 submit함(정보은닉)

        }
      </script>





	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>




</body>

</html>