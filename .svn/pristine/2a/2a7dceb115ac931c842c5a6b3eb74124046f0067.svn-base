var successflag = false;
$(function(){	
	$('#generalmodal').on('hidden.bs.modal', function () {
	    var update =$('#Update').val();
	    if(successflag){
			if(update.length>0){
				var recstatus=$('#recstatus').val();
				var prev=$('#prev').val();
				var next=$('#next').val();
				window.location.href = './AssetCategoryMasterGrid.htm?recstatus='+recstatus+'&prev='+prev+'&next='+next+'&Update='+update; 
			}
	    }
	});

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

