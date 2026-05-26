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
<title>ASSET MANAGEMENT || Organization Master</title>
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

<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.css" rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages1.css" rel="stylesheet" type="text/css" />

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
								<li><a href="#" class="active">Organization Master</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="row no-padding no-margin">

						<div class="panel panel-default"
							style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
							<div class="panel-head no-padding no-margin">
								<div class="panel-title no-padding no-margin">
									<h4 class="text-left no-padding no-margin p-l-5">Organization
										Master</h4>
								</div>
							</div>
							<div class="panel-body no-padding">
								<form:form class="" role="form" action="OrganizationMasterDetail.htm"
									modelAttribute="Organization" id="SDC-FORM" name="SDC-FORM">
									<div class="panel panel-transparent">
										<div class="panel-body">
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>Bank</label>
														<form:input id="bank" class="form-control " required="required" path="bank"
															autocomplete="off" />
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>Address</label>
														<form:textarea id="address" class="form-control address" required="required" path="address"
															autocomplete="off"    />
													</div>
												</div>												
											</div>
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>Pin Code</label>
														<form:input id="pin" class="form-control pincode"
															required="required" path="pin" autocomplete="off" />
													</div>
												</div>												
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>Country</label>
														<form:input id="country" class="form-control"
															required="required" path="country" autocomplete="off" value="India" readonly="true"/>
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
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
											</div>
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
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
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>phone1</label>
														<form:input id="phone1" class="form-control"
															required="required" path="phone1" autocomplete="off"
															maxlength="20" />
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default ">
														<label>phone2</label>
														<form:input id="phone2" class="form-control "
															path="phone2" autocomplete="off"
															 maxlength="30"/>
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default ">
														<label>Email ID</label>
														<form:input id="email" class="form-control email"
															 path="email" autocomplete="off"
															maxlength="20" />
													</div>
												</div>												
											</div>
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group form-group-default ">
														<label>finyrfrom</label>
														<form:input id="finyrfrom" class="form-control datepickermasking"
															path="finyrfrom" autocomplete="off"
															style="cursor: pointer;" />
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>finyrto</label>
														<form:input id="finyrto" class="form-control datepickermasking "
															required="required" path="finyrto" style="cursor: pointer;" autocomplete="off" />
													</div>
												</div>												
											</div>		
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group form-group-default required">
														<label>minvalasset</label>
														<form:input id="minvalasset" class="form-control "
															required="required" path="minvalasset" autocomplete="off" />
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group form-group-default">
														<label>Transaction</label>
														<form:checkbox id="tran"
														 value="1" path="transactions" autocomplete="off" />
													</div>
												</div>	
											</div>									
											<div class="row">
												<button type="submit" id="updatebtn"
													style="box-shadow: -2px 2px 2px #888888; border-radius: 2px;"
													class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right">
													<span>Update</span>
												</button> 	
											</div>
										</div>
									</div>	
									<form:hidden id="recordid" name="recordid" path="recordid"/>	
									<input type="hidden" id="Update" name="Update" value="${Update}">
									<input type="hidden" id="disable" name="disable" value="${disable}">					
								</form:form>
							</div>
						</div>
						
					</div>
				</div>
			</div>
			<script src="assets/plugins/jquery/jquery-1.11.1.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
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
	<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
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
	<script src="pages/js/Organization.js" type="text/javascript"></script>
	<script src="assets/js/SDCValidation.js" type="text/javascript"></script>
	<input class="csrf" type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<script type="text/javascript">var update = "${Update}";var disable1 = "${disable}";var list = null;</script>
			<%@ include file="/WEB-INF/master/Footer.jsp"%>
		</div>
	</div>

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
	
	
</body>
</html>