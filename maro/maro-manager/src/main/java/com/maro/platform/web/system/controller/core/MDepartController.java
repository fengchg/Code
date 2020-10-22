package com.maro.platform.web.system.controller.core;

import com.maro.common.util.MqUtil;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * 部门信息处理类
 * 
 * @author 张代浩
 * 
 */
//@Scope("prototype")
@Controller
@RequestMapping("/mdepartController")
public class MDepartController extends DepartController {

	/**
	 * 删除部门：
	 * <ul>
     *     组织机构下存在子机构时
     *     <li>不允许删除 组织机构</li>
	 * </ul>
	 * <ul>
     *     组织机构下存在用户时
     *     <li>不允许删除 组织机构</li>
	 * </ul>
	 * <ul>
     *     组织机构下 不存在子机构 且 不存在用户时
     *     <li>删除 组织机构-角色 信息</li>
     *     <li>删除 组织机构 信息</li>
	 * </ul>
	 * @return 删除的结果信息
	 */
	@RequestMapping(params = "mdel")
	@ResponseBody
	public AjaxJson mdel(TSDepart depart, HttpServletRequest request) {
		AjaxJson json =null;
		String id = depart.getId();
		String sql="SELECT t.org_code from t_s_depart t where t.ID='"+ id +"' and t.or_not_store='Y'";
		List<Object> list = systemService.findListbySql(sql);
		json=del(depart,request);
		if(list.size()==1){
			String queueName=list.get(0).toString();
			try {
				MqUtil.remoteOpt(queueName,"mqController","deleteDepart",id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
