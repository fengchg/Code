

//通用弹出式文件上传
function commonUpload(callback){
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
               iframe.uploadCallback(callback);
                   return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
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


//编码失去焦点时
function checkCoding(th,au){
	
	if(au == 'update'){
		var c1 = $(th).val();
		var c2 = $("#classificationCode2").val();
		if(c1 == c2){
			return ;
		}
	}

	var coding = $(th).val();
	if(coding!=""){
		$.post("maroDishesClassificationController.do?checkCoding",{coding:coding},function(result){
    		var jsondata = $.parseJSON(result);
    		if(jsondata.obj >= 1){
    			//alertTip("编号 " + coding + " 已存在,请重新输入");
    			$(th).val("");
    			
    			$(th).addClass("Validform_error");
    			$(".classificationCode_show").addClass("Validform_wrong");
    			$(".classificationCode_show").html("编号 " + coding + " 已存在,请重新输入");
    			
    		}
		});
	}
}