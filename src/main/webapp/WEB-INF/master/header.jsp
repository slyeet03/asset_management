
<% String userName = request.getSession().getAttribute("userId").toString();
   String lastLoginTime = 	request.getSession().getAttribute("lastLoginTime").toString();
%>
<style>
h2 {
	text-shadow: 2px 2px 4px #000000;
}
</style>
<div class="header pull-right ">
	<!-- START MOBILE CONTROLS -->
	<!-- LEFT SIDE -->
	<div class="visible-sm visible-xs">
		<!-- LEFT SIDE -->
		<div class="pull-left full-height">
			<div class="sm-action-bar">
				<a href="#" class="btn-link toggle-sidebar" data-toggle="sidebar">
					<span class="icon-set menu-hambuger"></span>
				</a>
			</div>
		</div>
		<!-- RIGHT SIDE -->
		<div class="pull-right full-height m-r-50">
			<!-- START ACTION BAR -->
			<div class="sm-action-bar">
				<div class="dropdown pull-right">
					<button class="profile-dropdown-toggle" type="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="thumbnail-wrapper inline d32 b-r b-l b-t b-b"
							style="background-color: #03396c; border-radius: 20%; box-shadow: inset 0px 0px 2px #888888; cursor: pointer; border-color: transparent;">
							<i class="inline pg-power text-white"></i>
						</span>
					</button>
					<ul class="dropdown-menu profile-dropdown" role="menu">
						<li><a href="changepasswordform.htm"><i
								class="pg-settings_small"></i> Change Password</a></li>
						<li class=""><a href="logout.htm" class=""> <span
								style="font-weight: 600;"><i class="pg-power"></i> Logout</span></a></li>
					</ul>
				</div>
			</div>
			<!-- END ACTION BAR -->
		</div>
		<div class=" pull-left sm-table">
			<div class="header-inner">
				<div class="brand inline">
					<h2 class="semi-bold">ASSET MANAGEMENT</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="visible-lg visible-md">
		<div class="visible-md visible-lg">
			<div class="pull-right">
				<div class="m-t-10">
					<div class="pull-left p-r-10 fs-16 font-heading text-white">
						<i class="fa fa-user "></i><span class=" m-l-5 semi-bold "><%=userName%></span>
						<br class="no-padding no-margin" /> <i class="fa fa-clock-o m-r-5"></i>Last
						Login : <span class=" m-l-5 semi-bold "><%=lastLoginTime%></span>

					</div>
					<div class="dropdown pull-right">
						<button class="profile-dropdown-toggle" type="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="thumbnail-wrapper inline d32 b-r b-l b-t b-b"
								style="background-color: white; border-radius: 20%; box-shadow: -2px 2px 2px #888888; cursor: pointer; border-color: transparent; width: 36px; height: 36px; line-height: 30px">
								<i class="inline pg-power text-black" style="font-size: 22px;"></i>
							</span>
						</button>
						<ul class="dropdown-menu profile-dropdown" role="menu"
							style="box-shadow: -2px 2px 2px #888888;'">
							<li><a href="changepasswordform.htm"><i
									class="pg-settings_small"></i> Change Password</a></li>
							<li class=""><a href="logout.htm" class=""> <span
									style="font-weight: 600;"><i class="pg-power"></i>
										Logout</span></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class=" pull-left sm-table">
				<div class="header-inner">
					<div class="brand inline" style="width: 100%;">
						<h2 class="semi-bold text-white ">ASSET MANAGEMENT</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>