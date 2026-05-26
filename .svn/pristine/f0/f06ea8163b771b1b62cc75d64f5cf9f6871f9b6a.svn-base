<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>ASSET_MANAGEMENT || Asset Purchase</title>
<link rel="apple-touch-icon" href="pages/ico/60.png">
<link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
<link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
<link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png">
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
<link href="assets/plugins/bootstrap-select2/select2.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages1.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/jquery-datatable/media/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/datatables-responsive/css/datatables.responsive.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" media="screen">
<link
	href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" media="screen">	

<script type="text/javascript">
	window.onload = function() {
		// fix for windows 8
		if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
			document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />';
	};
</script>
</head>
<body
	class="fixed-header windows desktop pace-done menu-pin menu-behind ">
	<%@ include file="/WEB-INF/master/LeftMenu.jsp"%>
	<div class="page-container">
		<%@ include file="/WEB-INF/master/header.jsp"%>
		<div class="page-content-wrapper">
			<div class="content">
				<div class="jumbotron" data-pages="parallax">
					<div class="container-fluid container-fixed-lg sm-p-l-20 sm-p-r-20">
						<div class="inner">
							<!-- START BREADCRUMB -->
							<ul class="breadcrumb">
								<li><a href="Dashboard.htm" class="active">DashBoard</a></li>
								<li>Transaction</li>
								<li><a href="#" class="active">Asset Purchase</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="row" id="rootwizard">
						<div class="panel panel-default"
							style="box-shadow: -3px 3px 3px #ffb6c1; border-radius: 50px;">
							<div class="panel-title p-l-40 p-t-7">
								<h4>Asset Purchase</h4>
							</div>
							<div class="panel-body">
								<form:form class="" role="form" action="AssetPurchaseDetail.htm"
									modelAttribute="Assetmastercommandname" id="SDC-FORM"
									name="SDC-FORM">

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Category</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="categoryid" path="categoryid"
													name="categoryid">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="acm" items="${assetcatlist}">
														<form:option value="${acm.assetcategorycode}">${acm.assetcategorycode}-${acm.categorydescription}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset SubCategory</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="subcategoryid" path="subcategoryid"
													name="subcategoryid">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="asm" items="${assetSubCatlist}">
														<form:option value="${asm.subcategorycode}">${asm.subcategorycode}-${asm.subcategorydescription}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Description</label>
												<form:input id="assetdescription" path="assetdescription"
													name="assetdescription"
													class="form-control " required="required"
													autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Asset Name</label>
												<form:input id="assetname" path="assetname" name="assetname"
													class="form-control " placeholder="" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Branch Id</label>
												<form:input id="branchid" path="branchid"
													value="${branchid}" readonly="true" name="branchid"
													class="form-control " placeholder="" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Asset Id</label>
												<form:input id="assetid" path="assetid" value="${assetid}"
													name="assetid" readonly="true" class="form-control "
													placeholder="" autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Department</label>
												<form:input id="assetdepartment" name="assetdepartment"
													class="form-control" required="required"
													path="assetdepartment" autocomplete="off" value="India"
													readonly="true" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>DEPREMETH</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="depreciation" path="depreciation"
													name="depreciation">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="paramast" items="${Depremeth}">
														<form:option value="${paramast.key}">${paramast.value}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>LADetails</label>
												<form:input id="assetsladetails" path="assetsladetails"
													name="assetsladetails" required="required"
													class="form-control " autocomplete="off"
													cssStyle="cursor:pointer;" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Insurer Name</label>
												<form:input id="assetinsurername" path="assetinsurername"
													name="assetinsurername" class="form-control"
													required="required" autocomplete="off" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Insurer Address</label>
												<form:input id="assetinsureraddress"
													name="assetinsureraddress" path="assetinsureraddress"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Quantity</label>
												<form:input id="quantity" path="quantity" name="quantity"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>PO Amount</label>
												<form:input id="poamount" path="poamount" name="poamount"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>PO REF</label>
												<form:input id="assetporef" name="assetporef"
													path="assetporef" class="form-control number"
													required="required" autocomplete="off" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>PO Date</label>
												<form:input id="assetpodate" path="assetpodate"
													name="assetpodate" class="form-control datepickermasking"
													required="assetpodate" autocomplete="off"
													style="cursor :pointer;" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Invoice Number</label>
												<form:input id="assetinvoiceno" path="assetinvoiceno"
													name="assetinvoiceno" class="form-control"
													required="required" autocomplete="off" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Invoice Amount</label>
												<form:input id="assetinvoiceamount"
													name="assetinvoiceamount" path="assetinvoiceamount"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Invoice Date</label>
												<form:input id="assetinvoicedate" path="assetinvoicedate"
													name="assetinvoicedate"
													class="form-control datepickermasking " required="required"
													autocomplete="off" style="cursor :pointer;" maxlength="50" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Type</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="assettype" path="assettype"
													name="assettype">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="paramast" items="${assettype}">
														<form:option value="${paramast.key}">${paramast.value}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset Tag</label>
												<form:input id="assettags" name="assettags" path="assettags"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Asset User</label>
												<form:input id="assetuser" path="assetuser" name="assetuser"
													class="form-control" required="required" autocomplete="off"
													maxlength="50" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Service Type</label>
												<form:input id="servicetype" name="servicetype"
													path="servicetype" class="form-control" required="required"
													autocomplete="off" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Service Start Date</label>
												<form:input id="assetservicestartdate"
													path="assetservicestartdate" name="assetservicestartdate"
													class="form-control datepickermasking" required="required"
													autocomplete="off" style="cursor :pointer;" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Service End Date</label>
												<form:input id="assetserviceenddate"
													path="assetserviceenddate" name="assetserviceenddate"
													class="form-control datepickermasking" required="required"
													autocomplete="off" style="cursor :pointer;" maxlength="50" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="padding-20">
											<button type="submit" id="updatebtn"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px; display: none;"
												class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right">
												<span>Update</span>
											</button>
											<button type="submit" id="submitbtn"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;"
												class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right">
												<span>Submit</span>
											</button>
											<div class="btn-group  dropdown-default dropup" id="btngrp"
												style="display: none;">
												<a class="btn btn-complete dropdown-toggle"
													data-toggle="dropdown" href="#"> Action <span
													class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a href="#" id="Approve">Approve</a></li>
													<li><a href="#" id="Reject">Reject</a></li>
												</ul>
											</div>
										</div>
									</div>

									<input type="hidden" id="action" name="action">
									<input type="hidden" id="prev" name="prev" value="${prev}">
									<input type="hidden" id="recstatus" value="${recstatus}">
									<input type="hidden" id="next" name="next" value="${next}">
									<input type="hidden" id="Update" name="Update"
										value="${Update}">
									<input type="hidden" id="disable" name="disable"
										value="${disable}">
									<%--<form:hidden id="branchid" path="branchId" name="branchid"
								value="${branchid}" />  --%>
									<form:hidden id="recordid" path="recordid" name="recordid"
										value="${recordid}" />
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form:form>

							</div>
						</div>
					</div>
				</div>
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
			<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
			<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js"
				type="text/javascript"></script>
			<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
			<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
			<script type="text/javascript"
				src="assets/plugins/bootstrap-select2/select2.min.js"></script>
			<script type="text/javascript"
				src="assets/plugins/classie/classie.js"></script>
			<script type="text/javascript"
				src="assets/plugins/jquery-autonumeric/autoNumeric.js"></script>
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
			<script
				src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"
				type="text/javascript"></script>
			<script
				src="assets/plugins/jquery-validation/js/jquery.validate.min.js"
				type="text/javascript"></script>
			<script
				src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js"
				type="text/javascript"></script>
			<script type="text/javascript"
				src="assets/plugins/jquery-inputmask/jquery.inputmask.min.js"></script>
			<script type="text/javascript"
				src="assets/plugins/jquery-Alphanum/jquery.alphanum.js"></script>
			<script src="pages/js/pages.min.js"></script>
			<script src="assets/plugins/jquery-ui/jquery.blockUI.js"
				type="text/javascript"></script>
			<script src="assets/js/form_wizard.js" type="text/javascript"></script>
			<script src="pages/js/AssetPurchase.js" type="text/javascript"></script>
			<script src="pages/js/CommanCode.js" type="text/javascript"></script>
			<script src="assets/js/SDCValidation.js" type="text/javascript"></script>
			<script type="text/javascript">
				var update = "${Update}";
				var disable1 = "${disable}";
				var list = null;
			</script>
			<input class="csrf" type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<%@ include file="/WEB-INF/master/Footer.jsp"%>
		</div>
	</div>
	<div class="modal fade slide-up disable-scroll" id="generalmodal"
		tabindex="-1" role="dialog" aria-hidden="false">
		<div class="modal-dialog ">
			<div class="modal-content-wrapper">
				<div class="modal-content">
					<div class="modal-header clearfix text-left">
						<button type="button" class="close" id="close" name="close"
							data-dismiss="modal" aria-hidden="true">
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

</body>
</html>