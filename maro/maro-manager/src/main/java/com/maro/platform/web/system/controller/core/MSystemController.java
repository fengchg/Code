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
 * 类型字段处理类
 *
 * @author 张代浩
 *
 */
//@Scope("prototype")
@Controller
@RequestMapping("/msystemController")
public class MSystemController extends SystemController {
	/**
	 * 添加部门
	 *
	 * @param depart
	 * @return
	 */
	@RequestMapping(params = "msaveDepart")
	@ResponseBody
	public AjaxJson msaveDepart(TSDepart depart, HttpServletRequest request) {
		AjaxJson json=saveDepart(depart,request);
		//数据同步
		String queueName=depart.getOrgCode();
		List<Object> list = systemService.findListbySql("SELECT * from t_s_depart t where t.ID='" + depart.getId() + "' and t.or_not_store='Y'");
		if(list.size()==1){
			try {
				MqUtil.sendTableData(queueName,"t_s_depart",list);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
