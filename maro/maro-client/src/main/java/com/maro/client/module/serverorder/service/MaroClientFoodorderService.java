package com.maro.client.module.serverorder.service;

import com.maro.client.module.serverorder.pojo.dto.*;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;

import java.math.BigDecimal;
import java.util.List;

/**
 * MaroClientFoodorderDO的服务类，针对这个实体进行数据库的操作
 * @since 01.00.0001
 * @author 冯成果
 * @date 2018-03-26
 */
public interface MaroClientFoodorderService {

    /**
     * 保存点菜记录DO到数据库
     * @param MaroClientFoodorderDO 点菜记录DO
     * @return Boolean，失败falset，成功
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    Boolean saveFoodorderDO(MaroClientFoodorderDO MaroClientFoodorderDO);


    /**
     * 根据参数DTO查询出符合参数值的点菜记录列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientFoodorderDO>，成功则返回点菜记录列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientFoodorderDO> listFoodorderDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 根据ID主键获取相应的点菜记录
     * @param id 主键
     * @return MaroClientServerorderDO，成功则返回点菜记录实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientFoodorderDO getFoodorderDObyId(String id);



    /**
     * 根据服务订单ID主键获取相应的点菜记录
     * @param serverOrderId 主键
     * @return MaroClientFoodorderDO，成功则返回点菜记录实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientFoodorderDO> listFoodorderDOByServerOrderId(String serverOrderId);

    /**
     * 点餐下单
     * @param foodOrderParamsDTO：菜品接口有关的参数数据传输对象。包含参数有服务订单DO，桌位信息DO和点餐列表
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-15】进行添加
     */
    void orderFood(FoodOrderParamsDTO foodOrderParamsDTO);
    /**
     * 根据服务订单主键获取订单下所有已点的、非退菜状态的菜品总价
     * @param serverOrderId：服务订单主键
     * @return 总价格
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-15】进行添加
     */
    BigDecimal getAllFoodorderTotalPrice(String serverOrderId);

    /**
     * 换桌
     * @param seatchangeParamsDTO:桌位更换参数传输对象。服务订单DO、新桌位信息、原桌位信息
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void changeSeat(SeatchangeParamsDTO seatchangeParamsDTO);

    void mergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList);

    void cancelMergeSeat(SeatchangeParamsDTO seatchangeParamsDTO);

    BigDecimal getAllFoodorderTotalPrice(String serverorderId, String seatId);
    /**
     * 根据服务订单ID和桌位ID主键获取相应的点菜记录
     * @param serverOrderId 主键
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientFoodorderDO> listFoodorderDO(String serverOrderId, String seatId);
    /**
     * 根据点菜记录修改相应的点菜记录状态
     * @param foodId ：菜品主键
     * @param status ：状态
     * @param quantity
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    void updateStatus(String foodId, Integer status, BigDecimal quantity);
    /**
     * 催菜
     * @param foodOrderParamsDTO:菜品接口有关的参数数据传输对象。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    void UrgeFood(FoodOrderParamsDTO foodOrderParamsDTO);
    /**
     * 取消划菜
     * @param foodId：菜品主键
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    void unFinishFood(String foodId);

    /**
     * 菜品临时改价
     * @param foodOrderParamsDTO:菜品接口有关的参数数据传输对象。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void changeFoodTempPrice(FoodOrderParamsDTO foodOrderParamsDTO);
    /**
     * 查询退菜记录列表
     * @param serverorderId:服务订单主键
     * @param seatId:桌位主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    List<MaroClientFoodorderDO> listRefundFood(String serverorderId, String seatId);
    /**
     * 赠菜/换菜
     * @param foodOrderParamsDTO:菜品接口有关的参数数据传输对象。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @param status：状态，退菜还是下单
     * @param type：类型，赠菜还是普通
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void refundOrGiftFood(FoodOrderParamsDTO foodOrderParamsDTO,Integer status,Integer type);

    void changeFoodListTo(FoodOrderParamsDTO foodOrderParamsDTO);

    FoodOrderResultDTO listFoodToKitchen(String shopId, String ids);

    void updateStatus(Integer code, String foodorderId);

    MaroClientFoodorderDO getFoodorderDO(MaroClientFoodorderDO maroClientFoodorderDO);

    List<MaroClientFoodorderDO> listFoodorderDO(MaroClientFoodorderDO maroClientFoodorderDO);

    List<MaroClientFoodorderDO> listFoodorderDO(String serverOrderId, String seatId, String dishesClassificationId);

    List<MaroClientFoodorderDO> listFoodorderDOByShopId(String shopId);

    void pay(PayParamsDTO payParamsDTO);

    boolean isSeatPayed(String serverorderId, String seatId);

    List<MaroClientFoodorderDO> listMaroClientFoodorderDOForPay(PayParamsDTO payParamsDTO);

    void updateFoodOrderDeleteFlag(String payId, Integer code);

    int getTimes(FoodOrderParamsDTO foodOrderParamsDTO);
}
