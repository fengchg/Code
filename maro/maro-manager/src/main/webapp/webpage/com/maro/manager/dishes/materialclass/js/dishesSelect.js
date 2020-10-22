
    //打开原料查找页面
	function openDishesSelect(th,index){
		//createwindow('原料列表', 'maroDishesController.do?materialSelect',$(document).width()-100,$(document).height());
		
		$.dialog({
			content: 'url:maroMaterialClassController.do?dishesSelect',
			lock : true,
			zIndex: getzIndex(),
			width:922,
			height:500,
			title:'菜肴',
			opacity : 0.3,
			cache:false,
			okVal: '确认',
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
		    	var saveState = iframe.saveTask();
		    	
		    	var isTF = false;
		    	$(th).parents("table").find('.dishesId').each(function(i,n){
					//alert($(n).val() + "==" + $(".specificationsId"+i).val());
					
		    		if($(n).val() == saveState[0] && $(".specificationsId"+i).val() == saveState[2]){
		    			isTF = true;
		    		}
		    	});
		    	
		    	if(isTF){
		    		alertTip("列表中已存在 "+saveState[1] +" "+ saveState[3] + "规格  的菜肴","提示");
		    		return true;
		    	}
		    	
		    	$(th).val(saveState[1]);
		    	$(th).next().val(saveState[0]);
		    	$(".specificationsId"+index).val(saveState[2]);
		    	$(".specificationsName"+index).val(saveState[3]);
		    	$(".unit"+index).val(saveState[4]);
		    	
		    	
		    	//$(th).parents("tr").find(".sfc_del").html("删除(未保存)");
		    	
		    	/**
		    	$.post("maroMaterialClassController.do?getDishesIdSpecificaList",{dishesId:saveState[0]},function(result){
		    		var jsondata = $.parseJSON(result);
				    //console.info(jsondata.obj);
				    $(".specificationsId"+index).empty();
				    $.each(jsondata.obj, function(i){
				    	
				    		//这里放的id行记录的 规格id(就是菜肴的规格id)  不是规格字段的code
				    	
				    	$(".specificationsId"+index).append("<option value='"+this.id+"'>"+this.pageName+"</option>");
				    });
				});
		    	*/
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
		
	}