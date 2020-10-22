package com.maro.manager.store.storegoods.controller;
import com.maro.common.constant.MaterialClassConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

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
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.store.storegoods.entity.MaroStoreGoodsEntity;
import com.maro.manager.store.storegoods.service.MaroStoreGoodsServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller  
 * @Description: 仓库货物表1对多
 * @author onlineGenerator
 * @date 2018-04-27 13:56:05
 * @version V1.0   
 *
 */
@Api(value="MaroStoreGoods",description="仓库货物表1对多",tags="maroStoreGoodsController")
@Controller
@RequestMapping("/maroStoreGoodsController")
public class MaroStoreGoodsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroStoreGoodsController.class);

	@Autowired
	private MaroStoreGoodsServiceI maroStoreGoodsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;

	/**
	 * 仓库货物表1对多列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		//从仓库管理页面过来的，会带上仓库id
		String storeId=request.getParameter("storeId");
		Map m=new HashMap();
		if(storeId!=null){
			m.put("storeId", storeId);
			request.setAttribute("dictCondition", "where id='"+storeId+"'");
		}else{
			String userId = ResourceUtil.getSessionUser().getId();
			//是否为管理员，是查询所有，否查询当前的组织机构
			boolean admin = UtilService.isAdmin(userId);
			if(!admin){
				//获取用户所属部门id
				String shopId=UtilService.getShopIdByUserId(userId);
				if(shopId!=null){
					request.setAttribute("dictCondition", "where shop_id='"+shopId+"'");
				}
			}
		}
		return new ModelAndView("com/maro/manager/store/storegoods/maroStoreGoodsList",m);
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
	public void datagrid(MaroStoreGoodsEntity maroStoreGoods,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String storeId=request.getParameter("storeId");
		CriteriaQuery cq = new CriteriaQuery(MaroStoreGoodsEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroStoreGoods, request.getParameterMap());
		try{
			if(storeId!=null&&!storeId.equals("")){
				cq.eq("storeId", storeId);
			}else{
				//获取用户id
				String userId = ResourceUtil.getSessionUser().getId();
				//获取角色编码
				String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
				//验证是不是管理员的角色
				boolean admin = Util.ifRoleCode();
				if(!admin){
					//获取用户所属部门id
					String shopId=UtilService.getShopIdByUserId(userId);
					//获取用户所拥有的库仓库id集合
					List<Map> listMap=UtilService.getStoreIdsByShopId(shopId);
					List storeIds=new ArrayList();
					for(Map m:listMap){
						storeIds.add(m.get("id"));
					}
					cq.in("storeId", storeIds.toArray());
				}
			}
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroStoreGoodsService.getDataGridReturn(cq, true);
		//获取所有原料信息
		List<MaroMaterialClassEntity> maroMaterialClassEntitys = maroMaterialClassService.getList(MaroMaterialClassEntity.class);
		//给原料数量加上单位属性
		for(MaroStoreGoodsEntity m:(List<MaroStoreGoodsEntity>)dataGrid.getResults()){
			String goodsId = m.getGoodsId();
			for(MaroMaterialClassEntity mm:maroMaterialClassEntitys){
				if(mm.getId().equals(goodsId)){
					if(MaterialClassConstant.CHAILIN.equals(mm.getType())){//拆零原料
						m.setNumber(m.getNumber()+Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", mm.getScattered()));
					}else if(MaterialClassConstant.CHENGZHONG.equals(mm.getType())){//称重原料
						m.setNumber(m.getNumber()+Util.getValueFromTypeByTypeCodeAndKey("maro_weighing_unit", mm.getDenominatedUnit()));
					}else{////普通原料
						m.setNumber(m.getNumber()+Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", mm.getDenominatedUnit()));
					}
				}
				continue;
			}
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除仓库货物表1对多
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroStoreGoodsEntity maroStoreGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroStoreGoods = systemService.getEntity(MaroStoreGoodsEntity.class, maroStoreGoods.getId());
		message = "仓库货物表1对多删除成功";
		try{
			maroStoreGoodsService.delete(maroStoreGoods);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "仓库货物表1对多删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除仓库货物表1对多
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库货物表1对多删除成功";
		try{
			for(String id:ids.split(",")){
				MaroStoreGoodsEntity maroStoreGoods = systemService.getEntity(MaroStoreGoodsEntity.class, 
				id
				);
				maroStoreGoodsService.delete(maroStoreGoods);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "仓库货物表1对多删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加仓库货物表1对多
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroStoreGoodsEntity maroStoreGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库货物表1对多添加成功";
		try{
			//setid
			UUIDUtil.setId(maroStoreGoods);
			maroStoreGoodsService.save(maroStoreGoods);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "仓库货物表1对多添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新仓库货物表1对多
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroStoreGoodsEntity maroStoreGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库货物表1对多更新成功";
		MaroStoreGoodsEntity t = maroStoreGoodsService.get(MaroStoreGoodsEntity.class, maroStoreGoods.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroStoreGoods, t);
			maroStoreGoodsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "仓库货物表1对多更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 仓库货物表1对多新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroStoreGoodsEntity maroStoreGoods, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroStoreGoods.getId())) {
			maroStoreGoods = maroStoreGoodsService.getEntity(MaroStoreGoodsEntity.class, maroStoreGoods.getId());
			req.setAttribute("maroStoreGoodsPage", maroStoreGoods);
		}
		String storeId=req.getParameter("storeId");
		if(storeId!=null&&!storeId.equals("")){
			req.setAttribute("dictCondition", "where id='"+storeId+"'");
		}else{
			String userId = ResourceUtil.getSessionUser().getId();
			//是否为管理员，是查询所有，否查询当前的组织机构
			boolean admin = UtilService.isAdmin(userId);
			if(!admin){
				//获取用户所属部门id
				String shopId=UtilService.getShopIdByUserId(userId);
				if(shopId!=null){
					req.setAttribute("dictCondition", "where shop_id='"+shopId+"'");
				}
			}
		}
		return new ModelAndView("com/maro/manager/store/storegoods/maroStoreGoods-add");
	}
	/**
	 * 仓库货物表1对多编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroStoreGoodsEntity maroStoreGoods, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroStoreGoods.getId())) {
			maroStoreGoods = maroStoreGoodsService.getEntity(MaroStoreGoodsEntity.class, maroStoreGoods.getId());
			req.setAttribute("maroStoreGoodsPage", maroStoreGoods);
		}
		String storeId=req.getParameter("storeId");
		if(storeId!=null&&!storeId.equals("")){
			req.setAttribute("dictCondition", "where id='"+storeId+"'");
		}else{
			String userId = ResourceUtil.getSessionUser().getId();
			//是否为管理员，是查询所有，否查询当前的组织机构
			boolean admin = UtilService.isAdmin(userId);
			if(!admin){
				//获取用户所属部门id
				String shopId=UtilService.getShopIdByUserId(userId);
				if(shopId!=null){
					req.setAttribute("dictCondition", "where shop_id='"+shopId+"'");
				}
			}
		}
		return new ModelAndView("com/maro/manager/store/storegoods/maroStoreGoods-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroStoreGoodsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroStoreGoodsEntity maroStoreGoods,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroStoreGoodsEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroStoreGoods, request.getParameterMap());
		List<MaroStoreGoodsEntity> maroStoreGoodss = this.maroStoreGoodsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"仓库货物表1对多");
		modelMap.put(NormalExcelConstants.CLASS,MaroStoreGoodsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓库货物表1对多列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroStoreGoodss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroStoreGoodsEntity maroStoreGoods,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"仓库货物表1对多");
    	modelMap.put(NormalExcelConstants.CLASS,MaroStoreGoodsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓库货物表1对多列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
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
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<MaroStoreGoodsEntity> listMaroStoreGoodsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroStoreGoodsEntity.class,params);
				for (MaroStoreGoodsEntity maroStoreGoods : listMaroStoreGoodsEntitys) {
					maroStoreGoodsService.save(maroStoreGoods);
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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="仓库货物表1对多列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroStoreGoodsEntity>> list() {
		List<MaroStoreGoodsEntity> listMaroStoreGoodss=maroStoreGoodsService.getList(MaroStoreGoodsEntity.class);
		return Result.success(listMaroStoreGoodss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取仓库货物表1对多信息",notes="根据ID获取仓库货物表1对多信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroStoreGoodsEntity task = maroStoreGoodsService.get(MaroStoreGoodsEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取仓库货物表1对多信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建仓库货物表1对多")
	public ResponseMessage<?> create(@ApiParam(name="仓库货物表1对多对象")@RequestBody MaroStoreGoodsEntity maroStoreGoods, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroStoreGoodsEntity>> failures = validator.validate(maroStoreGoods);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroStoreGoodsService.save(maroStoreGoods);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓库货物表1对多信息保存失败");
		}
		return Result.success(maroStoreGoods);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新仓库货物表1对多",notes="更新仓库货物表1对多")
	public ResponseMessage<?> update(@ApiParam(name="仓库货物表1对多对象")@RequestBody MaroStoreGoodsEntity maroStoreGoods) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroStoreGoodsEntity>> failures = validator.validate(maroStoreGoods);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroStoreGoodsService.saveOrUpdate(maroStoreGoods);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新仓库货物表1对多信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新仓库货物表1对多信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除仓库货物表1对多")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroStoreGoodsService.deleteEntityById(MaroStoreGoodsEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓库货物表1对多删除失败");
		}

		return Result.success();
	}
}
