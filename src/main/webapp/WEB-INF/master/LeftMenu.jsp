<%@page import="com.fam.filter.ASSET_MANAGEMENTConstants"%>
<%@page import="com.fam.values.RecordStatus"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<nav class="page-sidebar" data-pages="sidebar" style="width: 19.5%">
	<div class="sidebar-header">
		<span class="brand"
			style="font-family: segoeui; font-size: x-large; color: red; padding: 0 0px; padding-left: 10px;"
			class="semi-bold"> <span style="font-size: 22px;">AM</span>
		</span>
	</div>
	<div class="sidebar-menu">
		<ul class="menu-items">
			<%
			String BankShortCode = (String) request.getSession().getAttribute("BankShortCode");
			String UserLevel = request.getSession().getAttribute("userlevel").toString();
			if ((Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_1
					&& Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_5)
					|| (Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_21
					&& Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_25)) {
			%>
			<li class="m-t-30 open"><a href="Dashboard.htm" class="detailed">
					<span class="title">Dashboard</span><span class="details">0
						New Updates</span>
			</a><span class="icon-thumbnail bg-sucess"></span></li>
			<li class=""><a href="javascript:;"><span class="title">Masters</span>
					<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="javascript:;"><span class="title">ADD</span>
							<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
							class="glyphicon glyphicon-plus-sign"></i></span>
						<ul class="sub-menu">
							<li class=""><a href="BranchMasterView.htm">Branch</a><span
								class="icon-thumbnail">BM</span></li>
							<li class=""><a href="AssetDepartmentMasterView.htm">Asset Department</a><span 
							    class="icon-thumbnail">AD</span></li>
							<li class=""><a href="AssetCategoryMasterView.htm">Asset
									Category</a><span class="icon-thumbnail">AC</span></li>
							<li class=""><a href="AssetSubCategoryMasterView.htm">Asset
									Sub Category </a><span class="icon-thumbnail">ASC</span></li>
						    <li class=""><a href="CategoryAccountDetailsView.htm">Category
									Account Details </a><span class="icon-thumbnail">CD</span></li>
							<li class=""><a href="BGLMasterView.htm">BGL</a><span
								class="icon-thumbnail">BGL</span></li>
							<li class=""><a href="OrganizationMasterEdit.htm">Organization</a><span
								class="icon-thumbnail">OM</span></li>
							<li class=""><a href="VendorMasterView.htm">Vendor
									Master</a><span class="icon-thumbnail">VM</span></li>
															</ul></li>

					<li class=""><a href="javascript:;"><span class="title">Edit</span>
							<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
							class="pg-tables"></i></span>
            <ul class="sub-menu">
							<li class=""><a href="BranchMasterEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Branch</a><span
								class="icon-thumbnail">BM</span></li>
							<li class=""><a href="AssetDepartmentEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Asset Department</a><span 
							    class="icon-thumbnail">AD</span></li>
							<li class=""><a href="AssetCategoryEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Asset
									Category</a><span class="icon-thumbnail">AC</span></li>
							<li class=""><a href="AssetSubCategoryEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Asset
									Sub Category </a><span class="icon-thumbnail">ASC</span></li>
						    <li class=""><a href="CategoryAccountDetailsEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Category
									Account Details </a><span class="icon-thumbnail">CD</span></li>
							<li class=""><a href="BGLEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">BGL</span></li>
							
							<li class=""><a href="VendorEditGrid.htm?recstatus=<%=RecordStatus.APPROVER%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Vendor
									Master</a><span class="icon-thumbnail">VM</span></li>
															</ul></li>

					<li class=""><a href="javascript:;"><span class="title">R.Correction</span>
							<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
							class="pg-tables"></i></span>
						<ul class="sub-menu">

							<li class=""><a
								href="AssetCategoryMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Asset
									Category</a><span class="icon-thumbnail">AC</span></li>
							<li class=""><a
								href="AssetSubCategoryMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Asset
									SubCategory</a><span class="icon-thumbnail">ASC</span></li>
							<li class=""><a
								href="CategoryAccountDetailsGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Category Account
									Details</a><span class="icon-thumbnail">CD</span></li>
							<li class=""><a
								href="BGLMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">BGL
									Master</a><span class="icon-thumbnail">BM</span></li>
							<li class=""><a
								href="BranchMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Branch
									Master</a><span class="icon-thumbnail">BCM</span></li>
							<li class=""><a
                                href="AssetDepartmentMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
                                &Update=<%=RecordStatus.UPDATE_EDIT%>">Department
                                    Master</a><span class="icon-thumbnail">DM</span></li>
							<li class=""><a
								href="VendorMasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>
								&Update=<%=RecordStatus.UPDATE_EDIT%>">Vendor
									Master</a><span class="icon-thumbnail">VM</span></li>
						</ul></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Asset
						Transfer</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="javascript:;"><span class="title">Transfer</span>
							<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
							class="pg-tables"></i></span></li>
					<li class=""><a href="javascript:;"><span class="title">Record
								For Correction</span> <span class=" arrow"></span></a> <span
						class="icon-thumbnail"><i class="pg-tables"></i></span></li>
				</ul></li>

			<li class=""><a href="javascript:;"><span class="title">Transaction
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="AssetPurchaseView.htm">Asset
							Purchase</a><span class="icon-thumbnail">AP</span></li>
					<li class=""><a href="AssetDisposalView.htm">Asset
							Disposal</a><span class="icon-thumbnail">AD</span></li>
					<li class=""><a href="AssetMaintenanceView.htm">Asset
							Maintenance </a><span class="icon-thumbnail">AM</span></li>


				</ul></li>

			<li class=""><a href="javascript:;"><span class="title">Depreciation
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="DividendParaView.htm">Depreciation
							Rule</a><span class="icon-thumbnail">DR</span></li>
					<li class=""><a href="DividendCalcView.htm">Depreciation
							Calculate</a><span class="icon-thumbnail">DC</span></li>
					<li class=""><a href="divpayouthisview.htm">Depreciation
							Status</a><span class="icon-thumbnail">DPS</span></li>
					<li class=""><a href="DividendFileGenerateView.htm">TrickleFeed
							Generate</a><span class="icon-thumbnail">TG</span></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Reports
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="glyphicon glyphicon-list-alt"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="MemberRegView.htm">Asset Register</a><span
						class="icon-thumbnail">MR</span></li>
					<li class=""><a href="ShareHolderCountView.htm">Asset Sale</a><span
						class="icon-thumbnail">SC</span></li>
					<li class=""><a href="QuarterlySummaryView.htm">Disposal
							Report</a><span class="icon-thumbnail">DR</span></li>
					<li class=""><a href="DividendRegisterView.htm">Depreciation
							Register</a><span class="icon-thumbnail">DPR</span></li>

					<li class=""><a href="divrepview.htm">Daily Report</a><span
						class="icon-thumbnail">DR</span></li>

				</ul></li>

			<li class=""><a href="javascript:;"><span class="title">Certificate
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="printcertview.htm">Print</a><span
						class="icon-thumbnail">P</span></li>
					<li class=""><a href="reprintcertview.htm">RePrint</a><span
						class="icon-thumbnail">RP</span></li>
					<li class=""><a href="CertIssueView.htm">Issue Register</a><span
						class="icon-thumbnail">CI</span></li>
					<li class=""><a href="CertTranView.htm">Transfer Register</a><span
						class="icon-thumbnail">CT</span></li>
					<li class=""><a href="CertSplitView.htm">Maintenance
							Register</a><span class="icon-thumbnail">CS</span></li>
					<li class=""><a href="CertBuyBackView.htm">Disposal
							Register</a><span class="icon-thumbnail">DR</span></li>
					<li class=""><a href="CertCancelView.htm">Cancel Register</a><span
						class="icon-thumbnail">CC</span></li>
				</ul></li>
			<li class=""><a href="ResetPasswordView.htm"><span
					class="title">Reset Pwd</span></a><span class="icon-thumbnail"><i
					class="glyphicon glyphicon-lock"></i></span></li>
			<li class=""><a href="javascript:;"><span class="title">User
						Management</span> <span class=" arrow"></span></a> <span
				class="icon-thumbnail"><i class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a href="Usermaster.htm">User Master</a><span
						class="icon-thumbnail">UM</span></li>
					<li class=""><a
						href="UsermasterGrid.htm?recstatus=<%=RecordStatus.REJECT%>&prev=&next=<%=RecordStatus.MAKER%>&Update=<%=RecordStatus.UPDATE_EDIT%>">User
							Master Edit</a><span class="icon-thumbnail">UME</span></li>

				</ul></li>



			<!--====================================================== CHECKER LINKS=========================================================================================== -->



			<%
			} else if ((Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_6
					&& Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_10)
					|| (Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_26
					&& Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_30)) {
			%>
			<li class="m-t-30 open"><a href="Dashboard.htm" class="detailed">
					<span class="title">Dashboard</span><span class="details">0
						New Updates</span>
			</a><span class="icon-thumbnail bg-success"> <i class="pg-home"></i></span>
			</li>
			<li class=""><a href="javascript:;"><span class="title">Masters</span>
					<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="BranchMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">
							Branch</a><span class="icon-thumbnail">Br</span></li>
					<li class=""><a
                        href="AssetDepartmentMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Asset
                            Department</a><span class="icon-thumbnail">AD</span></li>
					<li class=""><a
						href="AssetCategoryMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Asset
							Category</a><span class="icon-thumbnail">AC</span></li>
					<li class=""><a
						href="AssetSubCategoryMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Asset
							Sub Category</a><span class="icon-thumbnail">ASC</span></li>
					<li class=""><a
						href="CategoryAccountDetailsGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Category
							Account Details</a><span class="icon-thumbnail">CD</span></li>
					<li class=""><a
						href="BGLMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">BGL
							Master</a><span class="icon-thumbnail">BM</span></li>
					<li class=""><a href="OrganizationMasterEdit.htm">Organization</a><span
						class="icon-thumbnail">OM</span></li>
					<li class=""><a
						href="VendorMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Vendor
							Master</a><span class="icon-thumbnail">VM</span></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Edit</span>
					<span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="EditCIFMasterGrid.htm?recstatus=<%=RecordStatus.EDIT%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">CIF</a><span
						class="icon-thumbnail">CM</span></li>
					<li class=""><a
						href="EditShareMasterGrid.htm?recstatus=<%=RecordStatus.EDIT%>&prev=<%=RecordStatus.DELETE%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">New
							Member</a><span class="icon-thumbnail">NM</span></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Joint
						Holder Detail </span> <span class=" arrow"></span></a> <span
				class="icon-thumbnail"><i class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="JointDetailGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Joint
							Detail</a><span class="icon-thumbnail">JD</span></li>
					<li class=""><a
						href="JointReleaseGrid.htm?recstatus=<%=RecordStatus.MakerApprove%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.DELETE%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Joint
							Release</a><span class="icon-thumbnail">JR</span></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Transaction
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="CertTransferGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.DELETE%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Transfer
							Certificate</a><span class="icon-thumbnail">TC</span></li>
					<li class=""><a
						href="CertSplitGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.DELETE%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Split
							Certificate</a><span class="icon-thumbnail">SC</span></li>
					<li class=""><a
						href="ResignationMasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.DELETE%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Share
							Surrender</a><span class="icon-thumbnail">RM</span></li>
					<li class=""><a
						href="NominalDetailGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Link
							Nominal Member</a><span class="icon-thumbnail">LN</span></li>
					<li class=""><a
						href="DelinkNominalGrid.htm?recstatus=<%=RecordStatus.MakerApprove%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.DELETE%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">DeLink
							Nominal Member</a><span class="icon-thumbnail">DN</span></li>
					<%
					if (BankShortCode.substring(0, 4).equalsIgnoreCase("SPCB")) {
					%>
					<li class=""><a href="uploadPhotoNSignView.htm">Upload
							Photo &amp; Signature</a><span class="icon-thumbnail">UPS</span></li>
					<%
					}
					%>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Dividend
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="DividendRuleDetailGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Dividend
							Rule </a><span class="icon-thumbnail">LN</span></li>
					<li class=""><a
						href="divpayoutviewgrid.htm?recstatus=<%=RecordStatus.DIVMAKER%>&prev=<%=RecordStatus.MAKER%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">Dividend
							Pay Out</a><span class="icon-thumbnail">DPO</span></li>
				</ul></li>
			<li class=""><a href="javascript:;"><span class="title">Reports
				</span> <span class=" arrow"></span></a> <span class="icon-thumbnail"><i
					class="pg-tables"></i></span></li>
			<li class=""><a href="javascript:;"><span class="title">USER
						MANAGEMENT</span> <span class=" arrow"></span></a> <span
				class="icon-thumbnail"><i class="pg-tables"></i></span>
				<ul class="sub-menu">
					<li class=""><a
						href="UsermasterGrid.htm?recstatus=<%=RecordStatus.MAKER%>&prev=<%=RecordStatus.REJECT%>&next=<%=RecordStatus.APPROVER%>&Update=<%=RecordStatus.UPDATE_NOTEDIT%>">User
							Master</a><span class="icon-thumbnail">UM</span></li>
				</ul></li>

			<%
			} else if (Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_11
					&& Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_15) {
			%>
			<li class="m-t-30 open"><a href="Dashboard.htm" class="detailed">
					<span class="title">Dashboard</span><span class="details">0
						New Updates</span>
			</a><span class="icon-thumbnail bg-success"> <i class="pg-home"></i></span>
			</li>

			<%
			}
			%>
		</ul>
	</div>
</nav>
