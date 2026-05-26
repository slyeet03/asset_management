var successflag=false;
$(function(){
	var token = $(".csrf").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    }); 
    
    var update =$('#Update').val();
	
	if (update.length > 0) {		
		if(update==1){
			$('#approvebtn').css('display','none');
			$('#updatebtn').css('display', 'block');				
		}else {
			$('#approvebtn').css('display','block');			
		}
	}
	
	if (disable1 == 1) {
		$('#updatebtn').css('display', 'none');	
		$('#approvebtn').css('display','block');
		
		disable();
	}
	$('#finyrfrom').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
	$('#finyrto').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
	
	
	
	$("#updatebtn").click(function(event){
		event.preventDefault();
		if($('#SDC-FORM').valid()){			
			submitform();		
		}else{
			$('#modalheader').html("Error !!!");
			$('#modalbody').html("Please Check the Form again!!");
			successflag=0;
		}	
	});
	$("#approvebtn").click(function(event){		
		submitform();	
		return false;
	});
		
});

function disable(){
	$('body').find('select').each(function() {
		$(this).attr("disabled", "disabled");
		$(this).select2();
	});
	$('body').find('input[type="text"]').each(function() {
		$(this).attr("disabled", "disabled");
	});
	$('body').find('input[type="checkbox"]').each(function() {
		$(this).prop("disabled", "true");
	});
	$('body').find('textarea').each(function() {
		$(this).prop("disabled", "disabled");
	});
}

function submitform() {	debugger;
		$.ajax({
			url : "OrganizationMasterDetail.htm",
			type : "POST",
			data : $('#SDC-FORM').serialize(),
			dataType : "json",	
			async : false,
			error : function(xhr, status, error) {
				var err = xhr.responseText;
				if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
					window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
				}
			},
			beforeSend : function() {

			},
			success : function(response) {
				if(parseInt(response.error) == 0){ 
					$('#tranStatus').html(response.tranStatus);
					$('#modalheader').html("Success !!!");
					$('#modalbody').html(response.Msg);
					successflag=1;
				}else{
					$('#tranStatus').html(response.tranStatus);
					$('#modalheader').html("Error !!!");
					$('#modalbody').html(response.Msg);
					successflag=0;
				}
				$('#generalmodal').modal("show");
			}
		});
		return false;
}
function getcity() { 
	var selectedstate = $('#state :selected').val(); 
	$('#city').html('<option value="">Please Select</option>');
	$('#city').val('');
	$('#city').select2();
	if (selectedstate.length > 0) {
		$.ajax({
					url : "getcity.htm",
					type : "POST",
					data : {
						selectedstate : selectedstate
					},
					dataType : "json",
					async : true,
					error : function(xhr, status, error) {
						var err = xhr.responseText;
						if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
							window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
						}
					},
					beforeSend : function() {
					},
					success : function(response) {
						var city = "<option value=\"\">Please Select</option>";
						for ( var i = 0; i < response.details_city.length; i++) {
							var innerarray = response.details_city[i];
							 city += "<option value="+innerarray.code+">"+ innerarray.ldesc + "</option>";
						}
						$('#city').html(city);
						$('#city').val('');
						$('#city').select2();
					}
				});
	}
}


//newly added

$('#state').change(function(e){
$('#emsg').text('');
CitySatewise();
  });
 
 
function CitySatewise(){
var state = $('#state :selected').val();
if (state.length > 0) {
$.ajax({
url : "getCityStatewise.json",
type : "POST",
data : {
state : state, 
 
},
dataType : "json",
async : false,
error : function(xhr, status, error) {
var err = xhr.responseText;
if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
window.location = "Login.htm?statusCheck=SessionExpired";
}
},
beforeSend : function() {
},
success : function(response) {
var city = "<option value=\"\"> Please Select</option>";
for ( var i = 0; i < response.city.length; i++) {
var innerarray = response.city[i];
city += "<option value=\"" + innerarray.code  + "\">"+innerarray.code+"-"+ innerarray.ldesc + "</option>";
}
$('#city').html(city);
$('#city').val('');
$('#city').select2();
}
 
});
}
}


