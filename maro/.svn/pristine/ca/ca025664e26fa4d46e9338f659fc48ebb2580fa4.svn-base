package com.maro.manager.birt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.service.SystemService;

import javax.servlet.http.HttpServletRequest;



/**
 * birt报表controller
 * @author Administrator
 */
@Scope("prototype")
@Controller
@RequestMapping("/birtController")
public class BirtController {
	
	@Autowired
	private SystemService systemService;

	@RequestMapping(params = "demo")
	public ModelAndView departSalary(HttpServletRequest request,String code) {
		String org_id = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		MaroShopEntity ms = systemService.findUniqueByProperty(MaroShopEntity.class,"departId",org_id);
		request.setAttribute("code", code);
		request.setAttribute("shopId", ms.getId());
		return new ModelAndView("com/maro/manager/birt/demo");
	}
	
}
