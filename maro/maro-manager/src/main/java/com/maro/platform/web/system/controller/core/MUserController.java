package com.maro.platform.web.system.controller.core;

import com.maro.common.util.MqUtil;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: UserController
 * @Description: TODO(用户管理处理类)
 * @author 张代浩
 */
//@Scope("prototype")
@Controller
@RequestMapping("/muserController")
public class MUserController extends UserController {

	@RequestMapping(params = "mdelete")
	@ResponseBody
	public AjaxJson mdelete(TSUser user, @RequestParam String deleteType, HttpServletRequest req) {
		if (deleteType.equals("delete")) {
			return this.mdel(user, req);
		}else if (deleteType.equals("deleteTrue")) {
			return this.mtrueDel(user, req);
		}else{
			AjaxJson j = new AjaxJson();

			j.setMsg("删除逻辑参数异常,请重试.");
			return j;
		}
	}
	/**
	 * 用户信息录入和更新
	 *
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "mdel")
	@ResponseBody
	public AjaxJson mdel(TSUser user, HttpServletRequest req) {
		AjaxJson json=del(user, req);
		//同步数据
		String id = user.getId();
		String orgCode="";
		List baseUsers=null;
		//获取所属机构code
		List<Object> orgCodes = systemService.findListbySql("select t2.org_code  from t_s_base_user t,t_s_user_org t1,t_s_depart t2 where  t.id=t1.user_id and t1.org_id=t2.ID and t.ID='" + id + "' and t2.or_not_store='Y'");
		if(orgCodes!=null&&orgCodes.size()==1){
			orgCode=orgCodes.get(0).toString();
			if(!orgCode.equals("")){
				//t_s_base_user
				baseUsers=systemService.findListbySql("select  * from t_s_base_user t where t.ID='"+id+"'");
				try {
					MqUtil.sendTableData(orgCode,"t_s_base_user",baseUsers);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return json;
	}

	/**
	 * 真实删除
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "mtrueDel")
	@ResponseBody
	public AjaxJson mtrueDel(TSUser user, HttpServletRequest req) {
		AjaxJson json =null;
		//同步数据
		String id = user.getId();
		String orgCode="";
		//获取所属机构code
		String sql="select t2.org_code  from t_s_base_user t,t_s_user_org t1,t_s_depart t2 where  t.id=t1.user_id and t1.org_id=t2.ID and t.ID='" + id + "' and t2.or_not_store='Y'";
		List<Object> orgCodes = systemService.findListbySql(sql);
		if(orgCodes!=null&&orgCodes.size()==1){
			orgCode=orgCodes.get(0).toString();
		}
		json=trueDel(user,req);
		if(!orgCode.equals("")){
			try {
				MqUtil.remoteOpt(orgCode,"mqController","deleteUser",id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json;
	}

	/**
	 * 用户录入
	 *
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "msaveUser")
	@ResponseBody
	public AjaxJson msaveUser(HttpServletRequest req, TSUser user) {
		AjaxJson json = saveUser(req,user);
		//数据同步
		String id = user.getId();
		String orgCode="";
		//获取所属机构code
		List<Object> orgCodes = systemService.findListbySql("select t2.org_code  from t_s_base_user t,t_s_user_org t1,t_s_depart t2 where  t.id=t1.user_id and t1.org_id=t2.ID and t.ID='" + id + "' and t2.or_not_store='Y'");
		if(orgCodes!=null&&orgCodes.size()==1){
			orgCode=orgCodes.get(0).toString();
			if(!orgCode.equals("")){
				//t_s_base_user
				List baseUsers=systemService.findListbySql("select  * from t_s_base_user t where t.ID='"+id+"'");
				//t_s_user
				List sUser=systemService.findListbySql("select  * from t_s_user t where t.ID='"+id+"'");
				//t_s_user_org
				List userOrg=systemService.findListbySql("select * from t_s_user_org t where t.user_id='"+id+"'");
				//t_s_role
				List sRole=systemService.findListbySql("select * from t_s_role");
				//t_s_role_user
				List roleUser=systemService.findListbySql("SELECT * from t_s_role_user t where t.userid='"+id+"'");
				try {
					MqUtil.sendTableData(orgCode,"t_s_base_user",baseUsers);
					MqUtil.sendTableData(orgCode,"t_s_user",sUser);
					MqUtil.sendTableData(orgCode,"t_s_user_org",userOrg);
					MqUtil.sendTableData(orgCode,"t_s_role",sRole);
					MqUtil.sendTableData(orgCode,"t_s_role_user",roleUser);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return json;
	}
}