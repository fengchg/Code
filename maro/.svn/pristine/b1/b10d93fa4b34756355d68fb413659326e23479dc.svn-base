package com.maro.client.module.serverorder.service;

import com.maro.client.module.serverorder.pojo.dto.*;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.web.cgform.exception.BusinessException;

import java.math.BigDecimal;
import java.util.List;

/**
 * MaroClientServerorderDO的服务类，针对这个实体进行数据库的操作
 * @since 01.00.0001
 * @author 冯成果
 * @date 2018-03-26
 */
public interface MaroClientServerorderService {

    /**
     * 保存服务订单DO到数据库
     * @param maroClientServerorderDO 服务订单DO
     * @return Boolean，失败falset，成功
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientServerorderDO saveServerOrderDO(MaroClientServerorderDO maroClientServerorderDO);


    /**
     * 根据参数DTO查询出符合参数值的服务订单列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientServerorderDO>，成功则返回服务订单列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientServerorderDO> listServerOrderDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 根据ID主键获取相应的服务订单记录
     * @param id 主键
     * @return MaroClientServerorderDO，成功则返回服务订单实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientServerorderDO getServerOrderDObyId(String id);

    /**
     * 根据ID主键获取相应的服务订单记录
     * @param id 主键
     * @return MaroClientServerorderDO，成功则返回服务订单实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    public <T> void updateServerOrderDO(MaroClientServerorderDO maroClientServerorderDO);
    /**
     * 根据ID主键获取相应的服务订单记录
     * @param id:主键
     * @param status:状态常量
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    void updateServerOrderDOStatus(String id, Integer status);

    /**
     * 查询所有正在进行的服务订单列表
     * @return 如果有则返回List<MaroClientServerorderDO>列表，否则返回size为0的空列表
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    List<MaroClientServerorderDO> listOpenServerorder();
    List<MaroClientServerorderDO> listTypeIsNullServerorder();
    /**
     * 修改订单价格
     * @param serverorderId:服务订单主键
     * @param allFoodorderTotalPrice：价格
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    void updateAmount(String serverorderId, BigDecimal foodAmount,BigDecimal payedAmount);
    /**
     * 换桌
     * @param oldSeatId：原桌位主键
     * @param newSeatId：新桌位主键
     * @param serverorderId：服务订单主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void changeSeat(SeatchangeParamsDTO seatchangeParamsDTO);

    void mergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList);

    void cancelMergeSeat(SeatchangeParamsDTO seatchangeParamsDTO) throws BusinessException;

    MaroClientServerorderDO open(MaroClientServerorderParamsDTO maroClientServerorderParamsDTO);


    /**
     * 修改订单信息
     * @param maroClientServerorderDO:服务订单DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void updateServerorder(MaroClientServerorderDO maroClientServerorderDO);

    void pay(PayParamsDTO payParamsDTO);
    /**
     * 清台
     * @param serverOrderId:服务订单主键
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void clear(String serverOrderId);

    void orderFood(FoodOrderParamsDTO foodOrderParamsDTO);

    List<MaroClientServerorderDO> listFinishedServerorder();

    void updateSendStatus(String serverorderId);

    MaroClientServerorderDO getServerOrderByOpenId(String openId);

    MaroClientServerorderDO getCurrentServerOrderBySeatId(String id);

    void updateServerOrderSeatchange(String orderId, String seatIds, String seatNames);

    MaroClientServerorderDO getServerOrderDObySeatId(MaroShopSeatEntity maroShopSeatEntity);

    List<MaroClientServerorderDO> listOpenServerorderToKitchen();

    /**
     * 更新订单表的shiftcode
     * @param shiftCode
     * @param serverorderId
     */
    void updateServerOrderDOById(String shiftCode, String serverorderId);
}
