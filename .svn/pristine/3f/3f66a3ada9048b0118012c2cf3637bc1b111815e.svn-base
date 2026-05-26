var successflag = false;
$(function() {
	var token = $(".csrf").val();
	var header = "X-CSRF-TOKEN";
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token)
	});

	if (update.length > 0) {
		$('#submitbtn').css('display', 'none');
		if (update == 1) {
			$('#btngrp').css('display', 'none');
			$('#updatebtn').css('display', 'block');
		} else {
			$('#btngrp').css('display', 'block');
		}
	}

	$('#generalmodal').on('hidden.bs.modal', function() {
		var update = $('#Update').val();
		if (successflag) {
			if (update.length > 0) {
				var recstatus = $('#recstatus').val();
				var prev = $('#prev').val();
				var next = $('#next').val();
				window.location.href = './VendorMasterGrid.htm?recstatus=' + recstatus + '&prev=' + prev + '&next=' + next + '&Update=' + update;
			}
		}
	});
	$('#state').change(function(e) {
		$('#emsg').text('');
		CitySatewise();
	});
});
function CitySatewise() {
	var state = $('#state :selected').val();

	$.ajax({
		url: "getCityStatewise.json",
		type: "POST",
		data: {
			state: state,
		},
		dataType: "json",
		async: false,
		error: function(xhr, status, error) {
			var err = xhr.responseText;
			if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
				window.location = "Login.htm?statusCheck=SessionExpired";
			}
		},
		beforeSend: function() {
		},
		success: function(response) {
			var city = "<option value=\"\"> Please Select</option>";
			for (var i = 0; i < response.city.length; i++) {
				var innerarray = response.city[i];
				city += "<option value=\"" + innerarray.code + "\">" + innerarray.code + "-" + innerarray.ldesc + "</option>";
			}
			$('#city').html(city);
			$('#city').val('');
			$('#city').select2();
		}

	});
}

