<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>

<!--         <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
<!--         Font Awesome icons (free version) -->
<!--         <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script> -->
<!--         Google fonts -->
<!--         <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" /> -->
<!--         <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" /> -->
<!--         Core theme CSS (includes Bootstrap) -->
<!--         <link href="css/styles.css" rel="stylesheet" /> -->


<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">



</head>
<!-- <body> -->
<!-- <body id="page-top"> -->
<!-- 	<div id="wrapper"> -->
<body >
	<div>

		<!-- 		<div> -->
		<%-- 			<tiles:insertAttribute name="menu" /> --%>
		<!-- 		</div> -->
		<!-- 		<hr> -->
<!-- 		<div> -->
<%-- 			<tiles:insertAttribute name="nav" /> --%>
<!-- 		</div> -->
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<!-- 		<hr> -->
		<div>
			<tiles:insertAttribute name="body" />
		</div>
		<!-- 		<hr> -->
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<!-- 	        Bootstrap core JS -->
	<!--         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
	<!--         Core theme JS -->
	<!--         <script src="js/scripts.js"></script> -->
	<!--         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * -->
	<!--         * *                               SB Forms JS                               * * -->
	<!--         * * Activate your form at https://startbootstrap.com/solution/contact-forms * * -->
	<!--         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * -->
	<!--         <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script> -->
	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="logout.do">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>


</body>
</html>