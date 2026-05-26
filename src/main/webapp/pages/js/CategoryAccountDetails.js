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
				window.location.href = './CategoryAccountDetailsGrid.htm?recstatus=' + recstatus + '&prev=' + prev + '&next=' + next + '&Update=' + update;
			}
		}
	});
});


$('#assetbranch').change(function(e) {
	var branchcode = $('#assetbranch :selected').val();
	$.ajax({
		url: "getCategoryByAssetBranch.json",
		type: "POST",
		data: {
			branchcode: branchcode,
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
			var catcode = "<option value=\"\"> Please Select</option>";
			for (var i = 0; i < response.detail.length; i++) {
				var innerarray = response.detail[i];
				catcode += "<option value=\"" + innerarray.assetcategorycode + "\">" + innerarray.assetcategorycode + "-" + innerarray.categorydescription + "</option>";
				console.log("assetcode: " + innerarray.assetcategorycode + " asset desc: " + innerarray.categorydescription);
			}
			$('#categoryid').html(catcode);
			$('#categoryid').val('');
			$('#categoryid').select2();
		}

	});
});

