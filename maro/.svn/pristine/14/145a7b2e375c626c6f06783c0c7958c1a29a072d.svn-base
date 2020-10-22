
function examinePrinterIp(th,au){
	var ip = $(th).val().trim();
	
	if(au == 'update'){
		var c1 = $(th).val();
		var c2 = $("#printerIp2").val();
		if(c1 == c2){
			return ;
		}
	}
	
	if(ip!=""){
		$.post("maroPrinterController.do?examinePrinterIp",{ip:ip},function(result){
    		var jsondata = $.parseJSON(result);
    		if(jsondata.obj >= 1){
    			alertTip("IP地址 " + ip + " 已存在,请重新输入");
    			$(th).val("");
    		}
		});
	}
}

//验证菜肴分类是否有重复 //alertTip("列表中已存在 " + $(t).text() +" 的规格","提示");
function onClicksCode(t){
	
	//获取有多少表规格选择框
	var l = $("#maroPrinterClassification_table").find(".specificationsName").length;
	//当前选择框的值
	var th = $(t).val();
	var thv = $(t).find("option:selected").text();
	//console.info("当前选择的 th=="+th+",thv=="+thv);
	//console.info("");
	var num = 0;
	//获取规格名称
 	$(".specificationsName").find("#specificationsName").each(function(i,n){
 		
 		if(l != 1){
			var si = $(n).val();
			var sn = $(n).find("option:selected").text();
			//console.info("循环里的== i=="+i+",si=="+si+",sn=="+sn);
			if(th == si){
				num++;
			}
		}
		
    });
    
    if(num==2){
    	$(t).prop('selectedIndex', 0);
    	if(thv != "-- 请选择 --"){
    		alertTip("列表中已存在 " + thv +" 的分类","提示");
    		return;
    	}
    }

    //判断数据里
	$.post("maroPrinterController.do?examineClassification",{classificationId:th},function(result){
		var jsondata = $.parseJSON(result);
		//console.info(jsondata.obj);
		//console.info("===================");
		//console.info(jsondata.obj.printer_name);
		if(jsondata.obj != null){
			$(t).prop('selectedIndex', 0);
			var data = jsondata.obj.printer_name;
			alertTip(thv +" 分类 " + " 已在 "+data+" 打印机上添加","提示");
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
//通用弹出式文件上传
function commonUpload(callback,inputId){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:2100,
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