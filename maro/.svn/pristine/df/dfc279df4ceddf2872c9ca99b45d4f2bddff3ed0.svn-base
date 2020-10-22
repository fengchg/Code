package com.maro.manager.report.service;

import com.maro.platform.core.common.service.CommonService;

import java.util.List;
import java.util.Map;

/**
 * 店铺模块接口
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
public interface ReportServiceI extends CommonService {
    /**
     * 根据采购id获取采购中原料在历史一个月的平均消耗信息
     * @param purchaseId
     * @return
     */
    Map getMaterialHistoryUseInfo(String purchaseId,String shopId);

    /**
     * 查询时间段中的原料的实际和预计消耗值
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map> getMaterialUseInfo(String startTime, String endTime, String shopId);

    /**
     * 打印营业报表
     * @param shiftCode
     * @param name
     * @return
     */
    boolean printBusReport(String shiftCode, String name, String userId);

    /**
     * 获取交班信息
     * @param shiftCode
     * @param name
     * @return
     */
    Map getShiftInfo(String shiftCode, String name, String userId);
}
