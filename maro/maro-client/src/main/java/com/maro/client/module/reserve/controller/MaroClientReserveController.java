package com.maro.client.module.reserve.controller;

import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.dto.ReserveResultDTO;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 预定模块控制器接口
 * @author 冯成果
 * @date 2018-3-28
 * @since 版本号 01.00.0001
*/
public interface MaroClientReserveController {

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
     * 根据桌位ID获取预定信息列表
     * @param seatId：桌位ID
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public AjaxJson listReserveBySeatId(String seatId);


    /**
     * 取消预订
     * @param reserveId：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public AjaxJson cancelReserve(String reserveId);
}
