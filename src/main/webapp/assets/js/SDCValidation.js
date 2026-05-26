(function($) {
	'use strict';
	$(document).ready(function() {
						$(".mobile").autoNumeric('init',{aSep: '',vMin: '0',vMax:'9999999999'});
						$(".landline").autoNumeric('init',{aSep: '',vMin: '0',vMax:'99999999999'});
						$(".accnumb").autoNumeric('init',{aSep: '',vMin: '0',vMax:'999999999999999'});						
						$(".rate").autoNumeric('init',{aSep: '',vMin: '0',vMax:'9999999.99',mDec:'2'});
						$(".amount").autoNumeric('init',{aSep: '',vMin: '0',vMax:'9999999999999.99',mDec:'2'});
						$('.Micrcode').mask("999999999");
						$('.pincode').mask("999999");						
						$('.datepickermasking').mask("99/99/9999");
						$('[data-toggle="tooltip"]').tooltip();						
						$(".aadhar").autoNumeric('init',{aSep: '',vMin: '0',vMax:'999999999999'});
						$(".useridval").autoNumeric('init',{aSep: '',vMin: '0',vMax:'9999999'});
						$(".number").autoNumeric('init',{aSep: '',vMin: '0',vMax:'99999999999999999999'});
						$(".unitnos").autoNumeric('init',{aSep: '',vMin: '0',vMax:'99999999999.9999',mDec:'4'});
						
						$(".bgl").alphanum({
							maxLength	  : 6
						});
						
						$(".divbgl").alphanum({
							maxLength	  : 17
						});
						
						$(".name1").alphanum({
							allowNumeric  : false,
							allowUpper    : true,
							allowLower    : true,
							allowCaseless : true,
							allow : '.&,',
							maxLength	  : 50
						});
						
						$(".isinfd").alphanum({
							allowNumeric  : true,
							allowUpper    : true,
							allowLower    : true,
							allowCaseless : true,							
							maxLength	  : 20
						});
						
						$(".desc").alphanum({
							allowNumeric  : true,
							allowUpper    : true,
							allowLower    : true,
							allowCaseless : true,	
							allow : '.:_-//&?"\'@(){}[]',
							maxLength	  : 50
						});
						
						$(".cifno").alphanum({
							allowNumeric  : true,
							allowUpper    : false,
							allowLower    : false,
							allowCaseless : true,
							maxLength	  : 17
						});
						
						$(".pancard").alphanum({
							allowUpper    : true,
							allowLower    : false,
							allowNumeric  : true,
							allowCaseless : true,
							//maxLength	  : 10
						});
						
						$(".tanid").alphanum({
							allowUpper    : true,
							allowLower    : false,
							allowNumeric  : true,
							allowCaseless : true,
							maxLength	  : 10
						});
						
						$(".useridval").alphanum({											
							maxLength	  : 7
						});
						
						$(".alphanumb").alphanum();
						$(".website").alphanum({
							allow : '.:_-//&?"\'@',
							maxLength: 50
						});
						
						$(".IFSC").alphanum({
							allowLower    : false,
							allowCaseless : true,
							maxLength:11
						});
									
						
						$(".GSTNO").alphanum({
							allowNumeric  : true,
							allowSpace	  : false,
							allowLower    : false,
							maxLength	  : 15
						});
					
						$(".address").alphanum({
							allowNumeric  : true,
							allowUpper    : true,
							allowLower    : true,
							allowCaseless : true,
							maxLength	  : 50,
							allow		  :'.,:-()//'
						});						
					
						$(".loanacct").alphanum({
							allowNumeric  : true,
							allowUpper    : false,
							allowLower    : false,
							allowCaseless : true,
							maxLength	  : 17
						});
						
						$.validator.addMethod("pancard",function(value, element) {
									return this.optional(element)
											|| /^[A-Z]{3}[G|A|F|C|T|H|P]{1}[A-Z]{1}\d{4}[A-Z]{1}$/
													.test($(element)
															.val());
								}, "Please Enter Valid Pan Number!!");
						
						$.validator.addMethod("tanid",function(value, element) {
							return this.optional(element)
									|| /^[A-Z]{4}[0-9]{5}[A-Z]{1}$/
											.test($(element)
													.val());
						}, "Please Enter Valid Tan Number!!");
				
						
						$.validator.addMethod("GSTNO", function(value,element) {
							return this.optional(element)|| /[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][0-9][Z][0-9A-Z]/.test($(element).val());
						}, "Please Enter Valid GSTIN!!");
						
						$.validator.addMethod("DGSTNO", function(value,element) {
							return duplicateGstinEntry(element);
						}, "GSTIN Number Already Exists!!");
						
						$.validator.addMethod("email",function(value, element) {
							return this.optional(element)|| isEmail(element);
						}, "Please Enter  Valid EmailId!!");
						
						$.validator.addMethod("Micrcode",function(value, element) {
							return duplicateEntry(element);
						}, "Micr Code already Exists!!");
												
						$.validator.addMethod("cifno",function(value, element) {
							return duplicateEntry(element);
						}, "CIF Number already Exists!!");
					
						$.validator.addMethod("useridval",function(value, element) {
							return duplicateTellerEntry(element);
						}, "Teller Id already Exists!!");
						
						$.validator.addMethod("loanacct",function(value, element) {
							return duplicateEntry(element);
						}, "Loan Account Number already Exists!!");
						
						$('#SDC-FORM').validate({
							  invalidHandler: function(event, validator) {
								  try{
									  var className = $("#SDC-FORM").validate().errorList[0].element.className.split(' ').join(', .');
									  className = "."+className;
									  var PaneId = "#"+$(className).parents().find(".tab-pane").attr("id");
									  $('#rootwizard').find(' a[href="'+PaneId+'"] ').tab('show');
									}catch(e){
										console.log(e);
									}
								  }

						});
					});
	
	function isEmail(f, mandatoryCheck) {
		var val = $(f).val();
		var isValid = true;
		var string = val.length;
		// var iChars = "";
		if (!/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(val)) {isValid = false;} 
		else {isValid = true;}
		return isValid;
	}
	
	function duplicateEntry(f) {
		if(list==null || list==""){return true;}else{
		var list1 = list;
		list1= list1.split("[")[1].split("]")[0].split(",");
		for ( var i = 0; i < list1.length; i++) {
			if (list1[i].trim().toUpperCase() == $(f).val().trim().toUpperCase()) {
				return false;
			}
		}
		return true;
		}
	}
	
	function duplicateTellerEntry(f) { debugger;
		if(list==null || list==""){return true;}else{
		var list1 = list;
		list1= list1.split("[")[1].split("]")[0].split(",");
		var length = $('#userid').attr("maxlength"); 
		var diff = length - f.textLength; 
		f = new Array( diff+1 ).join("0") + $(f).val();	
		for ( var i = 0; i < list1.length; i++) {
			if (list1[i].trim().toUpperCase() == f.trim().toUpperCase()) {				
				return false;
			}
		}
		return true;
		}
	}
	
})(window.jQuery);