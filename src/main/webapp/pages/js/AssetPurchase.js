var successflag=false;
$(function(){
	var token = $(".csrf").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token)
    });
 
    if (update.length > 0) {
		$('#submitbtn').css('display', 'none');		
		if(update==1){
			$('#btngrp').css('display','none');
			$('#updatebtn').css('display', 'block');				
		}else {
			$('#btngrp').css('display','block');
		}
	}
	
	$('#generalmodal').on('hidden.bs.modal', function () {
	    var update =$('#Update').val();
	    if(successflag){
			if(update.length>0){
				var recstatus=$('#recstatus').val();
				var prev=$('#prev').val();
				var next=$('#next').val();				
				window.location.href = './AssetMasterGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
	    }
	});
	
	$('#assetpodate').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
	$('#assetinvoicedate').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
	$('#assetservicestartdate').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
	$('#assetserviceenddate').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true,
		endDate: '+0d',
	});
		
});
