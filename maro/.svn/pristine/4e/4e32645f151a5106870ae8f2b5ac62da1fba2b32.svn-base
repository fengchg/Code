package com.maro.manager.dishes.materialclass.controller;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesClassificationEntity;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesclassification.service.MaroDishesClassificationServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.dishesspecifications.service.MaroDishesSpecificationsServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.dishes.materialclass.page.MaroMaterialClassPage;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
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
import com.maro.platform.web.system.pojo.base.TSType;
import com.maro.platform.web.system.pojo.base.TSTypegroup;
import com.maro.platform.web.system.service.SystemService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: 原料表
 * @author onlineGenerator
 * @date 2018-03-29 16:46:35
 * @version V1.0   
 *
 */
@Api(value="MaroMaterialClass",description="原料表",tags="maroMaterialClassController")
@Controller
@RequestMapping("/maroMaterialClassController")
public class MaroMaterialClassController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroMaterialClassController.class);

	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private MaroDishesSpecificationsServiceI maroDishesSpecificationsService;
	@Autowired
	private MaroDishesServiceI maroDishesService;
	@Autowired
	private MaroDishesClassificationServiceI maroDishesClassificationService;
	@Autowired
	private MaroShopServiceI maroShopService;
	
	/**
	 * 检查编码是否存在
	 */
	@RequestMapping(params = "checkCoding")
	@ResponseBody
	public AjaxJson checkCoding(String coding){
		//原料分类
		AjaxJson aj = new AjaxJson();
		
		Integer codingNum = maroMaterialClassService.checkCoding(coding);
		
		aj.setObj(codingNum);
		return aj;
	}
	
	/**
	 * 根据菜肴id获取规格列表
	 */
	@RequestMapping(params = "getDishesIdSpecificaList")
	@ResponseBody
	public AjaxJson getDishesIdSpecificaList(String dishesId){
		AjaxJson aj = new AjaxJson();
		List<MaroDishesSpecificationsEntity> mdsList = maroDishesSpecificationsService.findByProperty(MaroDishesSpecificationsEntity.class,"maroDishesId",dishesId);
		
		//规格(字典)
        List<TSType> specificationsList = parsingDictionary("maro_specifications");
        for(int ds=0;ds<mdsList.size();ds++){
        	for(int i=0;i<specificationsList.size();i++){
            	if(mdsList.get(ds).getName().equals(specificationsList.get(i).getTypecode())){
            		mdsList.get(ds).setPageName(specificationsList.get(i).getTypename());
            		break;
            	}
            }
        }
		
		aj.setObj(mdsList);
		return aj;
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
	 * 选择菜肴跳转页面
	 *
	 * @return
	 */
	@RequestMapping(params = "dishesSelect")
	public String dishesSelect(HttpServletRequest request){
		
		//菜肴分类
		List<MaroDishesClassificationEntity> mdcList = maroDishesClassificationService.loadAll(MaroDishesClassificationEntity.class);
		request.setAttribute("mdcList", mdcList);
		
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
		
		return "com/maro/manager/dishes/materialclass/dishesSelect";
	}
	
	
	@RequestMapping(params = "dishesSelectDatagrid")
	public void datagrid(MaroDishesEntity maroDishes,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//机构id
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		//店铺id
		String shopId = maroShopService.getShopIdByDepartId(departId);
		Integer total = maroDishesService.dishesSpecificationsCount(shopId, maroDishes);
		dataGrid.setTotal(total);
		
		int page = dataGrid.getPage();
		int rows = dataGrid.getRows();
		List<MaroDishesEntity> list = maroDishesService.dishesSpecificationsList(shopId,maroDishes,page,rows);
		for(int i=0;i<list.size();i++){
			list.get(i).setSpecificationsName(Util.getValueFromTypeByTypeCodeAndKey("maro_specifications",list.get(i).getSpecificationsCode()));
		}
		
		dataGrid.setResults(list);
		
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 原料表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/dishes/materialclass/maroMaterialClassList");
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
	public void datagrid(MaroMaterialClassEntity maroMaterialClass,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroMaterialClassEntity.class, dataGrid);
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMaterialClass);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroMaterialClassService.getDataGridReturn(cq, true);
		
		List<MaroMaterialClassEntity> maroMaterialClassList = dataGrid.getResults();
		for (MaroMaterialClassEntity maroMaterialClassEntity : maroMaterialClassList) {
			if(maroMaterialClassEntity.getType().equals("0")){//拆零原料
				String denominatedUnitName = Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", maroMaterialClassEntity.getDenominatedUnit());
				maroMaterialClassEntity.setDenominatedUnitName(denominatedUnitName);
			}else if(maroMaterialClassEntity.getType().equals("1")){//普通原料
				String denominatedUnitName = Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", maroMaterialClassEntity.getDenominatedUnit());
				maroMaterialClassEntity.setDenominatedUnitName(denominatedUnitName);
			}else if(maroMaterialClassEntity.getType().equals("2")){//称重原料
				String denominatedUnitName = Util.getValueFromTypeByTypeCodeAndKey("maro_weighing_unit", maroMaterialClassEntity.getDenominatedUnit());
				maroMaterialClassEntity.setDenominatedUnitName(denominatedUnitName);
			}
		}
		
		TagUtil.datagrid(response, dataGrid);
		
	}

	/**
	 * 删除原料表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroMaterialClassEntity maroMaterialClass, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroMaterialClass = systemService.getEntity(MaroMaterialClassEntity.class, maroMaterialClass.getId());
		String message = "原料表删除成功";
		try{
			maroMaterialClassService.delMain(maroMaterialClass);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原料表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除原料表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "原料表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroMaterialClassEntity maroMaterialClass = systemService.getEntity(MaroMaterialClassEntity.class,
				id
				);
				maroMaterialClassService.delMain(maroMaterialClass);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "原料表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加原料表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroMaterialClassEntity maroMaterialClass,MaroMaterialClassPage maroMaterialClassPage, HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		String message ="";
		
		if(StringUtil.isEmpty(maroMaterialClass.getCoding())){
			message = "原料表添加失败，原料编码不能为空";
			j.setMsg(message);
			return j;
		}
		
		Integer coding = maroMaterialClassService.checkCoding(maroMaterialClass.getCoding().toString());
		if(coding >= 1){
			message = "原料表添加失败，原料编码已存在";
			j.setMsg(message);
			return j;
		}
		
		List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList =  maroMaterialClassPage.getMaroSpecificationsFoodCostsList();
		try{
			UUIDUtil.setId(maroMaterialClass,maroSpecificationsFoodCostsList);
			maroMaterialClassService.addMain(maroMaterialClass, maroSpecificationsFoodCostsList);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原料表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新原料表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroMaterialClassEntity maroMaterialClass,MaroMaterialClassPage maroMaterialClassPage, HttpServletRequest request) {
		List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList =  maroMaterialClassPage.getMaroSpecificationsFoodCostsList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			maroMaterialClassService.updateMain(maroMaterialClass, maroSpecificationsFoodCostsList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新原料表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 原料表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroMaterialClassEntity maroMaterialClass, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMaterialClass.getId())) {
			maroMaterialClass = maroMaterialClassService.getEntity(MaroMaterialClassEntity.class, maroMaterialClass.getId());
			req.setAttribute("maroMaterialClassPage", maroMaterialClass);
		}
		return new ModelAndView("com/maro/manager/dishes/materialclass/maroMaterialClass-add");
	}
	
	/**
	 * 原料表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroMaterialClassEntity maroMaterialClass, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMaterialClass.getId())) {
			maroMaterialClass = maroMaterialClassService.getEntity(MaroMaterialClassEntity.class, maroMaterialClass.getId());
			req.setAttribute("maroMaterialClassPage", maroMaterialClass);
		}
		return new ModelAndView("com/maro/manager/dishes/materialclass/maroMaterialClass-update");
	}
	
	
	/**
	 * 加载明细列表[规格成本]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroSpecificationsFoodCostsList")
	public ModelAndView maroSpecificationsFoodCostsList(MaroMaterialClassEntity maroMaterialClass, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroMaterialClass.getId();
		//===================================================================================
		//查询-规格成本
	    String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
	    try{
	    	List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsEntityList = systemService.findHql(hql0,id0);
	    	
	    	//规格(字典)
	        //List<TSType> specificationsList = parsingDictionary("maro_specifications");

	    	for (MaroSpecificationsFoodCostsEntity entity : maroSpecificationsFoodCostsEntityList) {
	    		//根据规格id获取数据
	    		MaroDishesSpecificationsEntity ds = maroDishesSpecificationsService.getEntity(MaroDishesSpecificationsEntity.class,entity.getSpecificationsId());
	    		entity.setSpecificationsCode(ds.getSpecificationsCode());
	    		entity.setSpecificationsName(Util.getValueFromTypeByTypeCodeAndKey("maro_specifications",ds.getSpecificationsCode()));
	    		
	    		//根据菜肴id获取数据
	    		MaroDishesEntity dishes = maroDishesService.getEntity(MaroDishesEntity.class, ds.getMaroDishesId());
	    		entity.setDishesId(dishes.getId());
	    		entity.setDishesName(dishes.getDishesName());
	    		
	    		entity.setDishesUnit(Util.getValueFromTypeByTypeCodeAndKey("maro_unit_name",dishes.getUnit()));
	    		
	    		//根据菜肴id获取规格列表
	    		//List<MaroDishesSpecificationsEntity> mdsList = maroDishesSpecificationsService.findByProperty(MaroDishesSpecificationsEntity.class,"maroDishesId",ds.getMaroDishesId());
	    		//List<Specifications> sList = new ArrayList<Specifications>();
	    		/*for (MaroDishesSpecificationsEntity mds : mdsList) {
	    			Specifications s = new Specifications();
	    			s.setId(mds.getId().toString());
	    			
	    			for(int i=0;i<specificationsList.size();i++){
	    				if(mds.getName().equals(specificationsList.get(i).getTypecode())){
	    					s.setPageName(specificationsList.get(i).getTypename());
	    				}
	    			}

	    			sList.add(s);
	    			entity.setSpecificationsList(sList);
				}*/
	    	}
	    	
	    	
			req.setAttribute("maroSpecificationsFoodCostsList", maroSpecificationsFoodCostsEntityList);
		}catch(Exception e){
			//logger.info(e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("com/maro/manager/dishes/specificationsfoodcosts/maroSpecificationsFoodCostsList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroMaterialClassEntity maroMaterialClass,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroMaterialClassEntity.class, dataGrid);
    	//查询条件组装器
    	com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMaterialClass);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroMaterialClassEntity> list=this.maroMaterialClassService.getListByCriteriaQuery(cq, false);
    	List<MaroMaterialClassPage> pageList=new ArrayList<MaroMaterialClassPage>();
        if(list!=null&&list.size()>0){
        	for(MaroMaterialClassEntity entity:list){
        		try{
        		MaroMaterialClassPage page=new MaroMaterialClassPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
        	        List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsEntityList = systemService.findHql(hql0,id0);
            		page.setMaroSpecificationsFoodCostsList(maroSpecificationsFoodCostsEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"原料表");
        map.put(NormalExcelConstants.CLASS,MaroMaterialClassPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("原料表列表", "导出人:Jeecg",
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
				List<MaroMaterialClassPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroMaterialClassPage.class, params);
				MaroMaterialClassEntity entity1=null;
				for (MaroMaterialClassPage page : list) {
					entity1=new MaroMaterialClassEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroMaterialClassService.addMain(entity1, page.getMaroSpecificationsFoodCostsList());
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
		map.put(NormalExcelConstants.FILE_NAME,"原料表");
		map.put(NormalExcelConstants.CLASS,MaroMaterialClassPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("原料表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "maroMaterialClassController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="原料表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroMaterialClassPage>> list() {
		List<MaroMaterialClassEntity> list= maroMaterialClassService.getList(MaroMaterialClassEntity.class);
    	List<MaroMaterialClassPage> pageList=new ArrayList<MaroMaterialClassPage>();
        if(list!=null&&list.size()>0){
        	for(MaroMaterialClassEntity entity:list){
        		try{
        			MaroMaterialClassPage page=new MaroMaterialClassPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
	    			List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsOldList = this.maroMaterialClassService.findHql(hql0,id0);
            		page.setMaroSpecificationsFoodCostsList(maroSpecificationsFoodCostsOldList);
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
	@ApiOperation(value="根据ID获取原料表信息",notes="根据ID获取原料表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroMaterialClassEntity task = maroMaterialClassService.get(MaroMaterialClassEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取原料表信息为空");
		}
		MaroMaterialClassPage page = new MaroMaterialClassPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
			List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsOldList = this.maroMaterialClassService.findHql(hql0,id0);
    		page.setMaroSpecificationsFoodCostsList(maroSpecificationsFoodCostsOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建原料表")
	public ResponseMessage<?> create(@ApiParam(name="原料表对象")@RequestBody MaroMaterialClassPage maroMaterialClassPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMaterialClassPage>> failures = validator.validate(maroMaterialClassPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList =  maroMaterialClassPage.getMaroSpecificationsFoodCostsList();
		
		MaroMaterialClassEntity maroMaterialClass = new MaroMaterialClassEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroMaterialClassPage,maroMaterialClass);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存原料表失败");
        }
		maroMaterialClassService.addMain(maroMaterialClass, maroSpecificationsFoodCostsList);

		return Result.success(maroMaterialClass);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新原料表",notes="更新原料表")
	public ResponseMessage<?> update(@RequestBody MaroMaterialClassPage maroMaterialClassPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMaterialClassPage>> failures = validator.validate(maroMaterialClassPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList =  maroMaterialClassPage.getMaroSpecificationsFoodCostsList();
		
		MaroMaterialClassEntity maroMaterialClass = new MaroMaterialClassEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroMaterialClassPage,maroMaterialClass);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("原料表更新失败");
        }
		maroMaterialClassService.updateMain(maroMaterialClass, maroSpecificationsFoodCostsList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除原料表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MaroMaterialClassEntity maroMaterialClass = maroMaterialClassService.get(MaroMaterialClassEntity.class, id);
			maroMaterialClassService.delMain(maroMaterialClass);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("原料表删除失败");
		}

		return Result.success();
	}
	/**
	 * 通过原料id获取原料的单位类型
	 * @param request
	 * @param response
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月2日
	 * @version
	 */
	@RequestMapping(params = "getTypeByClassId")
	@ResponseBody
	public AjaxJson getTypeByClassId(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try {
			String materialClassId = request.getParameter("materialClassId");
			//通过原料id获取原料对象
			MaroMaterialClassEntity maroMaterialClassEntity=maroMaterialClassService.get(MaroMaterialClassEntity.class,materialClassId);
			//获取计价单位
			String priceUnit = "";
			if(maroMaterialClassEntity.getType().equals("2")){
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_weighing_unit", maroMaterialClassEntity.getDenominatedUnit());
			}else{
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", maroMaterialClassEntity.getDenominatedUnit());
			}
			j.setObj(priceUnit);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
}
