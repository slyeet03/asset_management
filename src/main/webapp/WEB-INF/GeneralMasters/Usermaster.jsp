<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>MEMBER MANAGEMENT|| User Master</title>
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
								<li>User Management</li>
								<li><a href="#" class="active">User Master</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="row">
						<div class="col-md-7">
							<div class="panel panel-default"
								style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;">
								<div class="panel-title p-l-10 p-t-10">
									<i class="fa fa-circle-o fs-11"></i>
									<h4>User Master</h4>
								</div>
								<div class="panel-body">
									<form:form class="" role="form" action="UserMasterDetail.htm"
										 modelAttribute="Usermastercommandname" id="SDC-FORM"
										name="SDC-FORM">
										<div class="panel panel-transparent">
											<div class="panel-body">
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group form-group-default required">
															<label>USER ID</label>
															<form:input id="userid" name="userid" class="form-control number" required="true"
															path="userid" autocomplete="off" maxlength="10"/>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group form-group-default required">
															<label>User Name</label>
															<form:input id="username" class="form-control name1" required="true"
																path="username" autocomplete="off"/>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group form-group-default required">
															<label>User level</label>
															<form:select class="full-width" onchange="return fillRoleName();"
																data-init-plugin="select2" id="userlevel" required="true"
																path="userlevel">
																<form:option selected="selected"  value="">Please Select</form:option>
																<c:forEach var="paramast" items="${Paramast_Rolename}">
																	<form:option value="${paramast.key}">${paramast.value}</form:option>
																</c:forEach>
															</form:select>
															<form:hidden id="rolename" path="rolename"/>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group form-group-default required">
															<label>Branch</label>
															<form:input id="branch" class="form-control isinfd" required="true"
																path="branch" maxlength="10"  autocomplete="off"/>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="padding-20">
												 <button type="submit" id="updatebtn"
													style="box-shadow: -2px 2px 2px #888888; border-radius: 7px; display: none;"
													class="btn btn-primary btn-cons btn-animated from-left fa  fa-save pull-right">
													<span>Update</span>
												</button>
												<button type="submit" id="submitbtn"
													style="box-shadow: -2px 2px 2px #888888; border-radius: 7px;"
													class="btn btn-primary btn-cons btn-animated from-left fa fa-cog pull-right">
													<span>Submit</span>
												</button>
												<div class="btn-group  dropdown-default dropup" id="btngrp" style="display: none;">
													<a class="btn btn-complete dropdown-toggle"
														data-toggle="dropdown" href="#"> Action <span
														class="caret"></span></a>
													<ul class="dropdown-menu">
														<li><a href="#" id="Approve" >Approve</a></li>
														<li><a href="#" id="Reject">Reject</a></li>
													</ul>
												</div>
											</div>
										</div>
										<input type="hidden" id="action" name="action">
										<input type="hidden" id="prev" name="prev" value="${prev}"> 
										<input type="hidden" id="recstatus"  value="${recstatus}"> 
										<input type="hidden" id="next" name="next" value="${next}">
										<input type="hidden" id="Update" name="Update" value="${Update}">
										<input type="hidden" id="disable" name="disable" value="${disable}">
										<input class="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									</form:form>
								</div>
							</div>
						</div>
						<div class="col-md-5" id="userdetail" style="display: none;">
							<div class="widget-3 panel no-border bg-complete-lighter no-margin widget-loader-bar"
								style="box-shadow: -2px 2px 2px #888888; border-radius: 2%;">
								<div class="panel-title p-l-5">
									<h4 class="text-black">Current User Details</h4>
								</div>
								<hr class="b-t b-danger m-t-5 m-b-5" />
								<div class="panel-body no-padding" style="font-size: 16px;" >
									<div class="row padding-5">
										<div class="col-md-6 b-r b-warning">User Name :</div>
										<div class="col-md-4 currusername"></div>
									</div>
									<div class="row padding-5">
										<div class="col-md-6 b-r b-warning">Userlevel :</div>
										<div class="col-md-6 curruserlevel"></div>
									</div>								
								</div>
							</div>
						</div> 
					</div>
				</div>
			</div>
				<script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
	<script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
	<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
	<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
	<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
	<script type="text/javascript" src="assets/plugins/jquery-autonumeric/autoNumeric.js"></script>
	<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/plugins/jquery-inputmask/jquery.inputmask.min.js"></script>
	<script type="text/javascript" src="assets/plugins/jquery-Alphanum/jquery.alphanum.js"></script>
	<script src="pages/js/pages.min.js"></script>
	<script src="assets/plugins/jquery-ui/jquery.blockUI.js" type="text/javascript"></script>
	<script src="assets/js/form_wizard.js" type="text/javascript"></script>
	<script src="pages/js/CommanCode.js" type="text/javascript"></script>
	<script src="assets/js/SDCValidation.js" type="text/javascript"></script>	
	<script src="pages/js/Usermaster.js" type="text/javascript"></script>
	<script type="text/javascript">	var update = "${Update}";var disable1 = "${disable}"; var list="${unlist}";</script>
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

		
</body>
</html>