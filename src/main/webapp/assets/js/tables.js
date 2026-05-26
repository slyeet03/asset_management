/* ============================================================
 * Tables
 * Generate advanced tables with sorting, export options using
 * jQuery DataTables plugin
 * For DEMO purposes only. Extract what you need.
 * ============================================================ */
(function($) {

    'use strict';

    // Initialize a basic dataTable with row selection option
    var initBasicTable = function() {

        var table = $('#basicTable');

        var settings = {
            "sDom": "t",
            "sPaginationType": "bootstrap",
            "destroy": true,
            "paging": false,
            "scrollCollapse": true,
            "aoColumnDefs": [{
                'bSortable': false,
                'aTargets': [0]
            }],
            "order": [
                [1, "desc"]
            ]

        };

        table.dataTable(settings);

        $('#basicTable input[type=checkbox]').click(function() {SubGroupList
            if ($(this).is(':checked')) {
                $(this).closest('tr').addClass('selected');
            } else {
                $(this).closest('tr').removeClass('selected');
            }

        });

    }

    // Initialize a dataTable having bootstrap's stripes style
    var initStripedTable = function() {

        var table = $('#stripedTable');

        var settings = {
            "sDom": "t",
            "sPaginationType": "bootstrap",
            "destroy": true,
            "paging": false,
            "scrollCollapse": true

        };
        table.dataTable(settings);

    }

    // Initialize a dataTable with collapsible rows to show more details
    var initDetailedViewTable = function() {

        var _format = function(d) {
            // `d` is the original data object for the row
            return '<table class="table table-inline">' +
                '<tr>' +
                '<td>Learn from real test data <span class="label label-important">ALERT!</span></td>' +
                '<td>USD 1000</td>' +
                '</tr>' +
                '<tr>' +
                '<td>PSDs included</td>' +
                '<td>USD 3000</td>' +
                '</tr>' +
                '<tr>' +
                '<td>Extra info</td>' +
                '<td>USD 2400</td>' +
                '</tr>' +
                '</table>';
        }


        var table = $('#detailedTable');

        table.DataTable({
            "sDom": "t",
            "scrollCollapse": true,
            "paging": false,
            "bSort": false
        });

        // Add event listener for opening and closing details
        $('#detailedTable tbody').on('click', 'tr', function() {
            //var row = $(this).parent()
            if ($(this).hasClass('shown') && $(this).next().hasClass('row-details')) {
                $(this).removeClass('shown');
                $(this).next().remove();
                return;
            }
            var tr = $(this).closest('tr');
            var row = table.DataTable().row(tr);

            $(this).parents('tbody').find('.shown').removeClass('shown');
            $(this).parents('tbody').find('.row-details').remove();

            row.child(_format(row.data())).show();
            tr.addClass('shown');
            tr.next().addClass('row-details');
        });

    }

    // Initialize a condensed table which will truncate the content 
    // if they exceed the cell width
    var initCondensedTable = function() {
        var table = $('#condensedTable');

        var settings = {
            "sDom": "t",
            "sPaginationType": "bootstrap",
            "destroy": true,
            "paging": false,
            "scrollCollapse": true
        };

        table.dataTable(settings);
    }

    initBasicTable();
    initStripedTable();
    initDetailedViewTable();
    initCondensedTable();
    
    
    
    
    
    
    $('#grpButton').click(function(){
    	$('#subGroupModal').modal('show');
    });
    $('#grpButton1').click(function(){
    	$('#subGroupModal1').modal('show');
    });
    
    $('#grpButton2').click(function(){
    	$('#subGroupModal2').modal('show');
    });
    $('#grpButton3').click(function(){
    	$('#subGroupModal3').modal('show');
    });
    
    
    
    
    
    
    
    $("#SubGroupForm").validate({
		submitHandler: function() {
			 $.ajax({
				type : "POST",
				url : "Chart_of_account_Detail.html",
				data : $("#SubGroupForm").serialize(),
				error : function(xhr, status, error) {
					var err =  xhr.responseText;
					if(err.toLowerCase().indexOf("session_timed_out") >= 0){
						window.location="login.html?statusCheck=SessionExpired";
					}
					alert(error);
				},
				beforeSend : function() {},
				success : function(response) {
					$('#subGroupModal').modal('hide');
				},
				complete : function() {
				
				}
			}); 			
		}	
	});
    $("#SubGroupForm1").validate({
		submitHandler: function() {
			 $.ajax({
				type : "POST",
				url : "Chart_of_account_Detail.html",
				data : $("#SubGroupForm1").serialize(),
				error : function(xhr, status, error) {
					var err =  xhr.responseText;
					if(err.toLowerCase().indexOf("session_timed_out") >= 0){
						window.location="login.html?statusCheck=SessionExpired";
					}
					alert(error);
				},
				beforeSend : function() {},
				success : function(response) {
					$('#subGroupModal1').modal('hide');
				},
				complete : function() {
				
				}
			}); 			
		}	
	});
    $("#SubGroupForm2").validate({
		submitHandler: function() {
			 $.ajax({
				type : "POST",
				url : "Chart_of_account_Detail.html",
				data : $("#SubGroupForm2").serialize(),
				error : function(xhr, status, error) {
					var err =  xhr.responseText;
					if(err.toLowerCase().indexOf("session_timed_out") >= 0){
						window.location="login.html?statusCheck=SessionExpired";
					}
					alert(error);
				},
				beforeSend : function() {},
				success : function(response) {
					$('#subGroupModal2').modal('hide');
				},
				complete : function() {
				
				}
			}); 			
		}	
	});
    $("#SubGroupForm3").validate({
		submitHandler: function() {
			 $.ajax({
				type : "POST",
				url : "Chart_of_account_Detail.html",
				data : $("#SubGroupForm3").serialize(),
				error : function(xhr, status, error) {
					var err =  xhr.responseText;
					if(err.toLowerCase().indexOf("session_timed_out") >= 0){
						window.location="login.html?statusCheck=SessionExpired";
					}
					alert(error);
				},
				beforeSend : function() {},
				success : function(response) {
					$('#subGroupModal3').modal('hide');
				},
				complete : function() {
				
				}
			}); 			
		}	
	});
})(window.jQuery);
function getGroup(main,subgrup){
	var mainId = '#'+main;
	var subgrupId = '#'+subgrup;
	var mainVal = $(mainId).val();
	var element = '<option value="">Please Select</option>';
	if(mainVal == "BS"){
		element = element+'<option value="Asset">Asset</option><option value="Liability">Liability</option>';
		$(subgrupId).html(element);
		$(subgrupId).select2();
	}
	if(mainVal == "PL"){
		element = element+'<option value="Income">Income</option><option value="Expense">Expense</option>';
		$(subgrupId).html(element);
		$(subgrupId).select2();
	}
}
function getSubGroup(main,grup,subgrup){
	var mainId = '#'+main;
	var mainVal = $(mainId).val();
	var subgrupId = '#'+subgrup;
	var grupId  = '#'+grup;
	var grupVal = $(grupId).val();
	var element = '<option value="">Please Select</option>';
	$.ajax({
		type : "POST",
		url : "getSubGroupDetail.html",
		data:{main:mainVal,grup:grupVal,paratype:"subgrup"},
		error : function(xhr, status, error) {
			var err =  xhr.responseText;
			if(err.toLowerCase().indexOf("session_timed_out") >= 0){
				window.location="login.html?statusCheck=SessionExpired";
			}else{
				alert("error");
			}
		},
		beforeSend : function() {},
		success : function(response) {
			var data = jQuery.parseJSON(response);
			var element = '<option value="" selected="selected">Please Select</option>';
			if(data.error == "false"){
				$(subgrupId).html(element);
				$(subgrupId).select2();
				for(var i =0; i < data.SubGroupList.length;i++ ){
					element = element+'<option value="'+data.SubGroupList[i][0]+'">'+data.SubGroupList[i][4]+'</option>';
				}
				$(subgrupId).html(element);
				$(subgrupId).select2();
			}
		},
		complete : function() {}
	});
}
function getSubGroup1(main,grup,subgrup,subgrup1){
	var mainId = '#'+main;
	var mainVal = $(mainId).val();
	var grupId  = '#'+grup;
	var grupVal = $(grupId).val();
	var subgrupId = '#'+subgrup;
	var subgrupVal = $(subgrupId).val();
	var subgrup1Id = '#'+subgrup1;
	var element = '<option value="">Please Select</option>';
	$.ajax({
		type : "POST",
		url : "getSubGroupDetail.html",
		data:{main:mainVal,grup:grupVal,subgrup:subgrupVal,paratype:"subgrup1"},
		error : function(xhr, status, error) {
			var err =  xhr.responseText;
			if(err.toLowerCase().indexOf("session_timed_out") >= 0){
				window.location="login.html?statusCheck=SessionExpired";
			}else{
				alert("error");
			}
		},
		beforeSend : function() {},
		success : function(response) {
			var data = jQuery.parseJSON(response);
			var element = '<option value="" selected="selected">Please Select</option>';
			if(data.error == "false"){
				$(subgrup1Id).html(element);
				$(subgrup1Id).select2();
				for(var i =0; i < data.SubGroupList.length;i++ ){
					element = element+'<option value="'+data.SubGroupList[i][0]+'">'+data.SubGroupList[i][4]+'</option>';
				}
				$(subgrup1Id).html(element);
				$(subgrup1Id).select2();
			}
		},
		complete : function() {}
	});
}
function getSubGroup2(main,grup,subgrup,subgrup1,subgrup2){
	var mainId = '#'+main;
	var mainVal = $(mainId).val();
	
	var grupId  = '#'+grup;
	var grupVal = $(grupId).val();
	
	var subgrupId = '#'+subgrup;
	var subgrupVal = $(subgrupId).val();
	
	var subgrup1Id = '#'+subgrup1;
	var subgrup1Val = $(subgrup1Id).val();
	
	var subgrup2Id = '#'+subgrup2;
	
	var element = '<option value="">Please Select</option>';
	$.ajax({
		type : "POST",
		url : "getSubGroupDetail.html",
		data:{main:mainVal,grup:grupVal,subgrup:subgrupVal,subgrup1:subgrup1Val,paratype:"subgrup2"},
		error : function(xhr, status, error) {
			var err =  xhr.responseText;
			if(err.toLowerCase().indexOf("session_timed_out") >= 0){
				window.location="login.html?statusCheck=SessionExpired";
			}else{
				alert("error");
			}
		},
		beforeSend : function() {},
		success : function(response) {
			var data = jQuery.parseJSON(response);
			var element = '<option value="" selected="selected">Please Select</option>';
			if(data.error == "false"){
				$(subgrup2Id).html(element);
				$(subgrup2Id).select2();
				for(var i =0; i < data.SubGroupList.length;i++ ){
					element = element+'<option value="'+data.SubGroupList[i][0]+'">'+data.SubGroupList[i][4]+'</option>';
				}
				$(subgrup2Id).html(element);
				$(subgrup2Id).select2();
			}
		},
		complete : function() {}
	});
}