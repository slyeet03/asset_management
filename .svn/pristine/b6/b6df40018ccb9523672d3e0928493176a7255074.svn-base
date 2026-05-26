var successflag = false;
$(function(){
	alert('hi')	
	$('#Reject').click(function(event){  
		count('Reject');
	});		
	$('#Approve').click(function(event){
		count('Approve');
	});
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
	
	
	var table = $('#tableWithSearch');
    var settings = {
        "sDom": "<'table-responsive't><'row'<p i>>",
        "sPaginationType": "bootstrap",
        "destroy": true,
        "scrollCollapse": true,
        "oLanguage": {
            "sLengthMenu": "_MENU_ ",
            "sInfo": "Showing <b>_START_ to _END_</b> of _TOTAL_ entries"
        },
        "iDisplayLength": 5
    };
    table.dataTable(settings);
    $('#search-table').keyup(function() {
        table.fnFilter($(this).val());
    });
	

	var prev = $('#prev').val();
	if (prev == null || prev == "") {
		$('#btngrp').css('display','none');
		var table = $('#tableWithSearch');
		table.dataTable().fnSetColumnVis(0,false,true);
	}
	
});

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
				successflag = true;
			}else{
				$('#modalheader').html('<p class="text-success semi-bold text-uppercase fs-16">Error!!</p>');
				$('#modalbody').html(data.errorMsg);
				$('#modalfooter').css('display','none');
				$('#generalmodal').modal('show');
			}
		},
		complete : function() {
		}
	}); 	
}

$(document).ready(function() {
	$('#select_all').on('click', function() {
		if (this.checked) {
			$('.checkbox').each(function() {
				this.checked = true;
			});
		} else {
			$('.checkbox').each(function() {
				this.checked = false;
			});
		}

	});

	$('.checkbox').on('click', function() {
		if ($('.checkbox:checked').length == $('.checkbox').length) {
			$('#select_all').prop('checked', true);
		} else {
			$('#select_all').prop('checked', false);
		}
	});
});
function count(act) {
	$('#action').val(act);
	var data = false;
	$('input[type="checkbox"][name="userid"]').each(
			function() {
				if ($(this).prop("checked")) {
					data = true;
				}
			});
	if (!data) {
		$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
		$('#modalbody').html('Please Select Record<br>Before Proceeding...');
		$('#modalfooter').css('display','none');
		$('#generalmodal').modal('show');
		return false;
	}else {
		submitform();
	}
	return false;
}