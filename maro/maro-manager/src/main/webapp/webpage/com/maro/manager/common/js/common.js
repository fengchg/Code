/**
 * 右下角展示消息
 */
/*function showMeg(msg) {
	$.messager.show({
		title : '提示',
		msg : msg,
	});
}*/

function showMeg(msg) {
	layer.open({
		title:'提示信息',
		offset:'rb',
		content:msg,
		time:3000,
		btn:false,
		shade:false,
		icon:1,
		shift:2
	});
}
//文件上传进度回调方法
function onprogress(){
}
//单文件上传
function myupload(obj){
	var _this=$(obj).parent();
	var formData = new FormData();
	var files = $(obj)[0].files;
	var uploadPath=$(_this).find("input[type='hidden']").val();
	for(var i=0; i< files.length; i++){  
		//文件对象    
		formData.append("files",files[i]);
    }
	formData.append("uploadPath", uploadPath);
	$.ajax({
		url: "utilController.do?upload", 
		type: "POST",
		contentType: 'multipart/form-data',
		data: formData,
		async: true,
		cache: false,
		dataType:"json",
		processData: false, //告诉jQuery不要去设置Content-Type请求头
		contentType: false, //告诉jQuery不要去处理发送的数据
		//这里我们先拿到jQuery产生的 XMLHttpRequest对象，为其增加 progress 事件绑定，然后再返回交给ajax使用
		xhr: function(){
			var xhr = $.ajaxSettings.xhr();
			if(onprogress && xhr.upload) {
				xhr.upload.addEventListener("progress" , function(evt){
					var loaded = evt.loaded;     //已经上传大小情况 
					var tot = evt.total;      //附件总大小 
					var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
					$(_this).find("div").css("width" , 1.58*per +"px");
				}, false);
				return xhr;
			}
		},
		success: function(data) {
			if(data.success){
				$(_this).find("input[class='inputxt']").val(data.obj);
			}else{
				showMeg(data.msg);
			}
		}
	});
}
//删除文件
function myremove(obj){
	var _this=$(obj).parent();
	var filePath=$(_this).find("input[class='inputxt']").val();
	$.ajax({
		url:"utilController.do?remove",
		data:{
			filePath:filePath
		},
		dataType:"json",
		success:function(result){
			if(result.success){
				$(_this).find("input[class='inputxt']").val('');
				$(_this).find("div").css("width" , "0px");
				showMeg(result.msg);
			}else{
				showMeg(result.msg);
			}
		}
	});
}
//多文件上传
function myuploadmulti(obj,single){
	var _this=$(obj).parent();
	var files = $(obj)[0].files;
	for(var i=0; i< files.length; i++){ 
		(function (file) {
			var dom=$(
					"<div style=\"float: left;padding-right: 8px\">"+
						"<div class=\"image\" style=\"background-size:100% 100%;width:60px;height:60px\">"+
							"<div style=\"float: right\">"+
								"<span style=\"font-size: 20px;background-color: #919A9E;cursor: pointer;\" onclick=\"myremovemulti(this,"+single+")\">&nbsp;×&nbsp;</span>"+
							"</div>"+
						"</div>"+
						"<div class=\"progress\" style=\"background-color:red;height:2px;width:0px\"></div>"+
					"</div>"
			);
			$(_this).prev().append(dom);
			//保存位置
			var uploadPath=$(_this).find("input[type='hidden']").val();
			//文件form对象
			var formData = new FormData();
			//文件对象    
			formData.append("files",file);
			formData.append("uploadPath", uploadPath);
			$.ajax({
				url: "utilController.do?upload", 
				type: "POST",
				contentType: 'multipart/form-data',
				data: formData,
				async: true,
				cache: false,
				dataType:"json",
				processData: false, //告诉jQuery不要去设置Content-Type请求头
				contentType: false, //告诉jQuery不要去处理发送的数据
				//这里我们先拿到jQuery产生的 XMLHttpRequest对象，为其增加 progress 事件绑定，然后再返回交给ajax使用
				xhr: function(){
					var xhr = $.ajaxSettings.xhr();
					if(onprogress && xhr.upload) {
						xhr.upload.addEventListener("progress" , function(evt){
							var loaded = evt.loaded;     //已经上传大小情况 
							var tot = evt.total;      //附件总大小 
							var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
							$(dom).find(".progress").css("width" , 0.6*per +"px");
						}, false);
						return xhr;
					}
				},
				success: function(data) {
					if(data.success){
						$(dom).find(".image").css("background-image","url('"+data.obj+"')");
						$(dom).find(".image").attr("imagePath",data.obj);
						var path=$(_this).prev().prev().val();
						if(path!=""){
							$(_this).prev().prev().val(path+";"+data.obj);
						}else{
							$(_this).prev().prev().val(data.obj);
						}
						if(single==true){//如果为单文件上传，则上传成功后隐藏上传控件
							$(obj).next().linkbutton("disable");
						}
					}else{
						showMeg(data.msg);
					}
				}
			});
		})(files[i]);
    }
}
//多文件删除
function myremovemulti(obj,single){
	var newValue="";
	var _this=$(obj).parent().parent();
	var filePath=$(_this).attr("imagePath");
	var oldvalue=$(_this).parent().parent().prev().val();
	var arrayValue=oldvalue.split(";");
	for(var i=0;i<arrayValue.length;i++){
		if(arrayValue[i].indexOf(filePath)==-1){
			newValue+=arrayValue[i]+";";
		}
	}
	newValue=newValue.substring(0, newValue.length-1);
	$.ajax({
		url:"utilController.do?remove",
		data:{
			filePath:filePath
		},
		dataType:"json",
		success:function(result){
			if(result.success){
				showMeg(result.msg);
				if(single==true){//如果为单文件上传，则删除成功后启用上传控件
					$(_this).parent().parent().next().find(".easyui-linkbutton").linkbutton("enable");
				}
				//删除图片
				$(_this).parent().parent().prev().val(newValue);
				$(_this).parent().remove();
			}else{
				showMeg(result.msg);
			}
		}
	});
}
//通过原料id获取原料的单位类型
function getTypeByClassId(materialClassId){
	var value;
	$.ajax({
		url:'maroMaterialClassController.do?getTypeByClassId',
		data:{
			materialClassId:materialClassId
		},
		async:false,
		dataType:'json',
		success:function(result){
			if(result.success){
				value=result.obj;
			}
		}
	});
	return value;
}