package com.maro.manager.discount.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.discount.entity.MaroDishesDiscountEntity;
import com.maro.manager.discount.page.MaroDishesDiscountPage;
import com.maro.manager.discount.service.MaroDishesDiscountServiceI;
import com.maro.manager.discountdetail.entity.MaroDishesDiscountDetailEntity;
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
import java.util.*;

/**   
 * @Title: Controller
 * @Description: 菜品打折
 * @author onlineGenerator
 * @date 2018-10-24 11:15:40
 * @version V1.0   
 *
 */
@Api(value="MaroDishesDiscount",description="菜品打折",tags="maroDishesDiscountController")
@Controller
@RequestMapping("/maroDishesDiscountController")
public class MaroDishesDiscountController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroDishesDiscountController.class);

	@Autowired
	private MaroDishesDiscountServiceI maroDishesDiscountService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;
	/**
	 * 菜品打折列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/discount/maroDishesDiscountList");
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
	public void datagrid(MaroDishesDiscountEntity maroDishesDiscount, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroDishesDiscountEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroDishesDiscount);
		try{
		//自定义追加查询条件
			//获取用户id
			String userId = ResourceUtil.getSessionUser().getId();
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			if(!admin){
				String shopId = UtilService.getShopIdByUserId(userId);
				cq.eq("shopId", shopId);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroDishesDiscountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除菜品打折
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroDishesDiscountEntity maroDishesDiscount, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroDishesDiscount = systemService.getEntity(MaroDishesDiscountEntity.class, maroDishesDiscount.getId());
		String message = "菜品打折删除成功";
		try{
			maroDishesDiscountService.delMain(maroDishesDiscount);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜品打折删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除菜品打折
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "菜品打折删除成功";
		try{
			for(String id:ids.split(",")){
				MaroDishesDiscountEntity maroDishesDiscount = systemService.getEntity(MaroDishesDiscountEntity.class,
				id
				);
				maroDishesDiscountService.delMain(maroDishesDiscount);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "菜品打折删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加菜品打折
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroDishesDiscountEntity maroDishesDiscount, MaroDishesDiscountPage maroDishesDiscountPage, HttpServletRequest request) {
		List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList =  maroDishesDiscountPage.getMaroDishesDiscountDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			UUIDUtil.setId(maroDishesDiscount,maroDishesDiscountDetailList);
			maroDishesDiscountService.addMain(maroDishesDiscount, maroDishesDiscountDetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜品打折添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新菜品打折
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroDishesDiscountEntity maroDishesDiscount,MaroDishesDiscountPage maroDishesDiscountPage, HttpServletRequest request) {
		List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList =  maroDishesDiscountPage.getMaroDishesDiscountDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			maroDishesDiscountService.updateMain(maroDishesDiscount, maroDishesDiscountDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新菜品打折失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 菜品打折新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroDishesDiscountEntity maroDishesDiscount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroDishesDiscount.getId())) {
			maroDishesDiscount = maroDishesDiscountService.getEntity(MaroDishesDiscountEntity.class, maroDishesDiscount.getId());
			req.setAttribute("maroDishesDiscountPage", maroDishesDiscount);
		}
		return new ModelAndView("com/maro/manager/discount/maroDishesDiscount-add");
	}
	
	/**
	 * 菜品打折编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroDishesDiscountEntity maroDishesDiscount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroDishesDiscount.getId())) {
			maroDishesDiscount = maroDishesDiscountService.getEntity(MaroDishesDiscountEntity.class, maroDishesDiscount.getId());
			req.setAttribute("maroDishesDiscountPage", maroDishesDiscount);
		}
		return new ModelAndView("com/maro/manager/discount/maroDishesDiscount-update");
	}
	
	
	/**
	 * 加载明细列表[详细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroDishesDiscountDetailList")
	public ModelAndView maroDishesDiscountDetailList(MaroDishesDiscountEntity maroDishesDiscount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroDishesDiscount.getId();
		//===================================================================================
		//查询-详细
	    String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
	    try{
	    	List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailEntityList = systemService.findHql(hql0,id0);
			//获取菜品中文名称
	    	List <Object[]> dishNames=systemService.findListbySql("SELECT t.id,t1.dishes_name name from maro_dishes_discount_detail t,maro_dishes t1 where t.dishes_id=t1.id and t.discount_id='"+id0+"'");
			//获取菜品规格中文名
			List <Object[]> specificationNames=systemService.findListbySql("SELECT t.id, t2.typename FROM maro_dishes_discount_detail t, maro_dishes_specifications t1, ( SELECT b.typecode, b.typename FROM t_s_typegroup a, t_s_type b WHERE a.id = b.typegroupid AND a.typegroupcode = 'maro_specifications' ) t2 WHERE t.discount_id = '"+id0+"' AND t.specifications_id = t1.id AND t1.`name` = t2.typecode");
	    	for(Object[] m:dishNames){
				String id = m[0].toString();
				for(MaroDishesDiscountDetailEntity d:maroDishesDiscountDetailEntityList){
					if(d.getId().equals(id)){
						d.setDishName(m[1].toString());
						break;
					}
				}
			}
			for(Object[] m:specificationNames){
				String id = m[0].toString();
				for(MaroDishesDiscountDetailEntity d:maroDishesDiscountDetailEntityList){
					if(d.getId().equals(id)){
						d.setSpecificationsName(m[1].toString());
						break;
					}
				}
			}
			req.setAttribute("maroDishesDiscountDetailList", maroDishesDiscountDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/maro/manager/discountdetail/maroDishesDiscountDetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroDishesDiscountEntity maroDishesDiscount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroDishesDiscountEntity.class, dataGrid);
    	//查询条件组装器
    	HqlGenerateUtil.installHql(cq, maroDishesDiscount);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroDishesDiscountEntity> list=this.maroDishesDiscountService.getListByCriteriaQuery(cq, false);
    	List<MaroDishesDiscountPage> pageList=new ArrayList<MaroDishesDiscountPage>();
        if(list!=null&&list.size()>0){
        	for(MaroDishesDiscountEntity entity:list){
        		try{
        		MaroDishesDiscountPage page=new MaroDishesDiscountPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
        	        List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailEntityList = systemService.findHql(hql0,id0);
            		page.setMaroDishesDiscountDetailList(maroDishesDiscountDetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"菜品打折");
        map.put(NormalExcelConstants.CLASS,MaroDishesDiscountPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("菜品打折列表", "导出人:Jeecg",
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
				List<MaroDishesDiscountPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroDishesDiscountPage.class, params);
				MaroDishesDiscountEntity entity1=null;
				for (MaroDishesDiscountPage page : list) {
					entity1=new MaroDishesDiscountEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroDishesDiscountService.addMain(entity1, page.getMaroDishesDiscountDetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"菜品打折");
		map.put(NormalExcelConstants.CLASS,MaroDishesDiscountPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("菜品打折列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "maroDishesDiscountController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="菜品打折列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroDishesDiscountPage>> list() {
		List<MaroDishesDiscountEntity> list= maroDishesDiscountService.getList(MaroDishesDiscountEntity.class);
    	List<MaroDishesDiscountPage> pageList=new ArrayList<MaroDishesDiscountPage>();
        if(list!=null&&list.size()>0){
        	for(MaroDishesDiscountEntity entity:list){
        		try{
        			MaroDishesDiscountPage page=new MaroDishesDiscountPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
	    			List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailOldList = this.maroDishesDiscountService.findHql(hql0,id0);
            		page.setMaroDishesDiscountDetailList(maroDishesDiscountDetailOldList);
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
	@ApiOperation(value="根据ID获取菜品打折信息",notes="根据ID获取菜品打折信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroDishesDiscountEntity task = maroDishesDiscountService.get(MaroDishesDiscountEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取菜品打折信息为空");
		}
		MaroDishesDiscountPage page = new MaroDishesDiscountPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
			List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailOldList = this.maroDishesDiscountService.findHql(hql0,id0);
    		page.setMaroDishesDiscountDetailList(maroDishesDiscountDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建菜品打折")
	public ResponseMessage<?> create(@ApiParam(name="菜品打折对象")@RequestBody MaroDishesDiscountPage maroDishesDiscountPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroDishesDiscountPage>> failures = validator.validate(maroDishesDiscountPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList =  maroDishesDiscountPage.getMaroDishesDiscountDetailList();
		
		MaroDishesDiscountEntity maroDishesDiscount = new MaroDishesDiscountEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroDishesDiscountPage,maroDishesDiscount);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存菜品打折失败");
        }
		maroDishesDiscountService.addMain(maroDishesDiscount, maroDishesDiscountDetailList);

		return Result.success(maroDishesDiscount);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新菜品打折",notes="更新菜品打折")
	public ResponseMessage<?> update(@RequestBody MaroDishesDiscountPage maroDishesDiscountPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroDishesDiscountPage>> failures = validator.validate(maroDishesDiscountPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList =  maroDishesDiscountPage.getMaroDishesDiscountDetailList();
		
		MaroDishesDiscountEntity maroDishesDiscount = new MaroDishesDiscountEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroDishesDiscountPage,maroDishesDiscount);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("菜品打折更新失败");
        }
		maroDishesDiscountService.updateMain(maroDishesDiscount, maroDishesDiscountDetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除菜品打折")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MaroDishesDiscountEntity maroDishesDiscount = maroDishesDiscountService.get(MaroDishesDiscountEntity.class, id);
			maroDishesDiscountService.delMain(maroDishesDiscount);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("菜品打折删除失败");
		}

		return Result.success();
	}
}
