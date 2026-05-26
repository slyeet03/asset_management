<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>ASSET_MANAGEMENT || Vendor Master</title>
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
<link class="main-stylesheet" href="pages/css/customcode.css"
	rel="stylesheet" type="text/css" />
<link class="main-stylesheet" href="pages/css/pages1.css"
	rel="stylesheet" type="text/css" />

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
								<li><a href="Dashboard.htm" class="active">Dashboard</a></li>
								<li>Master</li>
								<li><a href="#" class="active">Vendor Master</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="row" id="rootwizard">
						<div class="panel panel-default"
							style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">

							<div class="panel-body box1">
								<div class="panel-title p-l-10 p-t-10">
									<h4>Vendor Master</h4>
								</div>
								<form:form class="" role="form" action="VendorMasterDetail.htm"
									modelAttribute="VendorMasterCommandname" id="SDC-FORM"
									name="SDC-FORM">

									<div class="row">
										<div class="col-sm-6">
											<div class="form-group form-group-default "
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Vendor Code</label>
												<form:input id="vendorcode" path="vendorcode"
													value="${vendorcode}" readonly="true" class="form-control"
													placeholder="" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Vendor Name</label>
												<form:input id="entityname" path="entityname"
													required="required" class="form-control rounded-input"
													placeholder="" autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Country</label>
												<form:input id="country" class="form-control inputstyle"
													required="required" path="country" autocomplete="off"
													value="India" readonly="true" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>State</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="state" path="state">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="paramast" items="${stateHashMap}">
														<form:option value="${paramast.key}">${paramast.value}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>City</label>
												<form:select class="full-width" data-init-plugin="select2"
													required="true" id="city" path="city">
													<form:option selected="selected" value="">Please Select</form:option>
													<c:forEach var="paramast" items="${cityHashMap}">
														<form:option value="${paramast.key}">${paramast.value}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
									</div>
									<div class="row">
										<%-- <div class="col-sm-4">
											<div class="form-group form-group-default required">
												<label>Address</label>
												<form:input id="address" path="address"
													class="form-control address" required="required"
													autocomplete="off" />
											</div>
										</div> --%>
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Address</label>
												<form:textarea id="address" path="address"
													class="form-control address" required="required"
													autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Pin Code</label>
												<form:input id="pincode" path="pincode"
													class="form-control pincode" required="required"
													autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default ">
												<label>Contact Person</label>
												<form:input id="contactname" path="contactname"
													class="form-control " placeholder="" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default "
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Phone</label>
												<form:input id="phone1" path="phone1" class="form-control "
													autocomplete="off" cssStyle="cursor:pointer;"
													maxlength="10" minlength="10" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default required"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Email ID</label>
												<form:input id="email" path="email"
													class="form-control email" required="required"
													autocomplete="off" maxlength="50" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default "
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Web Site</label>
												<form:input id="website" path="website"
													class="form-control " autocomplete="off"
													cssStyle="cursor:pointer;" maxlength="10" minlength="10" />
											</div>
										</div>
									</div>
									<div class="col-6 required">
										<h3>Tax Details</h3>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Sales Tax</label>
												<form:input id="salestax" path="salestax"
													class="form-control servicetax" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Service Tax</label>
												<form:input id="servicetax" path="servicetax"
													class="form-control servicetax" autocomplete="off" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group form-group-default"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Tan Tax</label>
												<form:input id="tantax" path="tantax"
													class="form-control tantax" autocomplete="off" />
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-group-default"
												style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
												<label>Vat Tax</label>
												<form:input id="vattax" path="vattax"
													class="form-control vattax" autocomplete="off" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="padding-40">
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
									<%-- <form:hidden id="branchid" path="branchid" name="branchid" value="${branchid}"/> --%>
									<form:hidden id="recordid" path="recordid" value="${recordid}" />
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
			<script src="pages/js/VendorMaster.js" type="text/javascript"></script>
			<script src="pages/js/CommanCode.js" type="text/javascript"></script>
			<script src="assets/js/SDCValidation.js" type="text/javascript"></script>
			<script type="text/javascript">
				var update = "${Update}";
				var disable1 = "${disable}";
				var list = "${CIFNumber}"
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