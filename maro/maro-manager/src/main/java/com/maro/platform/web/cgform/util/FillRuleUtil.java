package com.maro.platform.web.cgform.util;

import com.maro.platform.core.util.ApplicationContextUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.IFillRuleHandler;
import com.maro.platform.web.cgform.entity.fillrule.TSFillRuleEntity;
import com.maro.platform.web.cgform.service.fillrule.TSFillRuleServiceI;

/**
 * 规则值自动生成工具类
 * @举例： 自动生成订单号；自动生成当前日期
 * @author qinfeng
 *
 */
public class FillRuleUtil {

	/**
	 * 
	 * @param ruleCode ruleCode
	 * @return 
	 */
	public static Object executeRule(String ruleCode){
		if(StringUtil.isEmpty(ruleCode))return null;
		Object obj=null;
		try {
			TSFillRuleServiceI ruleServiceI = ApplicationContextUtil.getContext().getBean(TSFillRuleServiceI.class);
			TSFillRuleEntity ruleEntity = ruleServiceI.findUniqueByProperty(TSFillRuleEntity.class, "ruleCode", ruleCode);
			if(ruleEntity!=null){
				IFillRuleHandler ruleHandler = (IFillRuleHandler) Class.forName(ruleEntity.getRuleClass()).newInstance();
				obj=ruleHandler.execute(ruleEntity.getRuleParam());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
