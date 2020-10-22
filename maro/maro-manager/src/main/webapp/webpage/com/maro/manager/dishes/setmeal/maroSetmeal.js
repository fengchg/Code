
function delDishes(tableId,dishesId){
	//$("#add_maroDishesSpecifications_table"+tableId).find(".del_dishes_"+dishesId).html("删除(未保存)");
}


//根据文本框输入的汉字自动获取汉字拼音首字母到下拉列表中，支持多音字，需引入库pinying.js
function query(num,dishesName){
	var str = "";
	if(num == 0){
    	str = document.getElementById("dishesName").value.trim();
    }else{
    	str = dishesName;
    }
    if(str == "") return;
    var arrRslt = makePy(str);
    //循环将值到下拉框
    var option = null;
    document.getElementById("pinyinCode").innerHTML="";//清空下拉框
    var first = document.getElementById("pinyinCode");
    for(var j=0;j<arrRslt.length;j++){
				var obj = document.getElementById("pinyinCode");
				obj.add(new Option(arrRslt[j],arrRslt[j]));
    }
}

	//添加成分
  	function addSelectTr(th,id){
	   
	   //给每一个类添加一行
	    /*$("#open").find(".navBox").find(".specificationsId").each(function(i,n){
			var specificationsId = $(n).val();
			//console.info(specificationsId);
			
			var tr =  $("#add_maroDishesSpecifications_table_template tr").clone();
  		 	$("#add_maroDishesSpecifications_table"+specificationsId).append(tr);
  			resetTrNum("add_maroDishesSpecifications_table"+specificationsId);
  			var gg = $("#foodCostsTable"+specificationsId).outerHeight();
 	    	$(".secondary"+specificationsId).css("height",gg+"px");			
		});*/
		
		var specificationsId = $(th).parents(".navBox").find(".specificationsId").val();
		
		var tr =  $("#add_maroDishesSpecifications_table_template tr").clone();
  		$("#add_maroDishesSpecifications_table"+specificationsId).append(tr);
  		resetTrNum("add_maroDishesSpecifications_table"+specificationsId,id);
  		var gg = $("#foodCostsTable"+specificationsId).outerHeight();
 	    $(".secondary"+specificationsId).css("height",gg+"px");	

		
		var beginNum= $("#add_maroDishesSpecifications_table"+specificationsId).find("tr").length;
		$(".beginNum"+specificationsId).val(beginNum);

  	}

    //删除成分 
	function delSelectTr(t,id){
		var specificationsId = $(t).parents(".navBox").find(".specificationsId").val();
		layer.open({
			title:"确认删除",
			content:"确认删除",
			icon:7,
			shade: true?0.3:0,
			yes:function(index){
				
				var gg = $(t).parent().parent().outerHeight();
				var p = $(t).parents('.secondary').outerHeight();
				$(t).parents('.secondary').css("height",(p - gg)+"px");
				$(t).parent().parent().remove();
				
				if(id!='undefined' && id!=null && id!=''){
					doSubmit('maroSetmealController.do?doDelSetmealDishesSelect&selectId='+id,'name');
					rowid = '';
				}else{
					layer.close(index);
				}
				
				var beginNum= $("#add_maroDishesSpecifications_table"+specificationsId).find("tr").length;
				$(".beginNum"+specificationsId).val(beginNum);
			},
			btn:['确定','取消'],
			btn2:function(index){
				layer.close(index);
			}
		});
    	
	}

    //打开菜肴查找页面
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

		    	//console.log(saveState);
		    	/* var isTF = false;
		    	$(th).parents("table").find('.dishesId').each(function(i,n){
					//alert($(n).val() + "==" + $(".specificationsId"+i).val());
					
		    		if($(n).val() == saveState[0] && $(".specificationsId"+i).val() == saveState[2]){
		    			isTF = true;
		    		}
		    	});
		    	
		    	if(isTF){
		    		alertTip("列表中已存在 "+saveState[1] +" "+ saveState[3] + "规格  的菜肴","提示");
		    		return true;
		    	} */
		    	
		    	$(th).val(saveState[1]); //菜肴名称
				$(th).parent().siblings().find(".specificationsName"+index).val(saveState[3]); //菜肴规格名称
				$(th).parent().siblings().find(".specificationsId"+index).val(saveState[2]);   //菜肴规格id
				$(th).parent().siblings().find(".unit"+index).val(saveState[4]); //菜肴单位
				
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
		
	}
	
	
		//点击h2的时候获取高度
	function obtf(id){
		var secondary = $(".secondary"+id).outerHeight();
		
		$(".shouqi_zhangkai_"+id).html("");
		if(secondary!=0){
			$(".secondary"+id).css("height","0px");
			$(".shouqi_zhangkai_"+id).html("展开");
		}else{
			var table = $("#foodCostsTable"+id).outerHeight();
			$(".secondary"+id).css("height",table+"px");
			$(".shouqi_zhangkai_"+id).html("收起");
		}
		
	}
	
	  	//保存 formobj
  	function submitForm(id){
  	
	  	$.dialog.confirm("是否提交表单", function(r){
			//循环判断 input 是否都有输入值
			var tf = false;
			$("#foodCostsTable"+id).find("input").each(function(i, n){
				var str = $(n).val();
				if(str == "" || $.trim(str).length == 0){
					tf = true;
				}
			});
			
			if(tf){
				$("#formobj"+id).submit();
			}else{
				$("#formobj"+id).submit();
				$("#foodCostsTable"+id).find(".sfc_del").each(function(i, n){
			  		$(n).html('删除');
			  	});
		  		alertTip("操作成功","提示");
			}
		}, function(){
			
		});
  	
  	}
  	
  	
  	//
  	function ifSize(th,id){
  		var beginNum = $(".beginNum"+id).val();
  		var selectNum = $(".selectNum"+id).val();
  		
  		console.info(beginNum);
  		console.info(selectNum);
  		
  		if(parseInt(selectNum) > parseInt(beginNum)){ 
  			alertTip("选菜必须要小于或等于菜的数量","提示");
  			$(".selectNum"+id).val(1);
  		}

  	}



