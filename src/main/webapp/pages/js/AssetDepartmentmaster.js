$(function(){
	$('#generalmodal').on('hidden.bs.modal', function () {
	    var update =$('#Update').val();
	    if(successflag){
			if(update.length>0){
				var recstatus=$('#recstatus').val();
				var prev=$('#prev').val();
				var next=$('#next').val();
				window.location.href = './AssetDepartmentMasterGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
	    }
	});	
});

