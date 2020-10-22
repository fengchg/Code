package com.maro.manager.store.purchase.service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroPurchaseServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroPurchaseEntity maroPurchase,
	        List<MaroPurchaseDetailEntity> maroPurchaseDetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroPurchaseEntity maroPurchase,
	        List<MaroPurchaseDetailEntity> maroPurchaseDetailList);
	public void delMain (MaroPurchaseEntity maroPurchase);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroPurchaseEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroPurchaseEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroPurchaseEntity t);
	/**
	 * 通过id集合进行采购申请
	 * @param ids id集合
	 * @param sUBMIT 提交状态
	 * @param aPPROVING 审批状态
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public boolean submitApprove(String ids, Integer sUBMIT, Integer aPPROVING);
	/**
	 * 通过id集合进行通过审批申请
	 * @param ids id集合
	 * @param date 当前审批时间
	 * @param wORKING 采购中
	 * @param aPPROVE_PASS 审批通过
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public boolean approvePass(String ids, Date date, Integer wORKING, Integer aPPROVE_PASS);
	/**
	 * 通过id集合进行不通过审批申请
	 * @param ids id集合
	 * @param aPPROVE_PASS
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public boolean approveNotPass(String ids, Integer aPPROVE_NOT_PASS);
	/**
	 * 入库操作
	 * @param maroPurchaseDetailList 采购详情
	 * @author gongdaohai
	 * @param date 完成时间
	 * @since v1.0 2018年3月29日
	 */
	public boolean PutInStorage(List<MaroPurchaseDetailEntity> maroPurchaseDetailList,String shopId);
	/**
	 * 检查传递过来的申请id是否满足操作条件
	 * @param ids id集合
	 * @param flag 条件状态
	 * @return true 满足 false 不满足
	 * @author gongdaohai
	 * @since v1.0,2018年4月4日
	 * @version
	 */
	public boolean check(String ids, Integer flag);
	/**
	 * 检查传递过来的申请id是否满足完成操作
	 * @param id id
	 * @param aPPROVE_PASS 审批通过
	 * @param wORKING 采购中
	 * @param fINISH 采购完成
	 * @return true 满足 false 不满足
	 * @author gongdaohai
	 * @since v1.0,2018年4月4日
	 * @version
	 */
	public boolean finishPurchase(String id, Integer aPPROVE_PASS, Integer wORKING, Integer fINISH);
	/**
	 * 检查传递过来的申请id是否满足入库操作
	 * @param id
	 * @param fINISH 完成采购
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	public boolean canPutInStore(String id, Integer fINISH);
}