//初始化下标
function resetTrNum(tableId,dsId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val(),clas = $this.attr('class'),onblur_str=$this.attr('onblur');
			if(name!=null){
				if (name.indexOf("#index#") >= 0){
					$this.attr("name",name.replace('#index#',i));
				}else{
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s+1,e);
					$this.attr("name",name.replace(new_name,i));
				}
			}
			if(id!=null){
				if (id.indexOf("#index#") >= 0){
					$this.attr("id",id.replace('#index#',i));
				}else{
					var s = id.indexOf("[");
					var e = id.indexOf("]");
					var new_id = id.substring(s+1,e);
					$this.attr("id",id.replace(new_id,i));
				}
			}
			if(clas!=null){
				if (clas.indexOf("#index#") >= 0){
					$this.attr("class",clas.replace('#index#',i));
				}else{
					//var s = clas.indexOf("[");
					//var e = clas.indexOf("]");
					//var new_clas = clas.substring(s+1,e);
					//$this.attr("class",clas.replace(new_clas,i));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
				}
			}
			if(onblur_str!=null){
				if (onblur_str.indexOf("#index#") >= 0){
					$this.attr("onblur",onblur_str.replace(/#index#/g,"'"+dsId+"',"+i));
				}
			}
		});
		$(this).find('div[name=\'xh\']').html(i+1);
	});
}
//通用弹出式文件上传
function commonUpload(callback,inputId){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:getzIndex(),
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
       ok: function(){
               var iframe = this.iframe.contentWindow;
               iframe.uploadCallback(callback,inputId);
               return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
}
//通用弹出式文件上传-回调
function commonUploadDefaultCallBack(url,name,inputId){
	$("#"+inputId+"_href").attr('href',url).html('下载');
	$("#"+inputId).val(url);
}
function browseImages(inputId, Img) {// 图片管理器，可多个上传共用
}
function browseFiles(inputId, file) {// 文件管理器，可多个上传共用
}
function decode(value, id) {//value传入值,id接受值
	var last = value.lastIndexOf("/");
	var filename = value.substring(last + 1, value.length);
	$("#" + id).text(decodeURIComponent(filename));
}