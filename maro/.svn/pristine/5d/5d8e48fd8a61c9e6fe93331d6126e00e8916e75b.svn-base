package com.maro.manager.report.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 店铺查询层
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
@Repository
public interface ReportDao {
	
	@Arguments("purchaseId")
	@Sql("SELECT t.material_class_id classId,t1.material_name name,t1.type,t1.scattered_number scattered,t.plan_number number from maro_purchase_detail t,maro_material_class t1 where t.material_class_id=t1.id and t.purchase_id=:purchaseId")
	List<Map> getPurchaseDetail(String purchaseId);

	@Arguments({"ids","shopId"})
	List<Map> getMonthUseInfo(List ids,String shopId);

	@Arguments({"startTime","endTime","shopId","flag"})
	List<Map> getMaterialRealUseInfo(String startTime, String endTime,String shopId,int flag);

	@Arguments({"startTime","endTime","shopId","flag"})
	List<Map> getMaterialPlanUseInfo(String startTime, String endTime,String shopId,int flag);

	@Arguments("shiftCode")
    List<Map> getBaseInfos(String shiftCode);

	@Arguments("shiftCode")
	List<Map> getMenuInfos(String shiftCode);

	@Arguments("shiftCode")
	List<Map> getShouKuangInfo(String shiftCode);

	@Arguments("shiftCode")
	List<Map> getAreaInfo(String shiftCode);

	@Arguments("shiftCode")
    Map getSmallInfo(String shiftCode);

	@Arguments({"userId","shiftCode"})
    Map getLoginTime(String userId, String shiftCode);

	@Arguments({"check","shiftCode"})
	@Sql("UPDATE maro_client__serverorder SET is_check = :check WHERE DATE_FORMAT(NOW(), '%Y-%m-%d') = FROM_UNIXTIME(end_time / 1000, '%Y-%m-%d') AND shift_code =:shiftCode")
	void setCheckOfServerOrder(Integer check,String shiftCode);

	@Arguments({"check","shiftCode"})
	@Sql("UPDATE maro_client_shift SET is_check = :check WHERE DATE_FORMAT(NOW(), '%Y-%m-%d') = DATE_FORMAT(login_time, '%Y-%m-%d') AND shift_code =:shiftCode")
	void setCheckClientShift(Integer check, String shiftCode);
}
