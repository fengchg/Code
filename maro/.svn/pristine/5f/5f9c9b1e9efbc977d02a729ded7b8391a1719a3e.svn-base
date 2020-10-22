package com.maro.manager.demoJu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.dishes.dishes.service.MaroCommonDishesServiceI;
import com.maro.platform.core.common.model.json.AjaxJson;

@Scope("prototype")
@Controller
@RequestMapping("/demoJuController")
public class DemoJuController {
	@Autowired
	private MaroCommonDishesServiceI maroDishesServiceI;
	
	@RequestMapping(params = "demo")
	@ResponseBody
	public AjaxJson departSalary(HttpServletRequest request,String code) {
		AjaxJson aj = new AjaxJson();
		List<MaroDishesEntity> getDishesList = maroDishesServiceI.getDishesList("32c4e41832bf4e8d8bb85e1c698d6fca");
		for (MaroDishesEntity maroDishesEntity : getDishesList) {
			System.out.println(maroDishesEntity.getDishesName());
		}
		aj.setObj(getDishesList);
		return aj;
	}

}
