package com.maro.manager.shop.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.constant.DepartConstant;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.entity.ComboTree;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.shop.shop.page.MaroShopPage;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller
 * @Description: 店铺表
 * @author onlineGenerator
 * @date 2018-03-26 09:48:19
 * @version V1.0   
 *
 */
@Api(value="MaroShop",description="店铺表",tags="maroShopController")
@Controller
@RequestMapping("/maroShopController")
public class MaroShopController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroShopController.class);
	@Autowired
	private MaroShopServiceI maroShopService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private MaroDishesServiceI maroDishesService;

	/**
	 * 店铺表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/shop/shop/maroShopList");
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
	public void datagrid(MaroShopEntity maroShop,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroShopEntity.class, dataGrid);
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroShop);
		try{
		//自定义追加查询条件
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			if(!admin){
				//获取用户所属部门id
				String departId=ResourceUtil.getSessionUser().getDepartid();
				cq.eq("departId", departId);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroShopService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除店铺表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroShopEntity maroShop, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroShop = systemService.getEntity(MaroShopEntity.class, maroShop.getId());
		String message = "店铺表删除成功";
		try{
			//删除店铺时把店铺下所属的菜肴也删除
			List<MaroDishesEntity> dishesList = maroDishesService.findByProperty(MaroDishesEntity.class, "sysCompanyCode", maroShop.getId());
			for (MaroDishesEntity maroDishesEntity : dishesList) {
				maroDishesService.delMain(maroDishesEntity);
			}
			
			//修改对应部门id的状态为非店铺
			maroShopService.changeStoreTypeByDepart(maroShop.getDepartId(),DepartConstant.STORETYPE_NO);
			maroShopService.delMain(maroShop);
			
			
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "店铺表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除店铺表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "店铺表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroShopEntity maroShop = systemService.getEntity(MaroShopEntity.class,
				id
				);
				//修改对应部门id的状态为非店铺
				maroShopService.changeStoreTypeByDepart(maroShop.getDepartId(),DepartConstant.STORETYPE_NO);
				maroShopService.delMain(maroShop);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "店铺表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加店铺表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroShopEntity maroShop,MaroShopPage maroShopPage, HttpServletRequest request) {
		List<MaroShopSeatEntity> maroShopSeatList =  maroShopPage.getMaroShopSeatList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			//修改对应部门id的状态为店铺
			maroShopService.changeStoreTypeByDepart(maroShop.getDepartId(),DepartConstant.STORETYPE_YES);
			//setid
			UUIDUtil.setId(maroShop,maroShopSeatList);
			maroShopService.addMain(maroShop, maroShopSeatList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "店铺表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新店铺表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroShopEntity maroShop,MaroShopPage maroShopPage, HttpServletRequest request,String oldDepartId) {
		List<MaroShopSeatEntity> maroShopSeatList =  maroShopPage.getMaroShopSeatList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			//修改对应部门id的状态
			maroShopService.changeStoreTypeByDepart(oldDepartId,DepartConstant.STORETYPE_NO);
			//修改对应部门id的状态
			maroShopService.changeStoreTypeByDepart(maroShop.getDepartId(),DepartConstant.STORETYPE_YES);
			maroShopService.updateMain(maroShop, maroShopSeatList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新店铺表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 店铺表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroShopEntity maroShop, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroShop.getId())) {
			maroShop = maroShopService.getEntity(MaroShopEntity.class, maroShop.getId());
			req.setAttribute("maroShopPage", maroShop);
		}
		return new ModelAndView("com/maro/manager/shop/shop/maroShop-add");
	}
	
	/**
	 * 店铺表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroShopEntity maroShop, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroShop.getId())) {
			maroShop = maroShopService.getEntity(MaroShopEntity.class, maroShop.getId());
			req.setAttribute("maroShopPage", maroShop);
		}
		return new ModelAndView("com/maro/manager/shop/shop/maroShop-update");
	}
	/**
	 * 店铺表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdateFromDepart")
	public ModelAndView goUpdateFromDepart(MaroShopEntity maroShop, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroShop.getDepartId())) {
			String maroShopId=maroShopService.getShopIdByDepartId(maroShop.getDepartId());
			//有关联跳转编辑页面
			if(maroShopId!=null){
				maroShop.setId(maroShopId);
				maroShop = maroShopService.getEntity(MaroShopEntity.class, maroShop.getId());
				req.setAttribute("maroShopPage", maroShop);
				return new ModelAndView("com/maro/manager/shop/shop/maroShop-update");
			}
		}
		return null;
	}
	
	
	/**
	 * 加载明细列表[座位信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroShopSeatList")
	public ModelAndView maroShopSeatList(MaroShopEntity maroShop, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroShop.getId();
		//===================================================================================
		//查询-座位信息
	    String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
	    try{
	    	List<MaroShopSeatEntity> maroShopSeatEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("maroShopSeatList", maroShopSeatEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/maro/manager/shop/seat/maroShopSeatList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroShopEntity maroShop,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroShopEntity.class, dataGrid);
    	//查询条件组装器
    	com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroShop);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroShopEntity> list=this.maroShopService.getListByCriteriaQuery(cq, false);
    	List<MaroShopPage> pageList=new ArrayList<MaroShopPage>();
        if(list!=null&&list.size()>0){
        	for(MaroShopEntity entity:list){
        		try{
        		MaroShopPage page=new MaroShopPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
        	        List<MaroShopSeatEntity> maroShopSeatEntityList = systemService.findHql(hql0,id0);
            		page.setMaroShopSeatList(maroShopSeatEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"店铺表");
        map.put(NormalExcelConstants.CLASS,MaroShopPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("店铺表列表", "导出人:Jeecg",
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
				List<MaroShopPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroShopPage.class, params);
				MaroShopEntity entity1=null;
				for (MaroShopPage page : list) {
					entity1=new MaroShopEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroShopService.addMain(entity1, page.getMaroShopSeatList());
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
		map.put(NormalExcelConstants.FILE_NAME,"店铺表");
		map.put(NormalExcelConstants.CLASS,MaroShopPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("店铺表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "maroShopController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="店铺表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroShopPage>> list() {
		List<MaroShopEntity> list= maroShopService.getList(MaroShopEntity.class);
    	List<MaroShopPage> pageList=new ArrayList<MaroShopPage>();
        if(list!=null&&list.size()>0){
        	for(MaroShopEntity entity:list){
        		try{
        			MaroShopPage page=new MaroShopPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
	    			List<MaroShopSeatEntity> maroShopSeatOldList = this.maroShopService.findHql(hql0,id0);
            		page.setMaroShopSeatList(maroShopSeatOldList);
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
	@ApiOperation(value="根据ID获取店铺表信息",notes="根据ID获取店铺表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroShopEntity task = maroShopService.get(MaroShopEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取店铺表信息为空");
		}
		MaroShopPage page = new MaroShopPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
			List<MaroShopSeatEntity> maroShopSeatOldList = this.maroShopService.findHql(hql0,id0);
    		page.setMaroShopSeatList(maroShopSeatOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建店铺表")
	public ResponseMessage<?> create(@ApiParam(name="店铺表对象")@RequestBody MaroShopPage maroShopPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroShopPage>> failures = validator.validate(maroShopPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroShopSeatEntity> maroShopSeatList =  maroShopPage.getMaroShopSeatList();
		
		MaroShopEntity maroShop = new MaroShopEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroShopPage,maroShop);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存店铺表失败");
        }
		maroShopService.addMain(maroShop, maroShopSeatList);

		return Result.success(maroShop);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新店铺表",notes="更新店铺表")
	public ResponseMessage<?> update(@RequestBody MaroShopPage maroShopPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroShopPage>> failures = validator.validate(maroShopPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroShopSeatEntity> maroShopSeatList =  maroShopPage.getMaroShopSeatList();
		
		MaroShopEntity maroShop = new MaroShopEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroShopPage,maroShop);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("店铺表更新失败");
        }
		maroShopService.updateMain(maroShop, maroShopSeatList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除店铺表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MaroShopEntity maroShop = maroShopService.get(MaroShopEntity.class, id);
			maroShopService.delMain(maroShop);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("店铺表删除失败");
		}

		return Result.success();
	}
	
	
	/**
	 * 获取增加店铺时店铺的关联组织机构树结构
	 * @param request
	 * @author gongdaohai
	 * @since v1.0 2018年4月2日
	 */
	@RequestMapping(params = "departTree")
	@ResponseBody
	public Object departTree(HttpServletRequest request) {
		try {
			//点击的id值
			String id = request.getParameter("id");
			//获取用户组织机构id
			String departId = ResourceUtil.getSessionUser().getDepartid();
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			List<ComboTree> comboTrees =new ArrayList<ComboTree>();
			List<Map> maps=maroShopService.getComboTree(id,departId,admin);
			if(maps!=null&&maps.size()>0){
				for(Map m:maps){
					String state=m.get("state")==null?null:m.get("state").toString();
					String isstore=m.get("isstore")==null?null:m.get("isstore").toString();
					if(state!=null&&state.equals("0")){
						if(isstore!=null&&isstore.equals(DepartConstant.STORETYPE_YES)){
							continue;
						}
					}
					comboTrees.add(new ComboTree(m.get("id")==null?null:m.get("id").toString(),m.get("pid")==null?null:m.get("pid").toString(),m.get("text")==null?null:m.get("text").toString(),m.get("state")==null?null:m.get("state").toString()));
				}
			}
			return comboTrees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 检查店铺座位编号的唯一性
	 * @param number 店铺编号
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	@RequestMapping(params = "checkSeatFlagRepeat")
	@ResponseBody
	public AjaxJson checkSeatFlagRepeat(HttpServletRequest request,String shopId,String number) {
		AjaxJson j = new AjaxJson();
		try{
			boolean only=maroShopService.isOnlySeatFlag(shopId,number);
			if(!only){
				j.setSuccess(false);
				j.setMsg("编号重复了！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	/**
	 * 检查店铺编号的唯一性
	 * @param number 店铺编号
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	@RequestMapping(params = "checkShopNumberRepeat")
	@ResponseBody
	public AjaxJson checkShopNumberRepeat(HttpServletRequest request,String number) {
		AjaxJson j = new AjaxJson();
		try{
			boolean only=maroShopService.isOnlyShopNumber(number);
			if(!only){
				j.setSuccess(false);
				j.setMsg("编号重复了！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	/**
	 * 获取所有的店铺信息
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getAllShop")
	@ResponseBody
	public AjaxJson getAllShop(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try{
			List<Map> list=maroShopService.getAllShop();
			j.setObj(list);
		}catch(Exception e){
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("查询异常！");
		}
		return j;
	}
}
