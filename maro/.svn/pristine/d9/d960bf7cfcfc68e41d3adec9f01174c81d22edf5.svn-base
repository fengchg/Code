
//编码失去焦点时
function checkCoding(th,au){
	
	if(au == 'update'){
		var c1 = $(th).val();
		var c2 = $("#coding2").val();
		if(c1 == c2){
			return ;
		}
	}

	var coding = $(th).val();
	if(coding!=""){
		$.post("maroMaterialClassController.do?checkCoding",{coding:coding},function(result){
    		var jsondata = $.parseJSON(result);
    		if(jsondata.obj >= 1){
    			alertTip("编号 " + coding + " 已存在,请重新输入");
    			$(th).val("");
    		}
		});
	}
}

function changeType(th){
  	var checkText=$("#material_type").find("option:selected").val();
  	defaultType(checkText);
  }

function defaultType(num){
  	$("#scatteredSpan").empty();
  	if(num == 0){//等于拆零的时候
  		var scatteredCode = $("#scatteredCode").clone();
  		$("#scatteredSpan").append(scatteredCode);
  		
  		$(".denominatedUnitClass").empty();
  		var maro_scattered_unit = $(".maro_scattered_unit").clone();
  		$(".denominatedUnitClass").append(maro_scattered_unit);
  	}else if(num==1){//等于普通的时候
  		$(".denominatedUnitClass").empty();
  		var maro_ordinary_unit = $(".maro_ordinary_unit").clone();
  		$(".denominatedUnitClass").append(maro_ordinary_unit);
  	}else if(num==2){//等于称重的时候
  		$(".denominatedUnitClass").empty();
  		var maro_weighing_unit = $(".maro_weighing_unit").clone();
  		$(".denominatedUnitClass").append(maro_weighing_unit);
  	}
}

//初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val(),clas = $this.attr('class');
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