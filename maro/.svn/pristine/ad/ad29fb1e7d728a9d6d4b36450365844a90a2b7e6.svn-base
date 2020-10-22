<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>会员表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroMemberController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroMemberPage.id }"/>
		<table style="width: 950px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属店铺:
							</label>
						</td>
						<td class="value">
									<t:dictSelect readonly="readonly" field="shopId" type="list" datatype="*" dictTable="maro_shop" dictField="id" dictText="name" defaultVal="${maroMemberPage.shopId}" hasLabel="false"  title="所属门店"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属店铺</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								会员姓名:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员性别:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="sex" type="list"  typeGroupCode="sex"  defaultVal="${maroMemberPage.sex}" hasLabel="false"  title="会员性别" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								会员年纪:
							</label>
						</td>
						<td class="value">
						    <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroMemberPage.age}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员年纪</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员电话:
							</label>
						</td>
						<td class="value">
						    <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.phone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								微信号:
							</label>
						</td>
						<td class="value">
						    <input id="weixin" name="weixin" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.weixin}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								QQ号:
							</label>
						</td>
						<td class="value">
						    <input id="qq" name="qq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.qq}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">QQ号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								入会日期:
							</label>
						</td>
						<td class="value">
						    <!-- <input id="createTime" name="createTime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.createTime}'/> -->
							
							<input class="inputxt" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createTime" name="createTime" ignore="ignore"value="<fmt:formatDate value='${maroMemberPage.createTime}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/>">

							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入会日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员级别:
							</label>
						</td>
						<td class="value">
						    <input id="level" name="level" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroMemberPage.level}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员级别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								积分:
							</label>
						</td>
						<td class="value">
						    <input id="memberPoints" name="memberPoints" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.memberPoints}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">积分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								余额:
							</label>
						</td>
						<td class="value">
						    <input id="balance" name="balance" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.balance}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">余额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								头像:
							</label>
						</td>
						<td class="value">
						    <input id="portrait" name="portrait" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.portrait}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">头像</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								推荐人:
							</label>
						</td>
						<td class="value">
						    <input id="recommendedUser" name="recommendedUser" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.recommendedUser}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">推荐人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								状态:
							</label>
						</td>
						<td class="value">
						    <input id="state" name="state" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.state}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								员工:
							</label>
						</td>
						<td class="value">
						    <input id="employees" name="employees" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.employees}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">员工</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证号码:
							</label>
						</td>
						<td class="value">
						    <input id="idcardnumber" name="idcardnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.idcardnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账户:
							</label>
						</td>
						<td class="value">
						    <input id="account" name="account" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.account}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账户</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								卡号:
							</label>
						</td>
						<td class="value">
						    <input id="card" name="card" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.card}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卡号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								邮箱:
							</label>
						</td>
						<td class="value">
						    <input id="email" name="email" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.email}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮箱</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								签署:
							</label>
						</td>
						<td class="value">
						    <input id="imsign" name="imsign" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.imsign}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签署</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMemberPage.memo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/users/member/maroMember.js"></script>		
