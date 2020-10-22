$(function(){
		$.getJSON(
				"json/stuSch",
				function(json){
					$('#schMsg').append("<option/>");
					$.each(json,function(i,item){
						$('#schMsg').append("<option value="+item.id+">"+item.name+"</option>");
					});
				}
			);

		$('#schMsg').change(function(){
				var sc=$(this).val();
				$.getJSON(
						'json/stuCol',
						{'id':sc},
						function(data){
							
							$('#depMsg').html("");
							$('#majMsg').html("");
							$('#depMsg').append("<option/>");
							$.each(data,function(i,item){
								
								$('#depMsg').append("<option value="+item.id+">"+item.name+"</option>");
							});
						}
				);
		});
		
		$('#colMsg').change(function(){
			var sc=$(this).val();
			$.getJSON(
					'json/stuMaj',
					{'id':sc},
					function(data){
						$('#majMsg').html("");
						$('#majMsg').append("<option/>");
						$.each(data,function(i,item){
							$('#majMsg').append("<option value="+item.id+">"+item.name+"</option>");
						});
					}
			);
	});
});