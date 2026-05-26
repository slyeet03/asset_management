var successflag = false;
$(function() {
	var token = $(".csrf").val();
	var header = "X-CSRF-TOKEN";
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token)
	});
	$('#Reject').click(function(event) {

		count('Reject');
	});
	$('#Approve').click(function(event) {
		count('Approve');
	});
	$('#Delete').click(function(event) {
		count('Delete');
	});

	var initTableWithDynamicRows = function() {
		var table = $('#tableWithSearch');
		var settings = {
			"scrollY": "300px",
			"scrollX": false,
			"scrollCollapse": true,
			"paging": false,
			"ordering": true,
			"searching": true,
			"info": false,
			searching: true,
		};
		table.dataTable(settings);
		$(".dataTables_scrollBody").scrollbar();
		$(".dataTables_scrollBody").css("height", "300px");
		$(".dataTables_scrollHeadInner").css("width", "100%");
		$("#tableWithSearch").css("width", "100%");
		$(".dataTables_scrollHeadInner").children("table").css("width", "100%");
		$(".scrollbar-wrapper").scrollbar();
		$('#search-table').keyup(function() {
			table.fnFilter($(this).val());
		});
	}
	initTableWithDynamicRows();

	var prev = $('#prev').val();
	if (prev == null || prev == "") {
		$('#btngrp').css('display', 'none');
		var table = $('#tableWithSearch');
		table.dataTable().fnSetColumnVis(0, false, true);
		//table.dataTable().fnSetColumnVis(7,false,true);
	}

	$("#continuebtn").click(function(event) {
		var data = $('#delete-SDCFORM').submit();
	});

	$("#clearbtn").click(function(event) {
		$('#SDC-FORM').trigger('reset');
	});
});

function filldetails(val) {
	var element = "<input type=\"hidden\" value=\"" + val + "\" name=\"recordid\"/>";
	$('#SDC1-FORM').append(element);
	$('#SDC1-FORM').submit();
}
function submitform() {
	var url = $('#SDC-FORM').attr("action");
	$.ajax({
		type: "POST",
		url: url,
		data: $("#SDC-FORM").serialize(),
		error: function(xhr, status, error) {
			var err = xhr.responseText;
			if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
				window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
			}
		},
		beforeSend: function() {
			$.blockUI();
		},
		success: function(response) {
			var data = JSON.parse(response);
			if (parseInt(data.SaveStatus) == 1) {
				$('#modalheader').html('<p class="text-success semi-bold text-uppercase fs-16">Success!!</p>');
				$('#modalbody').html(data.successMsg);
				$('#modalfooter').css('display', 'none');
				$('#generalmodal').modal('show');
				successflag = true;
			} else {
				$('#modalheader').html('<p class="text-success semi-bold text-uppercase fs-16">Error!!</p>');
				$('#modalbody').html(data.errorMsg);
				$('#modalfooter').css('display', 'none');
				$('#generalmodal').modal('show');
			}
		},
		complete: function() {
			$.unblockUI();
		}
	});
}

function count(act) {
	$('#action').val(act);
	var data = false;
	$('input[type="checkbox"][name="recordid"]').each(
		function() {
			if ($(this).prop("checked")) {
				data = true;
			}
		});
	if (!data) {
		$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
		$('#modalbody').html('Please Select Record<br>Before Proceeding...');
		$('#modalfooter').css('display', 'none');
		$('#generalmodal').modal('show');
		return false;
	} else {
		submitform();
	}
	return false;
}
