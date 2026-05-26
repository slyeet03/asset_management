var successflag = false;
$(function() {
	var token = $(".csrf").val();
	var header = "X-CSRF-TOKEN";
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token)
	});
	var update = $('#Update').val();

	if (update.length > 0) {
		$('#submitbtn').css('display', 'none');

		if (update == 1) {
			$('#btngrp').css('display', 'none');
			$('#updatebtn').css('display', 'block');

		} else {
			$('#btngrp').css('display', 'block');

		}
	}

	if (disable1 == 1) {
		$('#submitbtn').css('display', 'none');
		$('#clearbtn').css('display', 'none');
		$('#btngrp').css('display', 'block');

		disable();
	}


	$('#Reject').click(function(event) {
		$('#action').val('Reject');
		submitform();
	});
	$('#Approve').click(function(event) {
		$('#action').val('Approve');
		submitform();
	});

	$('#Delete').click(function(event) {
		$('#action').val('Delete');
		submitform();
	});

	$("#updatebtn").click(function(event) {
		event.preventDefault();
		if ($('#SDC-FORM').valid()) {

			submitform();

		} else {
			$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
			$('#modalbody').html('Please Check your form again. Invalid Data!!');
			$('#modalfooter').css('display', 'none');
			$('#generalmodal').modal('show');
			successflag = false;
		}
	});

	$("#submitbtn").click(function(event) {

		event.preventDefault();
		var validate = $('#SDC-FORM').validate();
		if ($('#SDC-FORM').valid()) {

			submitform();
			$('body').find('select').each(function() {
				$(this).val('');
				$(this).select2();
			});
			$('#SDC-FORM').trigger('reset');
			$('.close').click(function(event) {
				location.reload();
			});

			document.onkeydown = function(evt) {
				evt = evt || window.event;
				if (evt.keyCode == 27) {
					location.reload();
				}
			};
		} else {
			$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
			$('#modalbody').html('Please Check your form again. Invalid Data!!');
			$('#modalfooter').css('display', 'none');
			$('#generalmodal').modal('show');
			successflag = false;
		}
	});

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


function disable() {
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
				successflag = false;
			}
		},
		complete: function() {
			$.unblockUI();
		}
	});

}


function Amount(inputNumber, outputControl) {
	var str = new String(inputNumber);
	var splt = str.split("");
	var rev = splt.reverse();
	var once = ['Zero', ' One', ' Two', ' Three', ' Four', ' Five', ' Six', ' Seven', ' Eight', ' Nine'];
	var twos = ['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];
	var tens = ['', 'Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety'];

	numLength = rev.length;
	var word = new Array();
	var j = 0;

	for (i = 0; i < numLength; i++) {
		switch (i) {

			case 0:
				if ((rev[i] == 0) || (rev[i + 1] == 1)) {
					word[j] = '';
				}
				else {
					word[j] = '' + once[rev[i]];
				}
				word[j] = word[j];
				break;

			case 1:
				aboveTens();
				break;

			case 2:
				if (rev[i] == 0) {
					word[j] = '';
				}
				else if ((rev[i - 1] == 0) || (rev[i - 2] == 0)) {
					word[j] = once[rev[i]] + " Hundred ";
				}
				else {
					word[j] = once[rev[i]] + " Hundred and";
				}
				break;

			case 3:
				if (rev[i] == 0 || rev[i + 1] == 1) {
					word[j] = '';
				}
				else {
					word[j] = once[rev[i]];
				}
				if ((rev[i + 1] != 0) || (rev[i] > 0)) {
					word[j] = word[j] + " Thousand";
				}
				break;


			case 4:
				aboveTens();
				break;

			case 5:
				if ((rev[i] == 0) || (rev[i + 1] == 1)) {
					word[j] = '';
				}
				else {
					word[j] = once[rev[i]];
				}
				if (rev[i + 1] !== '0' || rev[i] > '0') {
					word[j] = word[j] + " Lakh";
				}

				break;

			case 6:
				aboveTens();
				break;

			case 7:
				if ((rev[i] == 0) || (rev[i + 1] == 1)) {
					word[j] = '';
				}
				else {
					word[j] = once[rev[i]];
				}
				if (rev[i + 1] !== '0' || rev[i] > '0') {
					word[j] = word[j] + " Crore";
				}

				break;

			case 8:
				aboveTens();
				break;

			//            This is optional. 

			case 9:

				if (rev[i] == 0) {
					word[j] = '';
				}
				if (rev[i] == 0) {
					word[j] = '';
				}
				else if ((rev[i - 1] !== 0) || (rev[i] > '0')) {
					word[j] = once[rev[i]] + " Hundred Crore	 ";
				}
				else {
					word[j] = word[j] + " Crore";;
				}


				break;
			/*
			   if ((rev[i] == 0) || (rev[i + 1] == 1)) {
					word[j] = '';
				}
				else {
				 word[j] = once[rev[i]];
				}
				if (rev[i + 1] == '0' || rev[i] > '0') {
				
					word[j] = once[rev[i]] + " Hundred Crore";
				}
				 	
				else {
					
					word[j] = once[rev[i]] + " Hundred and" ;
				}
				
				 
				
				break;
				*/

			case 10:
				aboveTens();
				break;

			default: break;
		}
		j++;
	}

	function aboveTens() {
		if (rev[i] == 0) { word[j] = ''; }
		else if (rev[i] == 1) { word[j] = twos[rev[i - 1]]; }
		else { word[j] = tens[rev[i]]; }
	}

	word.reverse();
	var finalOutput = '';
	for (i = 0; i < numLength; i++) {
		finalOutput = finalOutput + word[i];
	}
	document.getElementById(outputControl).innerHTML = finalOutput;
}
function onlyAlphaNumeric(e, t) {
	try {
		if (window.event) {
			var charCode = window.event.keyCode;
		}
		else if (e) {
			var charCode = e.which;
		}
		else { return true; }
		if ((charCode >= 48 && charCode <= 57) || (charCode >= 65 && charCode <= 91) || (charCode >= 97 && charCode <= 123) || charCode == 32)
			return true;
		else
			return false;
	}
	catch (err) {
		//         alert(err.Description);
	}
}