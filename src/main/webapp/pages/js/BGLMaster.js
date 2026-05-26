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
				window.location.href = './BGLMasterGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
	    }
	});	
});

//Edited By Akshay K Maske on Date : 21-10-2021 
$('#bglnumb').on('change',function(){
//	alert('hii');
	var bgl=$('#bglnumb').val();
 $.ajax({
		url : "checkbgl.htm",
		type : "POST",
		data : {
			bgl : bgl
		       },
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
		success : function(response){
	    	//alert(response.bglNum);
	    
	    	if(response.bglNum){
	    		$('#bglnumb').val("");
	    		alert(" bgl number is already present ")}
	    }
	});
});

//end
