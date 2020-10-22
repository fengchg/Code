	$(document).ready(function(){
		
	});
	
	/**打开原料查找页面
	* th 当前
	* subscript 下标
	*/
	function openMaterialselect(th,subscript){
		//createwindow('原料列表', 'maroDishesController.do?materialSelect',$(document).width()-100,$(document).height());
		
		$.dialog({
			content: 'url:maroDishesController.do?materialSelect',
			lock : true,
			zIndex: getzIndex(),
			width:1100,
			height:550,
			title:'原料列表',
			opacity : 0.3,
			cache:false,
			okVal: '确认',
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
		    	var saveState = iframe.saveTask();
		    	
		    	$("#open").find(".navBox").each(function(i,n){
	    				
	    				//规格名称
	    				var obtain = $(n).find(".obtain").html();
	    				//规格id
						//var specificationsId = $(n).find(".specificationsId").val();
	    				var isTF = false;
	    				
	    				//每个规格下的 原料id
	    				$(n).find(".materialclassId").each(function(j,m){
				    		var cId = $(m).val();
				    		if(cId == saveState[0]){
				    			isTF = true;
				    		}
				    	});
				    	
				    	
				    	if(isTF){
			    			alertTip(obtain + " 列表中已存在  " +saveState[1],"提示");
			    		}else{
			    			//原料名称
							$(n).find("#materialclassName"+subscript).val(saveState[1]);
							//原料id
							$(n).find("#materialclassId"+subscript).val(saveState[0]);
							//原料单位
							$(n).find("#unit"+subscript).val(saveState[2]);
			    		}
	    				
				});
		    	
		    	/*
				var isTF = false;
		    	$(th).parents("table").find('.materialclassId').each(function(i,n){

		    		if($(n).val() == saveState[0]){
		    			isTF = true;
		    		}
		    		
		    	});
		    	
		    	if(isTF){
		    		alertTip("列表中已存在 "+saveState[1],"提示");
		    	}else{
			    	$(th).val(saveState[1]);
	    			$(th).next().val(saveState[0]);
	    			$(th).parents("tr").find(".sfc_del").html("删除(未保存)");
	    			$(th).parents("tr").find('.unit').val(saveState[2]);

    			}*/
    			
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
  	
  	//保存规格成份 formobj
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
  	
  	//添加成分
  	function addTr(id){
  		 /* var tr =  $("#add_maroDishesSpecifications_table_template tr").clone();
  		 $("#add_maroDishesSpecifications_table"+id).append(tr);
  		resetTrNum("add_maroDishesSpecifications_table"+id);
  		 var gg = $("#foodCostsTable"+id).outerHeight();
 	    $(".secondary"+id).css("height",gg+"px"); */
	    

	    $("#open").find(".navBox").find(".specificationsId").each(function(i,n){
			var specificationsId = $(n).val();
			//console.info(specificationsId);
			
			var tr =  $("#add_maroDishesSpecifications_table_template tr").clone();
  		 	$("#add_maroDishesSpecifications_table"+specificationsId).append(tr);
  			resetTrNum("add_maroDishesSpecifications_table"+specificationsId);
  			var gg = $("#foodCostsTable"+specificationsId).outerHeight();
 	    	$(".secondary"+specificationsId).css("height",gg+"px");
		    		
		    		
		});

  	}
  	
    //删除成分 undefined
	function delTr(t,id){
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
					doSubmit('maroSpecificationsFoodCostsController.do?doDel&id='+id,'name');
					rowid = '';
				}else{
					layer.close(index);
				}
			},
			btn:['确定','取消'],
			btn2:function(index){
				layer.close(index);
			}
		});
    	
	}
    
	//初始化下标
	function resetTrNum(tableId) {
		$tbody = $("#"+tableId+"");
		$tbody.find('>tr').each(function(i){
			$(':input, select,button,a', this).each(function(){
				var $this = $(this), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val();
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
						//var s = id.indexOf("[");
						//var e = id.indexOf("]");
						//var new_id = id.substring(s+1,e);
						//$this.attr("id",id.replace(new_id,i));
					}
				}
				if(onclick_str!=null){
					if (onclick_str.indexOf("#index#") >= 0){
						$this.attr("onclick",onclick_str.replace(/#index#/g,i));
					}else{
					}
				}
			});
			$(this).find('div[name=\'xh\']').html(i+1);
		});
	}
	
	function jeecgFormFileCallBack(data){
			if (data.success == true) {
			uploadFile(data);
		} else {
			if (data.responseText == '' || data.responseText == undefined) {
				$.messager.alert('错误', data.msg);
				$.Hidemsg();
			} else {
				try {
					var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
					$.messager.alert('错误', emsg);
					$.Hidemsg();
				} catch(ex) {
					$.messager.alert('错误', data.responseText + '');
				}
			}
			return false;
		}
		if (!neibuClickFlag) {
			var win = frameElement.api.opener;
			win.reloadTable();
		}
		}
		function upload() {
			$('#picture').uploadify('upload', '*');
	}
	
	var neibuClickFlag = false;
	function neibuClick() {
		neibuClickFlag = true; 
		$('#btn_sub').trigger('click');
	}
	function cancel() {
			$('#picture').uploadify('cancel', '*');
	}
	function uploadFile(data){
		if(!$("input[name='id']").val()){
			if(data.obj!=null && data.obj!='undefined'){
				$("input[name='id']").val(data.obj.id);
			}
		}
		if($(".uploadify-queue-item").length>0){
			upload();
		}else{
			if (neibuClickFlag){
				alert(data.msg);
				neibuClickFlag = false;
			}else {
				var win = frameElement.api.opener;
				win.reloadTable();
				win.tip(data.msg);
				frameElement.api.close();
			}
		}
	}