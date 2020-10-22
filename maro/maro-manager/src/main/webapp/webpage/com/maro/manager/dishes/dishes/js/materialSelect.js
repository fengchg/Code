
    //选择
    function saveTask(){
    			
		var v = $("input[type='checkbox']:checked");
			
		//var w = $(v).parents("td").prev().find(".datagrid-cell-rownumber").html();
		var w = $(v).parents("tr").attr("datagrid-row-index");

		var id = $(".datagrid-view2").find("tr[datagrid-row-index='"+(w)+"']").find("td[field='id']").find("div").html();
		//原料名称
		var materialName = $(".datagrid-view2").find("tr[datagrid-row-index='"+(w)+"']").find("td[field='materialName']").find("div").html();
		//单位
		var denominatedUnit = $(".datagrid-view2").find("tr[datagrid-row-index='"+(w)+"']").find("td[field='denominatedUnit']").find("div").html();
		
		var mycars=new Array()
		mycars[0]=id;
		mycars[1]=materialName;
		mycars[2]=denominatedUnit;

    	return mycars;
    }