var successflag=false;
$(function(){
	$('#generalmodal').on('hidden.bs.modal', function () {
	    var update =$('#Update').val();
		if(successflag){
		    if(update.length>0){
				var recstatus=$('#recstatus').val();
				var prev=$('#prev').val();
				var next=$('#next').val();
				window.location.href = './CategoryAccountDetailsGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
		}
	});	
});

function count(act) {
	$('#action').val(act);
	$("input[name='recordid']:checked").each(function(){
		submitform();
		return true;
	});
	$('#modalheader').html('<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>');
	$('#modalbody').html('Please Select Record<br>Before Proceeding...');
	$('#modalfooter').css('display','none');
	$('#generalmodal').modal('show');
	return false;
}
	