<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>" />
		<link rel="stylesheet" type="text/css" href="css/css_default/style.css" />
    	<link href="css/css_default/layout.css" rel="stylesheet" type="text/css" />
   		<link href="css/css_default/foot.css" rel="stylesheet" type="text/css" />
		<link href="css/css_default/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript">
			var isUserNameNotSome = true;
			function checkUserName(input){
				if(input.value != null && input.value != ""){
					$.post("userAction!checkUserName.action",{userName:input.value}, function(data){
						if(data == "true"){
							var div = $("#userNameTip");
							div.text("用户名已经存在");
							isUserNameNotSome = false;
						}else{
							var div = $("#userNameTip");
							div.text("");
							isUserNameNotSome = true;
						}
					});
				}
			}
			function registerSubmit(){
				var input = $("input[name='user.userName']");
				if(!isUserNameNotSome){
					alert("用户名已经存在");
					return;
				}
				if(input.val() == ""){
					alert("用户名不能为空");
					return;
				}
				input = $("input[name='user.password']");
				if(input.val() == ""){
					alert("密码不能为空");
					return;
				}
				if($("input[name='user.password']").val() != $("input[name='repassword']").val()){
					alert("两次输入的密码不相同");
					return;
				}

				input = $("input[name='user.userExp.realName']");
				if(input.val() == ""){
					alert("真实姓名不能为空");
					return;
				}

				input = $("input[name='user.userExp.gender']");
				isChecked = false;
				for(i=0;i<input.length;i++){
					if(input[i].checked){
						isChecked = true;
						break;
					}
				}
				if(!isChecked){
					alert("请选择性别");
					return;
				}

				input = $("select[name='user.userExp.age']");
				if(input.val() == ""){
					alert("请选择年龄");
					return;
				}

				input = $("input[name='user.userExp.code']");
				if(input.val() == ""){
					alert("身份证号码不能为空");
					return;
				}

				input = $("input[name='user.userExp.address']");
				if(input.val() == ""){
					alert("家庭地址不能为空");
					return;
				}

				input = $("input[name='user.userExp.phoneNumber']");
				if(input.val() == ""){
					alert("电话号码不能为空");
					return;
				}
				document.form.submit();
			}
		</script>
	</head>
	<body>
		<div class="TopHead"></div>
		<center>
		<form name="form" id="personalForm" theme="simple" action="userAction!register.action" method="post">
			<div class="consoleLabel">用户注册</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						【用户注册】
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								用户名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userName" onblur="checkUserName(this)" />
								<span id="userNameTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="用户名不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								密码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.password" type="password"/>
								<span id="passwordTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="密码不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								确认密码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="repassword" type="password"/>
								<span id="repasswordTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="两次输入密码不一致" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								真实姓名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.realName"/>
								<span id="userNamerealNameTipTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="真实姓名不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								性别：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.gender" type="radio" value="男" />男
								<input name="user.userExp.gender" type="radio" value="女" />女
								<span id="genderTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="请选择性别" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								年龄：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<select name="user.userExp.age">
									<option value="">--请选择--</option>
									<c:forEach begin="10" end="99" step="1" varStatus="s">
										<option value="${s.index}">${s.index}</option>
									</c:forEach>
								</select>
								<span id="ageTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="年龄不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								身份证号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.code" />
								<span id="codeTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="身份证号码不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								家庭住址：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.address" />
								<span id="addressTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="家庭不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								电话号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.phoneNumber" />
								<span id="phoneTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="电话号码不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								邮箱：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.email" />
								<span id="emailTip" style="color:red;font-size: 12px;margin-left: 20px" tipStr="邮箱不能为空" ></span>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								个人备注：
							</td>
							<td class='list' colspan=3 rowspan=2>
								<textarea cols="80" rows="5" name="user.userExp.remark"></textarea>
							</td>
						</tr>
					</table>
				</FIELDSET>
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<div class="footer">
						<ul class="footer_1">
							<li>
								<a href="javascript:registerSubmit()">保 存 </a>
							</li>
							<li>
								<a href="javascript:history.back()">返回</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>