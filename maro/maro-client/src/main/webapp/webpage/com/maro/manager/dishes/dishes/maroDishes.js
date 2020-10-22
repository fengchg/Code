
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


//验证规格是否有重复 //alertTip("列表中已存在 " + $(t).text() +" 的规格","提示");
function onClicksCode(t){
	
	//获取有多少表规格选择框
	var l = $("#add_maroDishesSpecifications_table").find(".specificationsName").length;
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
    		alertTip("列表中已存在 " + thv +" 的规格","提示");
    	}
    }
}

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
		$.post("maroDishesController.do?checkCoding",{coding:coding},function(result){
    		var jsondata = $.parseJSON(result);
    		if(jsondata.obj >= 1){
    			alertTip("编号 " + coding + " 已存在,请重新输入");
    			$(th).val("");
    		}
		});
	}
}

//会员折扣方式
function memberDiscountWay(num){
	var checkText=$("#memberDiscount"+num).find("option:selected").val();
  	
  	//2为另设会员价
  	if(checkText == 2){
  		$("#discountWay"+num).attr("readonly",false);
  		$("#discountWay"+num).attr("datatype","d");
  	}else{
  		$("#discountWay"+num).val("");
  		$("#discountWay"+num).attr("readonly",true);
  		
  		$("#discountWay"+num).removeAttr("datatype");
  	}
}

/*
function changeType(){
  	var checkText=$("#material_type").find("option:selected").val();
  	defaultType(checkText);
  }

function defaultType(num){
	//原料类型是拆零时
  	$("#scatteredSpan").empty();
  	if(num == 0){
  		var scatteredCode = $("#scatteredCode").clone();
  		$("#scatteredSpan").append(scatteredCode);
  	}
}
*/

//选择门店
function onRadio(num){
  	  $("#sysCompanyCode_copy").empty();
  	  var tr = "";
      if(num == 0){
    	tr = "<input id=\"sysCompanyCode\" name=\"sysCompanyCode\" type=\"hidden\" value=\"0\"/>";
      }else if(num == 1){
      	tr =  $("#sysCompanyCode").clone();
      }
	  $("#sysCompanyCode_copy").append(tr);
	  
	  
  }

//初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'),onChange_str=$this.attr('onchange'), val = $this.val(),clas = $this.attr('class');
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
			if(val!=null){
				if (val.indexOf("#index#") >= 0){
					$this.attr("value",val.replace('#index#',i));
				}else{
					//var s = clas.indexOf("[");
					//var e = clas.indexOf("]");
					//var new_clas = val.substring(s+1,e);
					//$this.attr("value",val.replace(new_clas,i));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
				}
			}
			if(onChange_str!=null){
				if (onChange_str.indexOf("#index#") >= 0){
					$this.attr("onchange",onChange_str.replace(/#index#/g,i));
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