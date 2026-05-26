<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>ASSET MANAGEMENT || User Master</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages1.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body, p {
    font-size: 13px;
    line-height: 2px;
}
</style>
</head>
<body
	class="fixed-header windows desktop pace-done menu-pin menu-behind ">
	<!-- BEGIN SIDEBPANEL-->
	<%@ include file="/WEB-INF/master/LeftMenu.jsp"%>
	<div class="page-container">
		<%@ include file="/WEB-INF/master/header.jsp"%>
		<div class="modal fade slide-up disable-scroll" id="generalmodal" tabindex="-1" role="dialog" aria-hidden="false">
			<div class="modal-dialog ">
				<div class="modal-content-wrapper">
					<div class="modal-content">
						<div class="modal-header clearfix text-left">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								<i class="pg-close"></i>
							</button>
							<h4 id="modalheader" ></h4>
						</div>
						<div class="modal-body">
							<span class="no-margin fs-16" id="modalbody">
							</span>
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
								<li><a href="#" class="active">User Master</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg bg-transparent">
					<!-- START PANEL -->
					<div class="panel panel-default">
						<div class="panel-body">
							<!-- <div class="pull-right">
								<div class="col-xs-12">
									<input type="text" id="search-table"
										class="form-control pull-right" placeholder="Search">
								</div>
							</div> -->
							<div class="clearfix"></div>
							<form action="UserMasterDetail.htm" method="POST"
								id="SDC-FORM">
								<div class="table-responsive">
									<table class="table table-hover demo-table-dynamic"
										id="tableWithSearch">
										<thead>
											<tr>
												<th style="width: 8%; color: #565656;">Select &nbsp;<input type="checkbox"  id="select_all" /></th>
												<th style="width: 8%; color: #565656;">User Id</th>
												<th style="width: 8%; color: #565656;">User Name</th>
												<th style="width: 8%; color: #565656;">Role Name</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="data" items="${list_vc}">
												<tr>
												
													<td class="v-align-middle">
														<div class="checkbox ">
														
															<input type="checkbox" class="checkbox" id="${data.key}" name="userid"
																value="${data.key}" /> 
																<label for="${data.key}" style="position: static;"></label>
														</div>
													</td>
													
													<td class="v-align-middle" style="cursor: pointer;" onclick="return filldetails('${data.key}');"><p><c:out value="${data.value[0]}"></c:out></p></td>
													<td class="v-align-middle" style="cursor: pointer;" onclick="return filldetails('${data.key}');"><p><c:out value="${data.value[1]}"></c:out></p></td>
												    <td class="v-align-middle" style="cursor: pointer;" onclick="return filldetails('${data.key}');"><p><c:out value="${data.value[2]}"></c:out></p></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<input type="hidden" id="action" name="action"> 
									<input type="hidden" id="prev" name="prev" value="${prev}"> 
									<input type="hidden" id="next" name="next" value="${next}"> 
									<input type="hidden" id="Update" name="Update" value="${Update}">
								</div>
								<input class="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</form>
							<br />
							<div class="clearfix"></div>
							
							
							<div class="btn-group  dropdown-default dropup" id="btngrp">
								<a class="btn btn-complete dropdown-toggle"
									data-toggle="dropdown" href="#"> Action <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#" id="Approve">Approve</a></li>
									<li><a href="#" id="Reject">Reject</a></li>
								</ul>
							</div>
						
						</div>
					</div>
					<!-- END PANEL -->
				</div>
				<!-- END CONTAINER FLUID -->
				<div class="clearfix"></div>
			</div>
	<script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
	<script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
	<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
	<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
	<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
	<script src="assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js" type="text/javascript" ></script>
	<script src="assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
	<script src="assets/plugins/moment/moment.min.js"></script>
	<script src="pages/js/pages.min.js"></script>
	<script src="assets/plugins/jquery-ui/jquery.blockUI.js" type="text/javascript"></script>
	<script src="pages/js/CommanGridCode.js" type="text/javascript"></script>
	<script src="pages/js/UsermasterGrid.js" type="text/javascript"></script>
	<script>var msg = "${successMsg}";</script>
			<%@ include file="/WEB-INF/master/Footer.jsp"%>
		</div>
	</div>

	<form action="UpdateUsermaster.htm" method="POST" id="SDC1-FORM">
	 <input type="hidden" id="prev" name="prev" value="${prev}"> 
	 <input type="hidden" id="next" name="next" value="${next}">
	 <input type="hidden" id="recstatus" name="recstatus" value="${recstatus}">
	 	<input class="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
		
</body>
</html>