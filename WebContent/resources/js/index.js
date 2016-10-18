$(function(){
	
	$("#form_select").submit(function(event){
		event.preventDefault();
		
		$('#table_div').load('staffs_byselect .table',
				'department='+$('.department  option:selected').text()
				+ '&position='+ $('.position option:selected').text()
				+ '&cert='+$('.cert option:selected').text()
				+ '&month=' + $('.salary').val(), 
				function(){
			var table1 = $('#table').DataTable({
				"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
				"bDestroy": true,
				"drawCallback": function(){
					
					if($('.listSalary').val() == "0")  $('.hidden_column').hide();
					//alert("id = " + $('.listSalary').val());
					
					$('.detail').on("click", function () {
						var id = $(this).parents('tr').children('td').eq(1).text().trim();
						$(".modal-title").text("Detail Information");
						$(".modal-body").load("detail.html .table_detail", "id=" + id);
						$(".modal-footer").load("detail.html .button-modal", "id=" + id, function () {
							$('#close-button').on('click', function () {
								table1.$('tr.selected').removeClass('selected');
							});
						});
					});
				}});
		});
	})

		var table = $('#table').DataTable({
			searching:false,
			"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
	        "drawCallback": function () {	
	        	
				//if($('.listSalary').val() == "0")  $('.hidden_column').hide();
				//alert("id = " + $('.listSalary').val());
				
				$('.detail').on("click", function () {
					var id = $(this).parents('tr').children('td').eq(1).text().trim();
					$(".modal-title").text("Detail Information");
					$(".modal-body").load("detail.html .table_detail", "id=" + id);
					$(".modal-footer").load("detail.html .button-modal", "id=" + id, function () {
						$('#close-button').on('click', function () {
							table.$('tr.selected').removeClass('selected');
						});
					});
				});
			}});


})