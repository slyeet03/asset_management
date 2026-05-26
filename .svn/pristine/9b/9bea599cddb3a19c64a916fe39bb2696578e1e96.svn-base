var successflag=false;
$(function(){
	if (update.length > 0) {
		$('#submitbtn').css('display', 'none'); 
		if(update==1){
			$('#btngrp').css('display','none');
			$('#updatebtn').css('display', 'block');
			$('#userid').attr("readonly", "readonly");
			$('#userid').removeClass('useridval');
			$('#userdetail').css('display', 'block');
			
			$('.currusername').html($('#username').val());
			$('.curruserlevel').html($('#userlevel :selected').text());
			//$('.currbranch').html($('#branch :selected').text());
		}else {
			$('#btngrp').css('display','block');
			$('#userid').removeClass('useridval');
		}
	}	
	if (disable1 == 1) {
		$('#submitbtn').css('display', 'none');
		$('#clearbtn').css('display', 'none');
		$('#btngrp').css('display','block');
		disable();
	}
	$('#generalmodal').on('hidden.bs.modal', function () {
	    var update =$('#Update').val();
	    if(successflag){
			if(update.length>0){
				var recstatus=$('#recstatus').val();
				var prev=$('#prev').val();
				var next=$('#next').val();
				window.location.href = './UsermasterGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
	    }
	});
	setTimeout(function(){
		$('body').find('select').each(function() {
			$(this).select2();
		});
	}, 200);
	$('#Reject').click(function(event){
		$('#action').val('Reject');
		submitform();
	});		
	$('#Approve').click(function(event){
		$('#action').val('Approve');
		submitform();
	});
	$("#submitbtn").click(function(event){
		event.preventDefault();
		if($('#SDC-FORM').valid()){
			submitform();	
			$('body').find('select').each(function() {
				$(this).val('');
				$(this).select2();
			});
			$('#SDC-FORM').trigger('reset');
		}else{
			$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
			$('#modalbody').html('Please Check your form again. Invalid Data!!');
			$('#modalfooter').css('display','none');
			$('#generalmodal').modal('show');
			successflag=false;
		}
		
	});		

	$("#updatebtn").click(function(event){
		event.preventDefault();
		if($('#SDC-FORM').valid()){
			submitform();
		}else{
			$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
			$('#modalbody').html('Please Check your form again. Invalid Data!!');
			$('#modalfooter').css('display','none');
			$('#generalmodal').modal('show');
			successflag=false;
		}
		
	});		
});
function fillRoleName() {
	var code1 = $('#userlevel :selected').text();
	if (code1 == "") {
		$('#rolename').val("");
	}
	else{
		$('#rolename').val(code1);
		}
	
}
function filldetails(val) {
	var element ="<input type=\"hidden\" value=\""+val+"\" name=\"userid\"/>";
	$('#SDC1-FORM').append(element);
	$('#SDC1-FORM').submit();
}


function submitform(){
	$.ajax({
		type : "POST",
		url : "UserMasterDetail.htm",
		data : $("#SDC-FORM").serialize(),
		error : function(xhr, status, error) {
			var err = xhr.responseText;
			if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
				window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
			}
		},
		beforeSend : function() {
		},
		success : function(response) {
			var data = JSON.parse(response);
			if(parseInt(data.SaveStatus) == 1){
				$('#modalheader').html('<p class="text-success semi-bold text-uppercase fs-16">Success!!</p>');
				$('#modalbody').html(data.successMsg);
				$('#modalfooter').css('display','none');
				$('#generalmodal').modal('show');
				successflag=true;
			}else{
				$('#modalheader').html('<p class="text-success semi-bold text-uppercase fs-16">Error!!</p>');
				$('#modalbody').html(data.errorMsg);
				$('#modalfooter').css('display','none');
				$('#generalmodal').modal('show');
				successflag=false;
			}
		},
		complete : function() {
		}
	}); 	
}

function disable(){
	$('body').find('select').each(function() {
		$(this).attr("disabled", "disabled");
		$(this).select2();
	});
	$('#userid').attr("readonly", "readonly");
	$('#username').attr("disabled", "disabled");
	$('#empcode').attr("disabled", "disabled");
}