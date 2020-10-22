package com.maro.manager.report.controller;

import com.maro.common.shop.dao.MaroCommonShopDao;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.Util;
import com.maro.manager.report.service.ReportServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * @Title: Controller
 * @Description: 菜肴表
 * @author onlineGenerator
 * @date 2018-03-23 14:28:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/reportController")
public class ReportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportController.class);

	@Autowired
	private ReportServiceI reportService;
	@Autowired
	private MaroCommonShopDao maroCommonShopDao;
	/**
	 * 查询时间段中的原料的实际和预计消耗值详情
	 *
	 * @return
	 */
	@RequestMapping(params = "materialUseInfo")
	public ModelAndView getMaterialUseInfo(HttpServletRequest request,String startTime,String endTime){
		TSDepart currentDepart = ResourceUtil.getSessionUser().getCurrentDepart();
		if(currentDepart!=null){
			//获取当前用户所属店铺
			MaroShopEntity maroShopEntity = maroCommonShopDao.getMaroShopByDepartId(currentDepart.getId());
			if(maroShopEntity!=null){
				if(startTime==null||endTime==null){//如果没有设置时间，则将时间设置为当前一个月
					startTime=Util.date2TimeStr(Util.getDateBefore(-30),"yyyy-MM-dd HH:mm:ss");
					endTime=Util.date2TimeStr(new Date(),"yyyy-MM-dd HH:mm:ss");
				}
				//查询
				List<Map> maps=reportService.getMaterialUseInfo(startTime,endTime,maroShopEntity.getId());
				Map map=new HashMap();
				map.put("result",maps);
				map.put("startTime",startTime.split(" ")[0]);
				map.put("endTime",endTime.split(" ")[0]);
				return new ModelAndView("com/maro/manager/report/materialUseInfo",map);
			}
		}
		return null;

	}
	/**
	 * 根据采购id获取采购中原料在历史一个月的平均消耗信息
	 *
	 * @return
	 */
	@RequestMapping(params = "materialHistoryUseInfo")
	public ModelAndView getMaterialHistoryUseInfo(HttpServletRequest request){
		String purchaseId = request.getParameter("purchaseId");
		String shopId = request.getParameter("shopId");
		Map map=reportService.getMaterialHistoryUseInfo(purchaseId,shopId);
		return new ModelAndView("com/maro/manager/report/historyUseInfo",map);
	}
}
