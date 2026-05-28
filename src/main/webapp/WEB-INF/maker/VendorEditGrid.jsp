<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>INVESTMENT || Vendor Master</title>
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fu	llscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<meta content="" name="description" />
<meta content="" name="author" />
<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet"
	type="text/css" />
<link href="assets/plugins/boostrapv3/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	window.onload = function() {
		// fix for windows 8
		if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
			document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />';
	}
</script>
</head>
<body
	class="fixed-header windows desktop pace-done menu-pin menu-behind ">
	<!-- BEGIN SIDEBPANEL-->
	<%@ include file="/WEB-INF/master/LeftMenu.jsp"%>
	<div class="page-container">
		<%@ include file="/WEB-INF/master/header.jsp"%>
		<div class="modal fade slide-up disable-scroll" id="generalmodal"
			tabindex="-1" role="dialog" aria-hidden="false">
			<div class="modal-dialog ">
				<div class="modal-content-wrapper">
					<div class="modal-content">
						<div class="modal-header clearfix text-left">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								<i class="pg-close fs-16"></i>
							</button>
							<h4 id="modalheader"></h4>
						</div>
						<div class="modal-body">
							<span class="no-margin fs-16" id="modalbody"> </span>
						</div>
						<div class="modal-footer" id="modalfooter">
							<button type="button" id="continuebtn"
								class="btn btn-primary btn-cons  pull-left inline"
								data-dismiss="modal">Continue</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="content">
				<div class="jumbotron" data-pages="parallax">
					<div class="container-fluid container-fixed-lg sm-p-l-20 sm-p-r-20">
						<div class="inner">
							<ul class="breadcrumb">
								<li><a href="Dashboard.htm" class="active">Dashboard</a></li>
								<li>General</li>
								<li><a href="#" class="active">Vendor Master</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg bg-transparent">
					<!-- START PANEL -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="pull-right"></div>
							<div class="clearfix"></div>
							<form action="VendorMasterDetail.htm" method="POST" id="SDC-FORM">
								<div class="table-responsive">
									<table class="table table-hover demo-table-dynamic"
										id="tableWithSearch">
										<thead>
											<tr>
												<th style="width: 8%; color: #565656;">Select</th>
												<th style="width: 8%; color: #565656;">Vendor</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="data" items="${list_pm}">
												<tr>
													<td class="v-align-middle">
														<form action="UpdateVendorMaster.htm"
          method="POST"
          style="margin:0;">

        <input type="hidden"
               name="recordid"
               value="${data.key}" />

        <input type="hidden"
               name="prev"
               value="${prev}" />

        <input type="hidden"
               name="next"
               value="${next}" />

        <input type="hidden"
               name="recstatus"
               value="${recstatus}" />

        <input type="hidden"
               name="Update"
               value="1" />

        <button type="submit"
                class="btn btn-primary btn-xs">

            Edit

        </button>

    </form>
													</td>
													<td class="v-align-middle" style="cursor: pointer;"
														onclick="return filldetails('${data.key}');"><p>
															<c:out value="${data.value.getEntityname()}"></c:out>
														</p></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<input type="hidden" id="action" name="action"> <input
										type="hidden" id="prev" name="prev" value="${prev}"> <input
										type="hidden" id="next" name="next" value="${next}"> <input
										type="hidden" id="Update" name="Update" value="${Update}">
								</div>
							</form>
							<br />
							<div class="clearfix"></div>
							
						</div>
					</div>
					<!-- END PANEL -->
				</div>
				<!-- END CONTAINER FLUID -->
				<div class="clearfix"></div>
			</div>
			<script src="assets/plugins/jquery/jquery-1.11.1.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/modernizr.custom.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery-ui/jquery-ui.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/boostrapv3/js/bootstrap.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery/jquery-easy.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
			<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
			<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
			<script type="text/javascript"
				src="assets/plugins/bootstrap-select2/select2.min.js"></script>
			<script type="text/javascript"
				src="assets/plugins/classie/classie.js"></script>
			<script
				src="assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js"
				type="text/javascript"></script>
			<script
				src="assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js"
				type="text/javascript"></script>
			<script
				src="assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.js"
				type="text/javascript"></script>
			<script type="text/javascript"
				src="assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
			<script src="assets/plugins/moment/moment.min.js"></script>
			<script src="pages/js/pages.min.js"></script>
			<script src="assets/plugins/jquery-ui/jquery.blockUI.js"
				type="text/javascript"></script>
			<script src="pages/js/CommanGridCode.js" type="text/javascript"></script>
			<script src="pages/js/VendorMasterGrid.js" type="text/javascript"></script>
			<script>
				var msg = "${successMsg}";
			</script>
			<%@ include file="/WEB-INF/master/Footer.jsp"%>
		</div>
	</div>


	<form action="UpdateVendorMaster.htm" method="POST" id="SDC1-FORM">
		<input type="hidden" id="prev" name="prev" value="${prev}"> <input
			type="hidden" id="next" name="next" value="${next}"> <input
			type="hidden" id="recstatus" name="recstatus" value="${recstatus}">
		<input class="csrf" type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<input class="csrf" type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</body>
</html>