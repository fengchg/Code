package com.maro.manager.dishes.dishes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.controller.UtilController;
import com.maro.manager.dishes.dishes.page.MaroDishesPage;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.dishes.materialclassification.entity.MaroMaterialClassificationEntity;
import com.maro.manager.dishes.materialclassification.service.MaroMaterialClassificationServiceI;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.service.MaroSpecificationsFoodCostsServiceI;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPriceShow;
import com.maro.manager.dishes.specificationsprice.service.MaroSpecificationsPriceServiceI;
import com.maro.manager.shop.shop.controller.MaroShopController;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.dao.ICommonDao;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ContextHolderUtils;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.pojo.base.TSDepart;
import com.maro.platform.web.system.pojo.base.TSType;
import com.maro.platform.web.system.pojo.base.TSTypegroup;
import com.maro.platform.web.system.pojo.base.TSUser;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 菜肴表
 * @author onlineGenerator
 * @date 2018-03-23 14:28:45
 * @version V1.0   
 *
 */
@Api(value="MaroDishes",description="菜肴表",tags="maroDishesController")
@Controller
@RequestMapping("/maroDishesController")
public class MaroDishesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroDishesController.class);

	@Autowired
	private MaroDishesServiceI maroDishesService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private MaroSpecificationsFoodCostsServiceI maroSpecificationsFoodCostsService;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private MaroMaterialClassificationServiceI maroMaterialClassificationService;
	@Autowired
	private MaroSpecificationsPriceServiceI maroSpecificationsPriceService;
	@Autowired
	private MaroShopServiceI maroShopService;
	@Autowired
	private ICommonDao commonDao;
	
	/**
	 * 检查编码是否存在
	 */
	@RequestMapping(params = "checkCoding")
	@ResponseBody
	public AjaxJson checkCoding(String coding,String sysCompanyCode){
		//原料分类
		AjaxJson aj = new AjaxJson();
		
		Integer codingNum = maroDishesService.checkCoding(coding,sysCompanyCode);
		
		aj.setObj(codingNum);
		return aj;
	}
	
	/**
	 * 选择原料跳转页面
	 *
	 * @return
	 */
	@RequestMapping(params = "materialSelect")
	public String materialSelect(HttpServletRequest request){
		//原料分类
		List<MaroMaterialClassificationEntity> ificationList = maroMaterialClassificationService.loadAll(MaroMaterialClassificationEntity.class);
		request.setAttribute("ificationList", ificationList);
		return "com/maro/manager/dishes/dishes/materialSelect";
	}
	
	/**
 	 * 菜肴的规格列表
 	 * maroDishesId 菜肴id
 	 */
	@RequestMapping(params = "goGetSpecificationsList")
 	public ModelAndView getSpecificationsList(HttpServletRequest request,String maroDishesId){
		try {
			//规格列表
			List<MaroDishesSpecificationsEntity> dishesSpecificationsList = maroDishesService.getSpecificationsList(maroDishesId);
			
			//规格(字典)
	        List<TSType> specificationsList = parsingDictionary("maro_specifications");
	        for(int ds=0;ds<dishesSpecificationsList.size();ds++){
	        	for(int i=0;i<specificationsList.size();i++){
	            	if(dishesSpecificationsList.get(ds).getName().equals(specificationsList.get(i).getTypecode())){
	            		dishesSpecificationsList.get(ds).setPageName(specificationsList.get(i).getTypename());
	            	}
	            }
	        	
	        	//每个规格 --- 规格成分
				List<MaroSpecificationsFoodCostsEntity> specificationsFoodCostsList = maroSpecificationsFoodCostsService.getSpecificationsIdList(dishesSpecificationsList.get(ds).getId().toString());
				if(specificationsFoodCostsList.size()>0){
					for(int i=0;i<specificationsFoodCostsList.size();i++){
						//获取原料名称
						MaroMaterialClassEntity me = maroMaterialClassService.getEntity(MaroMaterialClassEntity.class, specificationsFoodCostsList.get(i).getMaterialclassId());
						specificationsFoodCostsList.get(i).setMaterialclassName(me.getMaterialName());
						
						//获取单位名称
						//先根据原料id获取原料单位code
						String unit = maroDishesService.getDenominatedUnit(specificationsFoodCostsList.get(i).getMaterialclassId());
						String unitName = Util.getValueFromTypeByTypeCodeAndKey("maro_unit_name",unit);
						specificationsFoodCostsList.get(i).setMaterialUnitName(unitName);
					}
					dishesSpecificationsList.get(ds).setMaroSpecificationsFoodCostsList(specificationsFoodCostsList);
				}
				
				
				
				request.setAttribute("dishesSpecificationsList", dishesSpecificationsList);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("com/maro/manager/dishes/dishes/dishesSpecificationsList");
	}
	
	
	/**
	 * 菜肴规格 价格列表
	 * maroDishesId 菜肴id
	 * sysCompanyCode 所属门店 
	 */
	@RequestMapping(params = "goGetSpecificationsPirceList")
	public ModelAndView goGetSpecificationsPirceList(HttpServletRequest request,String maroDishesId,String sysCompanyCode){
		try {
			
			//每个机构（门店）
	        //List<TSDepart> tsDepartList = maroDishesService.tsDepartList();
	        //每个店铺（门店）
			List<MaroShopEntity> shopList = maroShopService.getList(MaroShopEntity.class);
			if(shopList.size() == 0){
				return new ModelAndView("com/maro/manager/dishes/dishes/dishesSpecificationsPriceList");
			}
	        
			//规格列表
			List<MaroDishesSpecificationsEntity> goGetSpecificationsPirceList = maroDishesService.getSpecificationsList(maroDishesId);
	       
	        //验证是不是管理员的角色
	        boolean maroAdmin = Util.ifRoleCode();
	        
	        for(int ds=0;ds<goGetSpecificationsPirceList.size();ds++){
	        	//把规格的字典名称匹配出来
	        	goGetSpecificationsPirceList.get(ds).setPageName(Util.getValueFromTypeByTypeCodeAndKey("maro_specifications",goGetSpecificationsPirceList.get(ds).getName()));
	        	
	        	//把会员折扣方式的字典名称匹配出来
	        	goGetSpecificationsPirceList.get(ds).setPageMemberDiscount(Util.getValueFromTypeByTypeCodeAndKey("maro_member_discoun",goGetSpecificationsPirceList.get(ds).getMemberDiscount()));
	        	
				/**
				 * 
				 * specatinsPriceShowList 所有机构（店铺）
				 * specificationsPriceList 某一个菜肴规格价格里的机构（店铺）价格
				 * 
				 * 判断
				 * 当 菜肴规格价格表里的机构id 与 某一个机构的id匹配成功时，就把菜肴规格价格表里的价格赋予 specatinsPriceShowList里
				 * 
				 */
	        	
	        	//将页面所需要的数据填充进来
		        List<SpecatinsPriceShow> specatinsPriceShowList = new ArrayList<SpecatinsPriceShow>();
		        if(maroAdmin){
		        	if(sysCompanyCode.equals("0")){//为全部门店
			        	for(int tsd=0;tsd<shopList.size();tsd++){
				    	    SpecatinsPriceShow s = new SpecatinsPriceShow();
				    	    s.setDeprtId(shopList.get(tsd).getId());//店铺id
				    	    s.setDeprtName(shopList.get(tsd).getName());//店铺名称
				    	    specatinsPriceShowList.add(s);
			        	}
		        	}else{
		        		for(int tsd=0;tsd<shopList.size();tsd++){
			        		if(sysCompanyCode.equals(shopList.get(tsd).getId())){
			        			SpecatinsPriceShow s = new SpecatinsPriceShow();
			        			s.setDeprtId(shopList.get(tsd).getId());//店铺id
					    	    s.setDeprtName(shopList.get(tsd).getName());//店铺名称
					    	    specatinsPriceShowList.add(s);
			        		}
			        	}
		        	}
		        }else{
		        	String shopId = maroShopService.getShopIdByDepartId(ResourceUtil.getSessionUser().getCurrentDepart().getId());
		        	if(shopId!=null){
			        	for(int tsd=0;tsd<shopList.size();tsd++){
			        		if(shopId.equals(shopList.get(tsd).getId())){
			        			SpecatinsPriceShow s = new SpecatinsPriceShow();
					    	    s.setDeprtId(shopList.get(tsd).getId());//店铺id
					    	    s.setDeprtName(shopList.get(tsd).getName());//店铺名称
					    	    specatinsPriceShowList.add(s);
			        		}
			        	}
		        	}
		        }
	        	
	        	
				//根据规格id获取每一个机构的价格
				List<MaroSpecificationsPriceEntity> specificationsPriceList = maroSpecificationsPriceService.entityList(goGetSpecificationsPirceList.get(ds).getId().toString());
				if(specificationsPriceList.size() > 0){
					for(int sps=0;sps<specatinsPriceShowList.size();sps++){
						
						// y 的标识是为防止，在价格表里没有店铺的记录时
						int y = 0;
						for(int sp=0;sp<specificationsPriceList.size();sp++){
							//匹配同一个机构就把价格赋予
							if(specatinsPriceShowList.get(sps).getDeprtId().equals(specificationsPriceList.get(sp).getShopId())){
								//如果价格不等于空，还是原来的值，  等于空的空就把规格表里的价格赋予
								if(!StringUtil.isEmpty(specificationsPriceList.get(sp).getPrice().toString())){
									specatinsPriceShowList.get(sps).setPrice(specificationsPriceList.get(sp).getPrice().toString());
								}else{
									specatinsPriceShowList.get(sps).setPrice(goGetSpecificationsPirceList.get(ds).getUnitPrice().toString());
								}
								//当赋值完成后可以结束当前的循环，继续下一个循环判断
								y=1;
								break;
							}
						}
						if(y==0){
							specatinsPriceShowList.get(sps).setPrice(goGetSpecificationsPirceList.get(ds).getUnitPrice().toString());
						}
						
					}
				}else{//如果整个价格表里里没有数据，把规格表里的价格赋予
					for(int sps=0;sps<specatinsPriceShowList.size();sps++){
						specatinsPriceShowList.get(sps).setPrice(goGetSpecificationsPirceList.get(ds).getUnitPrice().toString());
					}
					
				}
			
				goGetSpecificationsPirceList.get(ds).setSpecatinsPriceShow(specatinsPriceShowList);
	        }
	        request.setAttribute("goGetSpecificationsPirceList", goGetSpecificationsPirceList);
	        
         //request.setAttribute("specatinsPriceShowList", specatinsPriceShowList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("com/maro/manager/dishes/dishes/dishesSpecificationsPriceList");
	}
	
	/**
	 * 解析字典类型
	 * 类型编码 typecode 
	 * @return
	 */
	private List<TSType> parsingDictionary(String typecode){
		
		DataGrid dataGrid = new DataGrid();
		CriteriaQuery cq = new CriteriaQuery(TSTypegroup.class,dataGrid);
    	cq.eq("typegroupcode", typecode);
    	cq.add();
        this.systemService.getDataGridReturn(cq, true);
        List<TSTypegroup> typegroupList = dataGrid.getResults();
		
        //返回字典类型
		List<TSType> typeList= new ArrayList<TSType>();
        
        for (int i=0;i<typegroupList.size();i++) {
        	List<TSType> list= typegroupList.get(i).getTSTypes();
        	TSType tt = null;
	    	 for (int j=0;j<list.size();j++) {
	    		 tt = new TSType();
	    		 tt.setId(list.get(j).getId());
	    		 tt.setTypecode(list.get(j).getTypecode());
	    		 tt.setTypename(list.get(j).getTypename());
	    		 typeList.add(tt);
	    	 }
		}
		
        return typeList;
	}

	/**
	 * 菜肴表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		//机构id
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		//用户名
		String userName = ResourceUtil.getSessionUser().getUserName();
        //验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
		String replace = "全部_0,";
		if(maroAdmin){
			//admin 管理员是可以看全部的
			List<MaroShopEntity> shopList = maroShopService.getList(MaroShopEntity.class);
			if(shopList.size() > 0){
				for(int i=0;i<shopList.size();i++){
					replace = replace + shopList.get(i).getName() + "_" +  shopList.get(i).getId();
					if(i != (shopList.size() - 1)){
						replace += ",";
					}
				}
			}
		}else{
			//不是admin用户进来就看自机构下的
			MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
			if(maroShop!=null){
				replace = replace + maroShop.getName() + "_" + maroShop.getId();
			}else{
				 replace = "全部_0";
			}
		}
		
		request.setAttribute("replace", replace);
		
		request.setAttribute("userName", userName);
		request.setAttribute("departId", departId);
		return new ModelAndView("com/maro/manager/dishes/dishes/maroDishesList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(MaroDishesEntity maroDishes,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroDishesEntity.class, dataGrid);
		
		TSUser user = ResourceUtil.getSessionUser();
        //验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
		if(!maroAdmin){
			//根据部门id获取 获取店铺id
			String shopId = maroShopService.getShopIdByDepartId(user.getCurrentDepart().getId());
			
			Criterion c1 = Restrictions.or(Restrictions.eq("sysCompanyCode",shopId), Restrictions.eq("sysCompanyCode","0"));
			Criterion c2 = Restrictions.or(Restrictions.eq("sysCompanyCode",shopId), Restrictions.eq("sysCompanyCode","0"));
			cq.or(c1, c2);
		}
		
		cq.eq("type", "ordinary");
		
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroDishes);
		cq.add();
		this.maroMaterialClassService.getDataGridReturn(cq, true);
		
		//筛选自己的录入的菜肴，页面可能编辑
		List<MaroDishesEntity> mdList = dataGrid.getResults();
		for(int i=0;i<mdList.size();i++){
			if(!maroAdmin){
				String createBy = mdList.get(i).getCreateBy();
				if(!user.getUserName().equals(createBy)){
					mdList.get(i).setTf("f");
				}else{
					mdList.get(i).setTf("t");
				}
			}else{
				mdList.get(i).setTf("t");
			}
		}
		dataGrid.setResults(mdList);
		
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除菜肴表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroDishesEntity maroDishes, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroDishes = systemService.getEntity(MaroDishesEntity.class, maroDishes.getId());
		String message = "菜肴表删除成功";
		try{
			maroDishesService.delMain(maroDishes);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除菜肴表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "菜肴表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroDishesEntity maroDishes = systemService.getEntity(MaroDishesEntity.class,
				id
				);
				maroDishesService.delMain(maroDishes);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加菜肴表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroDishesEntity maroDishes,MaroDishesPage maroDishesPage, HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		String message ="";
		
		if(StringUtil.isEmpty(maroDishes.getCoding())){
			message = "菜肴表添加失败，菜肴编码不能为空";
			j.setMsg(message);
			return j;
		}
		
		if(maroDishes.getSysCompanyCode()!=null && !"".equals(maroDishes.getSysCompanyCode())){
			
		}else{
			maroDishes.setSysCompanyCode("0");
		}
		
		Integer coding = maroDishesService.checkCoding(maroDishes.getCoding(),maroDishes.getSysCompanyCode());
		if(coding >= 1){
			message = "菜肴表添加失败，菜肴编码已存在"; 
			j.setMsg(message);
			return j; 
		}
		
		List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList =  maroDishesPage.getMaroDishesSpecificationsList();
		try{
			
			UUIDUtil.setId(maroDishes,maroDishesSpecificationsList);
			maroDishesService.addMain(maroDishes, maroDishesSpecificationsList);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新菜肴表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroDishesEntity maroDishes,MaroDishesPage maroDishesPage, HttpServletRequest request) {
		List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList =  maroDishesPage.getMaroDishesSpecificationsList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			if(maroDishes.getMakeWay() == null){
				maroDishes.setMakeWay("");
			}
			if(maroDishes.getTheLabel() == null){
				maroDishes.setTheLabel("");
			}
			maroDishesService.updateMain(maroDishes, maroDishesSpecificationsList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新菜肴表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 菜肴表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroDishesEntity maroDishes, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroDishes.getId())) {
			maroDishes = maroDishesService.getEntity(MaroDishesEntity.class, maroDishes.getId());
			req.setAttribute("maroDishesPage", maroDishes);
		}
		
		//登录用户
		//String userName = ResourceUtil.getSessionUser().getUserName();
        String userName = "";
        //验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
        if(maroAdmin){
        	userName = "true";
        }else{
        	userName = "false";
        }
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		String departName = ResourceUtil.getSessionUser().getCurrentDepart().getDepartname();
		
		//店铺
		MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
		
		req.setAttribute("userName", userName);
		req.setAttribute("departId", departId);
		req.setAttribute("departName", departName);
		
		req.setAttribute("maroShop", maroShop);
		
		
		
		return new ModelAndView("com/maro/manager/dishes/dishes/maroDishes-add");
	}
	
	/**
	 * 菜肴表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroDishesEntity maroDishes, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroDishes.getId())) {
			maroDishes = maroDishesService.getEntity(MaroDishesEntity.class, maroDishes.getId());
			req.setAttribute("maroDishesPage", maroDishes);
		}
		
		//登录用户
        String userName = "";
        //验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
        if(maroAdmin){
        	userName = "true";
        }else{
        	userName = "false";
        }
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		String departName = ResourceUtil.getSessionUser().getCurrentDepart().getDepartname();
		req.setAttribute("userName", userName);
		req.setAttribute("departId", departId);
		req.setAttribute("departName", departName);
		
		//店铺
		MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
		req.setAttribute("maroShop", maroShop);
		
		return new ModelAndView("com/maro/manager/dishes/dishes/maroDishes-update");
	}
	
	
	/**
	 * 加载明细列表[规格]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroDishesSpecificationsList")
	public ModelAndView maroDishesSpecificationsList(MaroDishesEntity maroDishes, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroDishes.getId();
		//===================================================================================
		//查询-规格
	    String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
	    try{
	    	List<MaroDishesSpecificationsEntity> maroDishesSpecificationsEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("maroDishesSpecificationsList", maroDishesSpecificationsEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/maro/manager/dishes/dishesspecifications/maroDishesSpecificationsList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroDishesEntity maroDishes,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroDishesEntity.class, dataGrid);
    	//查询条件组装器
    	com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroDishes);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroDishesEntity> list=this.maroDishesService.getListByCriteriaQuery(cq, false);
    	List<MaroDishesPage> pageList=new ArrayList<MaroDishesPage>();
        if(list!=null&&list.size()>0){
        	for(MaroDishesEntity entity:list){
        		try{
        		MaroDishesPage page=new MaroDishesPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
        	        List<MaroDishesSpecificationsEntity> maroDishesSpecificationsEntityList = systemService.findHql(hql0,id0);
            		page.setMaroDishesSpecificationsList(maroDishesSpecificationsEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"菜肴表");
        map.put(NormalExcelConstants.CLASS,MaroDishesPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("菜肴表列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<MaroDishesPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroDishesPage.class, params);
				MaroDishesEntity entity1=null;
				for (MaroDishesPage page : list) {
					entity1=new MaroDishesEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroDishesService.addMain(entity1, page.getMaroDishesSpecificationsList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			return j;
	}
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"菜肴表");
		map.put(NormalExcelConstants.CLASS,MaroDishesPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("菜肴表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "maroDishesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="菜肴表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroDishesPage>> list() {
		List<MaroDishesEntity> list= maroDishesService.getList(MaroDishesEntity.class);
    	List<MaroDishesPage> pageList=new ArrayList<MaroDishesPage>();
        if(list!=null&&list.size()>0){
        	for(MaroDishesEntity entity:list){
        		try{
        			MaroDishesPage page=new MaroDishesPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
	    			List<MaroDishesSpecificationsEntity> maroDishesSpecificationsOldList = this.maroDishesService.findHql(hql0,id0);
            		page.setMaroDishesSpecificationsList(maroDishesSpecificationsOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取菜肴表信息",notes="根据ID获取菜肴表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroDishesEntity task = maroDishesService.get(MaroDishesEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取菜肴表信息为空");
		}
		MaroDishesPage page = new MaroDishesPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
			List<MaroDishesSpecificationsEntity> maroDishesSpecificationsOldList = this.maroDishesService.findHql(hql0,id0);
    		page.setMaroDishesSpecificationsList(maroDishesSpecificationsOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建菜肴表")
	public ResponseMessage<?> create(@ApiParam(name="菜肴表对象")@RequestBody MaroDishesPage maroDishesPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroDishesPage>> failures = validator.validate(maroDishesPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList =  maroDishesPage.getMaroDishesSpecificationsList();
		
		MaroDishesEntity maroDishes = new MaroDishesEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroDishesPage,maroDishes);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存菜肴表失败");
        }
		maroDishesService.addMain(maroDishes, maroDishesSpecificationsList);

		return Result.success(maroDishes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新菜肴表",notes="更新菜肴表")
	public ResponseMessage<?> update(@RequestBody MaroDishesPage maroDishesPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroDishesPage>> failures = validator.validate(maroDishesPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList =  maroDishesPage.getMaroDishesSpecificationsList();
		
		MaroDishesEntity maroDishes = new MaroDishesEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroDishesPage,maroDishes);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("菜肴表更新失败");
        }
		maroDishesService.updateMain(maroDishes, maroDishesSpecificationsList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除菜肴表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MaroDishesEntity maroDishes = maroDishesService.get(MaroDishesEntity.class, id);
			maroDishesService.delMain(maroDishes);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("菜肴表删除失败");
		}

		return Result.success();
	}
}
