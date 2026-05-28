<!--  <!DOCTYPE html>-->
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>ASSET MANAGEMET SYSTEM- Dashboard</title>
<!-- <link rel="icon" type="image/x-icon" href="favicon.ico" /> -->
<link rel="shortcut icon" href="#">
<link rel="apple-touch-icon" sizes="180x180"
	href="/apple-touch-icon.png">
<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet"
	type="text/css" />
<!--  <link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-select2/select2.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" media="screen">
<link
	href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" media="screen">
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap4/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages1.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/jquery-datatable/media/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css"
	rel="stylesheet" type="text/css" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fu	llscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<meta content="" name="description" />
<meta content="" name="author" />
<%@ include file="/WEB-INF/master/commonInclude.jsp"%>
</head>
<body
	class="fixed-header windows desktop pace-done menu-pin menu-behind ">
	<%@ include file="/WEB-INF/master/header.jsp"%>
	<div class="page-container scrollable scroll-content">

		<%@ include file="/WEB-INF/master/LeftMenu.jsp"%>
		<div class="page-content-wrapper scroll-y scroll-scrolly_visible">
			<!-- START PAGE CONTENT -->
			<div class="content sm-gutter">
				<!-- START CONTAINER FLUID -->
				<div class="container-fluid padding-25 sm-padding-10">

					<div
						class="container p-3 my-3 border shadow p-3 m-2 bg-white rounded">
						<div class="row">
							<div class="col-md-6  b-r b-dashed g-grey">
								<div class="row">
									<div class="form-group form-group-default" style="width: 12rem;">
										<label>Asset Branch</label> <select id="branch" name="branch"
											class="full-width" data-init-plugin="select2">
											<option selected="selected" value="">Please Select</option>
											<c:forEach var="assetmaster" items="${branch}">
												<option value="${assetmaster.key}">${assetmaster.value}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group form-group-default" style="width: 12rem;">
										<label>Asset Category</label> <select id="categoryid"
											name="categoryid" class="full-width"
											data-init-plugin="select2">
											<option selected="selected" value="">Please Select</option>
											<c:forEach var="assetmaster" items="${categoryid}">
												<option value="${assetmaster.key}">${assetmaster.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="row">
								<div class="form-group form-group-default" style="width: 12rem;">
										<label>Asset Sub Category</label> <select id="subcategoryid"
											name="subcategoryid" class="full-width"
											data-init-plugin="select2">
											<option selected="selected" value="">Please Select</option>
											<c:forEach var="assetmaster" items="${subcategoryid}">
												<option value="${assetmaster.key}">${assetmaster.value}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group form-group-default" style="width: 12rem;">
										<label>Asset ID</label> <select id="assetid" name="assetid"
											class="full-width" data-init-plugin="select2">
											<option selected="selected" value="">Please Select</option>
											<c:forEach var="assetmaster" items="${assetid}">
												<option value="${assetmaster.key}">${assetmaster.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
				
								<div class="row" style = "position:relative; left:350px; top:2px;">
								<button type="button" id="gobtn"
									style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;min-width: 70px;"
									class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right">
									<span>VIEW</span>
								</button>
							</div>
							</div>
							<div class="col-md-6" data-aos="fade-up" >

								<div class="row">
                              
                                   <div class="card" style="width: 14rem;">
    <div class="card-body">
        <h4 class="card-title font-weight-bold">TOTAL ASSETS</h4>
        <p class="card-text" id="totalAssets">0</p>
    </div>
</div>

<div class="card" style="width: 14rem;">
    <div class="card-body">
        <h4 class="card-title font-weight-bold">PO AMOUNT</h4>
        <p class="card-text" id="totalPOAmount">0</p>
    </div>
</div>
                                  </div>
                                  <div class="row">
									
										<div class="card" style="width: 14rem;">
    <div class="card-body">
        <h4 class="card-title font-weight-bold">BOOK VALUE</h4>
        <p class="card-text" id="totalBookValue">0</p>
    </div>
</div>

<div class="card" style="width: 14rem;">
    <div class="card-body">
        <h4 class="card-title font-weight-bold">TOTAL DEPRECIATION</h4>
        <p class="card-text" id="totalDepreciation">0</p>
    </div>
</div>
									</div>

								</div>
    
						</div>
					</div>

				</div>




			</div>
		</div>
		<%@ include file="/WEB-INF/master/Footer.jsp"%>
	</div>


	<div class="modal fade slide-up disable-scroll errorModal"
		tabindex="-1" role="dialog" aria-hidden="false">
		<div class="modal-dialog modal-sm">
			<div class="modal-content-wrapper">
				<div class="modal-content">
					<div class="modal-header clearfix ">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<i class="pg-close"></i>
						</button>
					</div>
					<div class="modal-head text-center" id="errorModalHead">
						<h2 class="no-margin p-b-10">Head Msg</h2>
					</div>
					<div class="modal-body text-center m-t-20" id="errorModalBody">
						<h4 class="no-margin p-b-10">Body Message</h4>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>

	<div class="modal fade slide-up disable-scroll" id="generalmodal"
		tabindex="-1" role="dialog" aria-hidden="false" style="z-index: 1051;">
		<div class="modal-dialog ">
			<div class="modal-content-wrapper">
				<div class="modal-content bg-warning-light">
					<div class="modal-header clearfix text-left">
						<button type="button" class="close" id="close" name="close"
							data-dismiss="modal" aria-hidden="true">
							<i class="pg-close"></i>
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

	<!-- MODAL STICK UP  -->
	<div class="modal fade slide-up" id="myModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width: 70%;">
			<div class="modal-content-wrapper"></div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->

	<!-- END MODAL STICK UP  -->
	<!-- Photo & Sign Model -->
	<div class="modal fade slide-up" id="photoNSignModel" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width: 45%;">
			<div class="modal-content-wrapper">
				<div class="modal-content">
					<div class="modal-header clearfix text-left">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<i class="pg-close fs-20"></i>
						</button>
						<h1 style="width: 70%;">Photo &amp; Sign</h1>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-5">
								<img id="viewPhoto" src="" height="200" width="200">
							</div>
							<div class="col-sm-6">
								<img id="viewSign" src="" height="200" width="300">
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
		</div>
		<!-- /.modal-dialog -->
	</div>
	<script>
	$(document).ready(function () {

    $("#gobtn").click(function () {
        displaydetails();
    });

});</script>
 	<!-- Photo & Sign Model -->
	<%-- <%@ include file="/WEB-INF/master/views/CommonIncludeFooter.jsp"%> --%>
	<script src="assets/plugins/jquery/jquery-1.11.1.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/boostrapv3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery/jquery-easy.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
	<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
	<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/bootstrap-select2/select2.min.js"></script>
	<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
	<script
		src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="assets/plugins/datatables-responsive/js/datatables.responsive.min.js"></script>
	<script src="pages/js/pages.min.js"></script>
	<input class="csrf" type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<script src="pages/dashboard.js"></script>
	<script>
		$('#shrnumb').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			todayHighlight : true,
			startDate : new Date('1700-01-01'),
			endDate : '+0d',
		});
	</script>

</body>
</html>