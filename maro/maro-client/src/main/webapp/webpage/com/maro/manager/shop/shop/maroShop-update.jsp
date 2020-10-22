<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>店铺表</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
		<script src = "webpage/com/maro/manager/common/js/common.js"></script>	
  <script type="text/javascript">
  var num=0,departName;
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
  //检查重复
  function checkShopNumberRepeat(obj){
  		var number=$(obj).val();
  		var oldnumber=$(obj).attr("oldValue");
  		if(number!=oldnumber){
            if(number=="") return;
            $.ajax({
                url:"maroShopController.do?checkShopNumberRepeat",
                data:{
                    number:number
                },
                dataType:"json",
                success:function(result){
                    if(!result.success){
                        alertTip("该编号已存在","提示");
                        $(obj).val("");
                    }
                }
            });
        }
  }
  //检查座位编号重复
  function checkSeatFlagRepeat(obj){
      var num=0;
      var number=$(obj).val();//座位号
      $("#add_maroShopSeat_table input[flag='flag']").each(function(index,element){
          var tmp=$(this).val();
          if(tmp==number){
              num++;
          }
      });
      if(num==2){
          alertTip("该编号已存在","提示");
          $(obj).val("");
      }
  }
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroShopController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${maroShopPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">所属组织机构:</label>
			</td>
			<td class="value">
		     	<input name="oldDepartId" type="hidden" value='${maroShopPage.departId}'/>
				<select id="departId" name="departId" class="easyui-combotree" style="width:158px;" data-options="url:'maroShopController.do?departTree',required:true,onLoadSuccess:function(){
					//根据部门id获取部门名称
					if(num==0){
						num++;
						$.ajax({
							url:'utilController.do?getDepartNameByDepartId',
							data:{
								departId:'${maroShopPage.departId}'
							},
							dataType:'json',
							success:function(result){
								departName=result;
								$('#departId').combotree('setValue', '${maroShopPage.departId}');
								$('#departId').combotree('setText', departName);
							}
						});
					}
					$('#departId').combotree('setText', departName);
				}"></select>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属组织机构</label>
			</td>
			<td align="right">
				<label class="Validform_label">店铺编号:</label>
			</td>
			<td class="value">
		     	 <input id="number" name="number" type="text" style="width: 150px" onblur="checkShopNumberRepeat(this)" class="inputxt" datatype="*" ignore="checked" oldValue="${maroShopPage.number}"  value='${maroShopPage.number}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">店铺类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="type" type="list"  datatype="n"   typeGroupCode="maro_shop_type"  defaultVal="${maroShopPage.type}" hasLabel="false"  title="店铺类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">店铺所属地区:</label>
			</td>
			<td class="value">
				<t:dictSelect field="area" type="list"  typeGroupCode="maro_area"  defaultVal="${maroShopPage.area}" hasLabel="false"  title="店铺所属地区" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺所属地区</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">店铺名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt" datatype="*" ignore="checked"  value='${maroShopPage.name}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">店铺位置:</label>
			</td>
			<td class="value">
		     	 <input id="position" name="position" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroShopPage.position}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺位置</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">店铺经度:</label>
			</td>
			<td class="value">
		     	 <input id="la" name="la" type="text" style="width: 150px" class="inputxt"  datatype="/^\d+(\.\d+)?$/" ignore="ignore"  value='${maroShopPage.la}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺经度</label>
			</td>
			<td align="right">
				<label class="Validform_label">店铺维度:</label>
			</td>
			<td class="value">
		     	 <input id="lo" name="lo" type="text" style="width: 150px" class="inputxt"  datatype="/^\d+(\.\d+)?$/" ignore="ignore"  value='${maroShopPage.lo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺维度</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">店铺电话:</label>
			</td>
			<td class="value">
		     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  datatype="/^[0-9]*$/" ignore="ignore"  value='${maroShopPage.phone}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">店铺邮箱:</label>
			</td>
			<td class="value">
		     	 <input id="mail" name="mail" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroShopPage.mail}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺邮箱</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">开业时间:</label>
			</td>
			<td class="value">
				<input id="openTime" name="openTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${maroShopPage.openTime}" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开业时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">营业时间:</label>
			</td>
			<td class="value">
				<input id="workTime" name="workTime" type="text" style="width: 150px"  value="${maroShopPage.workTime}" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">营业时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">店铺图片:</label>
			</td>
			<td class="value">
				<jsp:include page= "/webpage/com/maro/manager/common/jsp/upload.jsp">
					<jsp:param name= "name" value= "picture"/>
					<jsp:param name= "value" value= "${maroShopPage.picture}"/>
					<jsp:param name= "multiple" value= ""/>
				</jsp:include> 
				
			</td>
			<td align="right">
				<label class="Validform_label">营业执照等:</label>
			</td>
			<td class="value">
				<jsp:include page= "/webpage/com/maro/manager/common/jsp/upload.jsp">
					<jsp:param name= "name" value= "shopInfo"/>
					<jsp:param name= "value" value= "${maroShopPage.shopInfo}"/>
					<jsp:param name= "multiple" value= "multiple"/>
				</jsp:include> 
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">人均消费:</label>
			</td>
			<td class="value">
		     	 <input id="perConsume" name="perConsume" type="text" style="width: 150px" class="inputxt"  datatype="/^\d+(\.\d+)?$/" ignore="ignore"  value='${maroShopPage.perConsume}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">人均消费</label>
			</td>
			<td align="right">
				<label class="Validform_label">关联设备编号:</label>
			</td>
			<td class="value">
				<input id="equipmentNumber" name="equipmentNumber" type="text" style="width: 150px" class="inputxt"  datatype="*" ignore="ignore"  value='${maroShopPage.equipmentNumber}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">关联设备编号</label>
			</td>
		</tr>
			<td align="right">
				<label class="Validform_label">店铺介绍:</label>
			</td>
			<td class="value">
				<textarea id="introduce" style="width:150px;" class="inputxt" rows="6" name="introduce"  ignore="ignore" >${maroShopPage.introduce}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺介绍</label>
			</td>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroShopController.do?maroShopSeatList&id=${maroShopPage.id}" icon="icon-search" title="座位信息" id="maroShopSeat"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_maroShopSeat_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <!-- <td align="left">
					  		<input name="maroShopSeatList[#index#].shopId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">主键id</label>
				  </td> -->
				  <td align="left">
					  		<input name="maroShopSeatList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"   datatype="/^.{1,10}$/" ignore="checked" />
					  <label class="Validform_label" style="display: none;">座位名称</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="maroShopSeatList[#index#].type" type="list"  datatype="n"   typeGroupCode="maro_seat_type"  defaultVal="" hasLabel="false"  title="座位类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">座位类型</label>
				  </td>
				  <td align="left">
					  		<input name="maroShopSeatList[#index#].flag" flag="flag" onblur="checkSeatFlagRepeat(this)"  maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="/^[0-9]{1,4}$/" ignore="checked" />
					  <label class="Validform_label" style="display: none;">座位号</label>
				  </td>
				  <td align="left">
					  		<input name="maroShopSeatList[#index#].number" maxlength="2" type="text" class="inputxt"  style="width:120px;"  datatype="/^[0-9]*$/" ignore="checked" />
					  <label class="Validform_label" style="display: none;">座位标准人数</label>
				  </td>
				  <td align="left" style="display:none">
					  		<input name="maroShopSeatList[#index#].lateOperatinId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">最近流水id</label>
				  </td>
				 <!--  <td align="left">
					  		<input name="maroShopSeatList[#index#].deleteFlag" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">删除标志</label>
				  </td> -->
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/maro/manager/shop/shop/maroShop.js"></script>	
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	/*$(function(){
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "maroShopController.do?getFiles&id=" +  cgFormId,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  			$.each(arrayFileObj,function(n,file){
	  				var fieldName = file.field.toLowerCase();
	  				var table = $("#"+fieldName+"_fileTable");
	  				var tr = $("<tr style=\"height:34px;\"></tr>");
	  				var title = file.title;
	  				if(title.length > 15){
	  					title = title.substring(0,12) + "...";
	  				}
	  				var td_title = $("<td>" + title + "</td>");
	  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
	  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
	  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
	  		  		tr.appendTo(table);
	  		  		td_title.appendTo(tr);
	  		  		td_download.appendTo(tr);
	  		  		td_view.appendTo(tr);
	  		  		td_del.appendTo(tr);
	  			 });
	  		   }
	  		});
	  	})*/
	  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
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
					$('#shopInfo').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
					$('#picture').uploadify('cancel', '*');
					$('#shopInfo').uploadify('cancel', '*');
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
  	</script>
