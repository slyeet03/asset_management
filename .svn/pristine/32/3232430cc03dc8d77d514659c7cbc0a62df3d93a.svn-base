(function($) {

	'use strict';
	$(document).ready(
			function() {
				$('[data-toggle="tooltip"]').tooltip();
				try {
					var data = getuserlevel();
					// data[0] = userlevel and data[1] = rolename
					if ((data[0] >= 6 && data[0] <= 15)
							|| (data[0] >= 26 && data[0] <= 30)) {
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
				} catch (err) {
				
				}
				
			});
})(window.jQuery);