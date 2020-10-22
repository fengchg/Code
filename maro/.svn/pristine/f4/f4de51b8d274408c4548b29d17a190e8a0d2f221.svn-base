package com.maro.client.module.reserve.service;

import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;

import java.util.List;

/**
 * 预定记录接口，主要提供了对预定记录（主表）的操作
 * @author 冯成果
 * @date 2018-04-14
 * @since 01.00.0001
 */
public interface MaroClientReserveService {

    /**
     * 预定餐桌
     * @param reserveParamsDTO ：预定餐桌传输参数，包括预定的餐桌主键、预定人、预定手机号码、预定日期等等
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public MaroClientReserveDO save(ReserveParamsDTO reserveParamsDTO);

    /**
     * 根据桌位ID获取预定信息列表
     * @param seatId：桌位ID
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    List<MaroClientReserveDO> listReserveBySeatId(String seatId);


    /**
     * 取消预订
     * @param reserveId：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public void cancelReserve(String reserveId);

    /**
     * 预定开台
     * @param reserveId：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    void open(String reserveId);

    String getSeatCurrentReserve(String seatId);
}
