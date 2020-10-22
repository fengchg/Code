package com.maro.client.module.reserve.apply;

import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.dto.ReserveResultDTO;
import com.maro.platform.core.common.model.json.AjaxJson;

/**
 * 预定模块的总服务调用接口，当涉及模块中不同service调用时，由该接口进行统一调用，统一协同
 * 比如当需要调用不同的service去查询不同的表数据时，统一由该接口进行协同调用
 * @author 冯成果
 * @date 2018-04-14
 * @since 01.00.0001
 */
public interface MaroClientReserveApplyService {

    /**
     * 预定餐桌
     * @param reserveParamsDTO：预定餐桌传输参数，包括预定的餐桌主键、预定人、预定手机号码、预定日期等等
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public AjaxJson reserve(ReserveParamsDTO reserveParamsDTO);

    /**
     * 根据桌位ID获取预定信息
     * @param seatId：桌位ID
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    ReserveResultDTO listReserveBySeatId(String seatId);

    /**
     * 取消预订
     * @param reserveId ：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public Boolean cancelReserve(String reserveId);
    /**
     * 预定开台
     * @param reserveId：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    Boolean open(String reserveId);

    String getSeatCurrentReserve(String id);
}
